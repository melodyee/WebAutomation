package zerozero.com.preorder.test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import zerozero.com.preorder.test.common.ConfReader;
import zerozero.com.preorder.test.common.Locators;
import zerozero.com.preorder.test.common.Page.PreOderPage;
import zerozero.com.preorder.test.common.WD;
import zerozero.com.preorder.test.common.object.OrderInfo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by yangfan on 16/3/15.
 */
public class TestPreoderPage {
    WebDriver wd;
    private ConfReader confReader;
    private static PreOderPage orderPage;

    public TestPreoderPage(){
        confReader = new ConfReader();
    }


    @BeforeSuite
    public void setupBeforeSuite(){
        wd = WD.getWebDriverIns("firefox");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().setSize(new Dimension(1280, 800));
        orderPage = new PreOderPage(wd);
    }

    @BeforeMethod
    public void initBeforeMethod(){
        wd.get(Locators.preorderURL);
        boolean isOpened = orderPage.isPageOpenedCorrectly();
        assertTrue("ERROR! Access to preorder page is  not successfully.",isOpened);
    }

    @AfterSuite
    public void cleanAfterSuite(){
        wd.close();
    }

    @DataProvider(name="TaxRate")
    public Object[][] generateTaxRateMap(){
        Object[][] obj = new Object[1][1];
        Map<String,Double> rateMap = new HashMap<>();
        try {
            String rateDir = getClass().getResource("/taxRate.xls").getPath();
            InputStream input = new FileInputStream(rateDir);
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFSheet sheetSec = wb.getSheetAt(1);
            int firstRowCount = sheet.getFirstRowNum();
            int lastRowCount = sheet.getLastRowNum();
            for (int i=firstRowCount+1;i<=lastRowCount;i++){
                sheet.getRow(i).getCell(1).setCellType(1);
                String pCode = sheet.getRow(i).getCell(1).getStringCellValue();
                Double rate = sheet.getRow(i).getCell(4).getNumericCellValue();
                rateMap.put(pCode,rate);
            }

            int firstRowCountForSec = sheetSec.getFirstRowNum();
            int lastRowCountForSec = sheetSec.getLastRowNum();
            for (int i=firstRowCountForSec+1;i<lastRowCountForSec;i++){
                sheetSec.getRow(i).getCell(0).setCellType(1);
                String pCode = sheetSec.getRow(i).getCell(0).getStringCellValue();
                Double rate = sheetSec.getRow(i).getCell(1).getNumericCellValue();
                rateMap.put(pCode,rate);
            }
            obj[0][0] = rateMap;

        } catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    @DataProvider(name="PageData")
    public Object[][] generatePreoderData(){
        JSONArray objArray = confReader.readDataConf(confReader.json_testdata);
        Object[][] testData = new Object[objArray.length()][5];

        try {
            for (int i=0;i<objArray.length();i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JSONObject jsonObject = objArray.getJSONObject(i);

                boolean isJump = jsonObject.getBoolean("isJunmpToResultPage");
                boolean isExpectedSuc = jsonObject.getBoolean("isExpectSuccess");
                String caseDes = jsonObject.getString("description");
                JSONArray errJsonList = jsonObject.getJSONArray("expectedErrorList");
                String[] errList = new String[errJsonList.length()];
                for(int j=0;j<errJsonList.length();j++){
                    //String errStr = objectMapper.readValue(errJsonList.get(j).toString(), String.class);
                    String errStr = errJsonList.get(j).toString();
                    errList[j] = errStr;
                }
                OrderInfo orderInfo = objectMapper.readValue(jsonObject.getJSONObject("page_data").toString()
                                                                                                , OrderInfo.class);
                Object[] singleData = new Object[]{orderInfo,caseDes,isExpectedSuc,isJump,errList};
                testData[i] = singleData;
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        return testData;
    }


    /**
     *
     * @param order object contains all info to fill in pre-order page
     * @param caseDes show what this case test for
     * @param isSuc whether this case expected to order successfully
     * @param isJump whether will jump to result page after click order
     * @param errList expected err info  should be shown
     */
    @Test(dataProvider = "PageData")
    public void testOrderHover(OrderInfo order,String caseDes,boolean isSuc,boolean isJump,String[] errList){
        System.out.println("##########################################################");
        System.out.println("This case is for " + caseDes);
        boolean isPriceRight = orderPage.fillOrderInfoInPage(order);
        assertTrue("FAILURE! The calculation for price is not correct before submit order" ,isPriceRight);

        Double productCost = Double.valueOf(orderPage.getPriceCost().getText());
        Double shipFee = Double.valueOf(orderPage.getShip().getText());
        Double tax = Double.valueOf(orderPage.getTax().getText());
        Double disCount = Double.valueOf(orderPage.getDisCount().getText());
        Double total = Double.valueOf(orderPage.getTotalCost().getText());

        boolean isExpected;
        if (isSuc){
            isExpected = orderPage.verifySucOrder(order,productCost,disCount,tax,shipFee,total);
        } else if(isJump){
            isExpected = orderPage.verifyFailOrderInResPage(order,productCost,disCount,tax,shipFee,total,errList);
        } else {
            isExpected = orderPage.verifyFailButNotJump(errList);
        }
        assertTrue("FAILURE! Behavior of order with given info is not expected",isExpected);

    }

    @Test(dataProvider="TaxRate")
    public void testTaxRate(Map<String,Double> rateMap){
        boolean isTaxRight = true;
        Random rand = new Random();
        List<Integer> failInFirstRun = new ArrayList<>();
        for(int i=90000;i<96199;i++){
            try {
                orderPage.getPostalCode().clear();
                orderPage.getPostalCode().sendKeys(String.valueOf(i));
                int quantity = rand.nextInt(10) + 1;
                orderPage.getQuantity().selectByValue(String.valueOf(quantity));
                int disCount = Integer.valueOf(orderPage.getDisCount().getText());


                TimeUnit.MILLISECONDS.sleep(1000);
                Double actualTax = Double.valueOf(orderPage.getTax().getText());
                String mapkey = String.valueOf(i);
                Double rate = rateMap.get(mapkey);
                if (null == rate) {
                    rate = rateMap.get(mapkey.substring(0, 3));
                }

                if (null == rate ) {
                    if(0 != actualTax) {
                        failInFirstRun.add(i);
                    }
//                    isTaxRight = false;
//                    System.out.println("ERROR! With postal code " + i
//                            + " there is no mapping rate, but tax is not 0 ,tax is " + actualTax);
                    continue;
                }
                Double expectTax = (quantity * Locators.singlePriceForProduct-disCount) * rate;
                if (Math.abs(expectTax - actualTax) >= 0.01) {
                    failInFirstRun.add(i);
//                    isTaxRight = false;
//                    System.out.println("ERROR! With postal code " + i + " and quantity is " + quantity
//                            + " actual tax is " + actualTax +
//                            " but expected tax is " + expectTax + " . The rate is " + rate);
                }
            } catch (Exception e){
                //e.printStackTrace();
                failInFirstRun.add(i);
            }

        }

        System.out.println("There are " + failInFirstRun.size() + " fail to first time check and " +
                                "will check them second time");
        for(int i=0;i<failInFirstRun.size();i++){
            try {
                orderPage.getPostalCode().clear();
                orderPage.getPostalCode().sendKeys(String.valueOf(failInFirstRun.get(i)));
                int quantity = rand.nextInt(10) + 1;
                orderPage.getQuantity().selectByValue(String.valueOf(quantity));
                int disCount = Integer.valueOf(orderPage.getDisCount().getText());

                TimeUnit.MILLISECONDS.sleep(1500);
                Double actualTax = Double.valueOf(orderPage.getTax().getText());
                String mapkey = String.valueOf(failInFirstRun.get(i));
                Double rate = rateMap.get(mapkey);
                if (null == rate) {
                    rate = rateMap.get(mapkey.substring(0, 3));
                }

                if (null == rate ) {
                    if(0 != actualTax) {
                        isTaxRight = false;
                        System.out.println("ERROR! With postal code " + failInFirstRun.get(i)
                                + " there is no mapping rate, but tax is not 0 ,tax is " + actualTax);
                    }
                    continue;
                }
                Double expectTax = (quantity * Locators.singlePriceForProduct-disCount)* rate;
                if (Math.abs(expectTax - actualTax) >= 0.01) {
                    isTaxRight = false;
                    System.out.println("ERROR! With postal code " + failInFirstRun.get(i)
                            + " and quantity is " + quantity
                            + " actual tax is " + actualTax +
                            " but expected tax is " + expectTax + " . The rate is " + rate);
                }
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("ERROR! Postal code " +  failInFirstRun.get(i) + " fail with exception.");
                isTaxRight = false;
            }

        }
        assertTrue("FAILURE! There are some error in rate calculation ,please check the log.",isTaxRight);
    }
}
