package zerozero.com.preorder.test.common.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import zerozero.com.preorder.test.common.Locators;
import zerozero.com.preorder.test.common.object.OrderInfo;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangfan on 16/3/15.
 */
public class PreOderPage {
    private WebDriver wd;
    private ResultPage resPage;

    private WebElement preorderTitle;
    private WebElement email;
    private Select quantity;

    private WebElement cardNum;
    private WebElement cvc;
    private WebElement expireMon;
    private WebElement expireYear;

    private WebElement name;
    private WebElement line1;
    private WebElement line2;
    private WebElement city;
    private WebElement state;
    private WebElement postalCode;
    private Select country;

    private WebElement checkAgree;
    private WebElement orderButton;
    private List<WebElement>  errorInfo;

    private WebElement priceCost;
    private WebElement disCount;
    private WebElement tax;
    private WebElement ship;
    private WebElement totalCost;

    public PreOderPage(WebDriver wd){
        this.wd = wd;
        resPage = new ResultPage(wd);
    }

    public WebElement getPriceCost() {
        //if(null == priceCost){
            priceCost = wd.findElement(By.xpath(Locators.productCost));
        //}
        return priceCost;
    }

    public WebElement getDisCount() {
        //if(null == disCount){
            disCount = wd.findElement(By.xpath(Locators.disCount));
        //}
        return disCount;
    }

    public WebElement getTax() {
        //if(null == tax){
            tax = null;
            tax = wd.findElement(By.xpath(Locators.tax));
        //}
        return tax;
    }

    public WebElement getShip() {
        //if(null == ship){
            ship = wd.findElement(By.xpath(Locators.shippingFee));
        //}
        return ship;
    }

    public WebElement getTotalCost() {
        //if(null == totalCost){
            totalCost = wd.findElement(By.xpath(Locators.total));
        //}
        return totalCost;
    }

    public WebElement getPreorderTitle(){
        //if(null == preorderTitle){
            preorderTitle = wd.findElement(By.xpath(Locators.orderTitle));
        //}
        return preorderTitle;
    }

    public WebElement getEmail() {
        if (null == email){
            email = wd.findElement(By.xpath(Locators.email));
        }
        return email;
    }

    public Select getQuantity() {
        if (null == quantity){
            quantity = new Select(wd.findElement(By.xpath(Locators.quantity)));
        }
        return quantity;
    }

    public WebElement getCardNum() {
        if (null == cardNum){
            cardNum = wd.findElement(By.xpath(Locators.cardNum));
        }
        return cardNum;
    }

    public WebElement getCvc() {
        if (null == cvc){
            cvc = wd.findElement(By.xpath(Locators.cvc));
        }
        return cvc;
    }

    public WebElement getExpireMon() {
        if (null == expireMon){
            expireMon = wd.findElement(By.xpath(Locators.expireMon));
        }
        return expireMon;
    }

    public WebElement getExpireYear() {
        if (null == expireYear){
            expireYear = wd.findElement(By.xpath(Locators.expireYear));
        }
        return expireYear;
    }

    public WebElement getName() {
        if (null == name){
            name = wd.findElement(By.xpath(Locators.name));
        }
        return name;
    }

    public WebElement getLine1() {
        if (null == line1){
            line1 = wd.findElement(By.xpath(Locators.line1));
        }
        return line1;
    }

    public WebElement getLine2() {
        if (null == line2){
            line2 = wd.findElement(By.xpath(Locators.line2));
        }
        return line2;
    }

    public WebElement getCity() {
        if (null == city){
            city = wd.findElement(By.xpath(Locators.city));
        }
        return city;
    }

    public WebElement getState() {
        if (null == state){
            state = wd.findElement(By.xpath(Locators.state));
        }
        return state;
    }

    public WebElement getPostalCode() {
        if (null == postalCode){
            postalCode = wd.findElement(By.xpath(Locators.postalCode));
        }
        return postalCode;
    }

    public Select getCountry() {
        if (null == country){
            country = new Select(wd.findElement(By.xpath(Locators.country)));
        }
        return country;
    }

    public WebElement getCheckAgree() {
        if (null == checkAgree){
            checkAgree = wd.findElement(By.xpath(Locators.agreeCheck));
        }
        return checkAgree;
    }

    public WebElement getOrderButton() {
        if (null == orderButton){
            orderButton = wd.findElement(By.xpath(Locators.orderButtonLocator));
        }
        return orderButton;
    }

    protected void reInitPage(){
        preorderTitle = wd.findElement(By.xpath(Locators.orderTitle));
        email = wd.findElement(By.xpath(Locators.email));
        quantity = new Select(wd.findElement(By.xpath(Locators.quantity)));
        cardNum = wd.findElement(By.xpath(Locators.cardNum));
        cvc = wd.findElement(By.xpath(Locators.cvc));
        expireMon = wd.findElement(By.xpath(Locators.expireMon));
        expireYear = wd.findElement(By.xpath(Locators.expireYear));
        name = wd.findElement(By.xpath(Locators.name));
        line1 = wd.findElement(By.xpath(Locators.line1));
        line2 = wd.findElement(By.xpath(Locators.line2));
        city = wd.findElement(By.xpath(Locators.city));
        state = wd.findElement(By.xpath(Locators.state));
        postalCode = wd.findElement(By.xpath(Locators.postalCode));
        country = new Select(wd.findElement(By.xpath(Locators.country)));
        checkAgree = wd.findElement(By.xpath(Locators.agreeCheck));
        orderButton = wd.findElement(By.xpath(Locators.orderButtonLocator));
        priceCost = wd.findElement(By.xpath(Locators.productCost));
        disCount = wd.findElement(By.xpath(Locators.disCount));
        tax = wd.findElement(By.xpath(Locators.tax));
        ship = wd.findElement(By.xpath(Locators.shippingFee));
        totalCost = wd.findElement(By.xpath(Locators.total));
    }

    public boolean isPageOpenedCorrectly(){
        reInitPage();
        boolean isOpen = new WebDriverWait(wd,5).until(new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                Boolean isPageOpen = true;
                if(null==getPreorderTitle()){
                    isPageOpen = false;
                    System.out.println("ERROR! Page is not load successfully in 5 secs");
                } else if(!getPreorderTitle().getText().equals(Locators.expectTileForPreoder)){
                    isPageOpen = false;
                    System.out.println("ERROR! Page title is not equals to expected title :");
                    System.out.println("Actual title is " + getPreorderTitle().getText());
                    System.out.println("But expected title is " + Locators.expectTileForPreoder);
                }
                return isPageOpen;
            }
        });
        return isOpen;
    }

    public boolean isAgreeChecked(){
        boolean isChecked = true;
        String classStr = getCheckAgree().getAttribute("class");
        if(null == classStr || 0 == classStr.length() || !classStr.equals("select")){
            isChecked = false;
        }
        return isChecked;
    }

    /**
     * check cost calculate in page
     * @param order
     */
    public boolean checkCostCalc(OrderInfo order){
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isPriceCorrect = true;
        Double expectProductCost = Double.valueOf(order.getQuantity()) * Locators.singlePriceForProduct;
        Double expectShipFee = Double.valueOf(order.getQuantity()) * Locators.singleBaseShipFee;
        if(order.getCountry().equals("China")){
            expectShipFee *= 3;
        }

        Double actualProductCost = Double.valueOf(getPriceCost().getText());
        Double actualShipFee = Double.valueOf(getShip().getText());
        Double actualTax = Double.valueOf(getTax().getText());
        Double actualDisCount = Double.valueOf(getDisCount().getText());
        Double actualTotal = Double.valueOf(getTotalCost().getText());

        if(Math.abs(actualProductCost - expectProductCost) > 0.01){
            isPriceCorrect &= false;
            System.out.println("ERROR! Price Calculate is not correct,expect price is " + expectProductCost
                                    + " but actually it is " + actualProductCost);
        }

        if(Math.abs(actualShipFee - expectShipFee) > 0.01){
            isPriceCorrect &= false;
            System.out.println("ERROR! Ship Cost Calculate is not correct,expect  ship price is " + expectShipFee
                    + " but actually it is " + actualShipFee);
        }

        if(Math.abs(actualTotal - (actualShipFee + actualProductCost + actualTax -actualDisCount)) > 0.01){
            isPriceCorrect &= false;
            System.out.println("ERROR! Total Cost Calculate is not correct "
                     + "actual total is " + actualTotal + " price cost is "+ actualProductCost +
                        " ship fee is " + actualShipFee + " tax is " + actualTax
                        + " discount is " + actualDisCount);
        }

        return isPriceCorrect;
    }

    public boolean fillOrderInfoInPage(OrderInfo order){
        this.getEmail().sendKeys(order.getEmailAddress());
        this.getQuantity().selectByValue(order.getQuantity());
        this.getCardNum().sendKeys(order.getCardNumber());
        this.getCvc().sendKeys(order.getCvc());
        Select monSelect = new Select(getExpireMon());
        monSelect.selectByValue(order.getExpireMon());
        //this.getExpireMon().sendKeys((order.getExpireMon()));
        this.getExpireYear().sendKeys(order.getExpireYear());
        this.getName().sendKeys(order.getName());
        this.getLine1().sendKeys(order.getLine1());
        this.getLine2().sendKeys(order.getLine2());
        this.getCity().sendKeys(order.getCity());
        this.getState().sendKeys(order.getState());
        this.getPostalCode().sendKeys(order.getPostalCode());
        this.getCountry().selectByValue(order.getCountry());
        if((isAgreeChecked()&& !order.isAgree()) || (!isAgreeChecked() && order.isAgree())){
            this.getCheckAgree().click();
        }

        boolean isPriceRight = checkCostCalc(order);
        //this.getOrderButton().submit();

        return isPriceRight;
    }

    public boolean verifySucOrder( OrderInfo order,Double productCost,Double disCount,Double tax
                                        ,Double shipFee,Double total){
        getOrderButton().submit();
        boolean isOrderSuc;
        if(resPage.isJumpConfirmSuc() &&
                    resPage.isConfirmInfoSameAsFilled(order,productCost,disCount,tax,shipFee,total)) {
            resPage.getOrderConfirmBtn().click();
            if (resPage.isJumpResSuc()) {
                isOrderSuc = resPage.isOrderSucPage();
                if (!isOrderSuc) {
                    System.out.println("ERROR! Jump Page is not for order successfully!");
                }
            } else {
                isOrderSuc = false;
                System.out.println("ERROR! Fail to Jump to order result Page or Order info on confirm page " +
                        "is not same to filled info!");
            }
        } else {
            isOrderSuc = false;
            System.out.println("ERROR! Fail to Jump to order Confirm Page !");
        }
        return isOrderSuc;
    }

    public boolean verifyFailOrderInResPage(OrderInfo order,Double productCost,Double disCount,Double tax
                                        ,Double shipFee,Double total,String[] errList){
        getOrderButton().submit();
        boolean isOrderFail;
        if(resPage.isJumpConfirmSuc()){
            resPage.getOrderConfirmBtn().submit();
            if(resPage.isJumpResSuc() &&
                    resPage.isConfirmInfoSameAsFilled(order,productCost,disCount,tax,shipFee,total)){
                isOrderFail = resPage.isOrderFailPage();
                if(!isOrderFail){
                    System.out.println("ERROR! Jump Page is not for order fail!");
                } else {
                    if(errList.length >0 && !resPage.getFailMessage().getText().contains(errList[0])){
                        isOrderFail = false;
                        System.out.println("ERROR! Error Message in not expect: actual message is "
                                            + resPage.getFailMessage().getText() + " But expected error is  "
                                            + errList[0]);
                    }
                }
            } else {
                isOrderFail = false;
                System.out.println("ERROR! Fail to Jump to order result Page or Order info on confirm page " +
                        "is not same to filled info!");
            }
        } else {
            isOrderFail = false;
            System.out.println("ERROR! Fail to Jump to order Confirm Page !");
        }
        return isOrderFail;
    }

    public boolean verifyFailButNotJump(String[] expectErrList){
        getOrderButton().submit();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isFailBehaviorExpected = getPreorderTitle().isDisplayed();
        if(isFailBehaviorExpected){
            errorInfo = wd.findElements(By.xpath(Locators.errorMessageOnPage));
            List<String> actualErrorList = new ArrayList<>();
            int errCount = 0;
            for (int i=0;i<errorInfo.size();i++){
                String errStr = errorInfo.get(i).getText();
                if(errStr.length() >0){
                    errCount ++;
                    actualErrorList.add(errStr);
                    System.out.println("Error message : " + errStr + " shown on page" );
                }
            }

            //temp
            if (errCount < expectErrList.length){
                isFailBehaviorExpected = false;
                System.out.println("ERROR! Error count shown on page is less than expected");
            } else if(errCount<=0){
                isFailBehaviorExpected = false;
                System.out.println("ERROR! No Error is shown in page,but the order is not successful!");
            } else {
                System.out.println("Error info given on page are :");
                for (int i=0;i<actualErrorList.size();i++){
                    System.out.println((i+1) + ". " + actualErrorList.get(i));
                }

                if(expectErrList.length >0){
                    for (int i=0;i<expectErrList.length;i++){
                        if (!actualErrorList.contains(expectErrList[i])){
                            System.out.println("ERROR! Expected error : " + expectErrList[i]
                                    + " is not contains in actual error List");
                            isFailBehaviorExpected = false;
                            break;
                        } else {
                            actualErrorList.remove(expectErrList[i]);
                        }
                    }

                    if(isFailBehaviorExpected && actualErrorList.size()>0){
                        System.out.println("NOTE: Following error info are not in expect list " +
                                ", but there are given on page");
                        for(int i=0;i<actualErrorList.size();i++){
                            System.out.println((i+1) + ". " + actualErrorList.get(i));
                        }
                    } else if(isFailBehaviorExpected && 0 >= actualErrorList.size()) {
                        System.out.println("Actual and expect error list are identical");
                    }
                }
            }
        } else {
            System.out.println("ERROR! when order with some error info ," +
                    "we expect it will not jump to other page,but it does");
        }
        return isFailBehaviorExpected;
    }
}
