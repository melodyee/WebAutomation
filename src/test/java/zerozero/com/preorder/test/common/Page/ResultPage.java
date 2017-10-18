package zerozero.com.preorder.test.common.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import zerozero.com.preorder.test.common.Locators;
import zerozero.com.preorder.test.common.object.OrderInfo;

import javax.annotation.Nullable;

/**
 * Created by yangfan on 16/3/16.
 */
public class ResultPage {
    WebDriver wd;

    WebElement orderConfirmBtn;
    WebElement orderConfirmBlock;
    WebElement orderSucBlock;
    WebElement orderNo;
    WebElement orderFailBlock;
    WebElement failMessage;

    String emailOnConfirm;
    String cardNumOnConfirm;
    String quantityOnConfirm;
    String nameOnConfirm;
    String line1OnConfirm;
    String line2OnConfirm;
    String cityOnConfirm;
    String stateOnConfirm;
    String postalCodeOnConfirm;
    String countryOnConfirm;

    Double productCostOnConfirm;
    Double discountOnConfirm;
    Double salesTaxOnConfirm;
    Double shipFeeOnConfirm;
    Double totalOnConfirm;


    public ResultPage(WebDriver wd){
        this.wd = wd;
    }

    public WebElement getOrderConfirmBtn() {
        if(null == orderConfirmBtn){
            orderConfirmBtn = wd.findElement(By.xpath(Locators.getOrderConfirmBtn));
        }
        return orderConfirmBtn;
    }

    public WebElement getOrderConfirmBlock() {
        //if(null==orderConfirmBlock){
            orderConfirmBlock = wd.findElement(By.xpath(Locators.orderConfirmBlock));
        //}
        return orderConfirmBlock;
    }

    public WebElement getOrderNo() {
        if(null == orderNo){
            orderNo = wd.findElement(By.xpath(Locators.orderNo));
        }
        return orderNo;
    }

    public WebElement getOrderFailBlock() {
        if(null == orderFailBlock){
            orderFailBlock = wd.findElement(By.xpath(Locators.orderFail));
        }
        return orderFailBlock;
    }

    public WebElement getFailMessage() {
        if(null == failMessage){
            failMessage = wd.findElement(By.xpath(Locators.orderErrMsg));
        }
        return failMessage;
    }

    public WebElement getOrderSucBlock() {
        if(null == orderSucBlock){
            orderSucBlock = wd.findElement(By.xpath(Locators.orderNo));
        }
        return orderSucBlock;
    }

    public String getEmailOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.emailOnConfirm));
        emailOnConfirm = ele.getText();
        return emailOnConfirm;
    }

    public String getCardNumOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.cardNumOnConfirm));
        cardNumOnConfirm = ele.getText();
        return cardNumOnConfirm;
    }

    public String getQuantityOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.quantityOnConfirm));
        quantityOnConfirm = ele.getText();
        return quantityOnConfirm;
    }

    public String getNameOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.nameOnConfirm));
        nameOnConfirm = ele.getText();
        return nameOnConfirm;
    }

    public String getLine1OnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.line1OnConfirm));
        line1OnConfirm = ele.getText();
        return line1OnConfirm;
    }

    public String getLine2OnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.line2OnConfirm));
        line2OnConfirm = ele.getText();
        return line2OnConfirm;
    }

    public String getCityOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.cityOnConfirm));
        cityOnConfirm = ele.getText();
        return cityOnConfirm;
    }

    public String getStateOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.stateOnConfirm));
        stateOnConfirm = ele.getText();
        return stateOnConfirm;
    }

    public String getPostalCodeOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.postalCodeOnConfirm));
        postalCodeOnConfirm = ele.getText();
        return postalCodeOnConfirm;
    }

    public String getCountryOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.countryOnConfirm));
        countryOnConfirm = ele.getText();
        return countryOnConfirm;
    }

    public Double getProductCostOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.productCostOnConfirm));
        productCostOnConfirm = Double.valueOf(ele.getText().substring(1));
        return productCostOnConfirm;
    }

    public Double getDiscountOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.discountOnConfirm));
        discountOnConfirm = Double.valueOf(ele.getText().substring(1));
        return discountOnConfirm;
    }

    public Double getSalesTaxOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.salesTaxOnConfirm));
        salesTaxOnConfirm = Double.valueOf(ele.getText().substring(1));
        return salesTaxOnConfirm;
    }

    public Double getShipFeeOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.shipFeeOnConfirm));
        shipFeeOnConfirm = Double.valueOf(ele.getText().substring(1));
        return shipFeeOnConfirm;
    }

    public Double getTotalOnConfirm() {
        WebElement ele = wd.findElement(By.xpath(Locators.totalOnConfirm));
        totalOnConfirm = Double.valueOf(ele.getText().substring(1));
        return totalOnConfirm;
    }

    public void reInitPage(){
        orderNo = wd.findElement(By.xpath(Locators.orderNo));
        orderSucBlock = wd.findElement(By.xpath(Locators.orderSuc));
        orderSucBlock = wd.findElement(By.xpath(Locators.orderNo));
        orderFailBlock = wd.findElement(By.xpath(Locators.orderFail));
        orderConfirmBlock = wd.findElement(By.xpath(Locators.orderConfirmBlock));
        orderConfirmBtn = wd.findElement(By.xpath(Locators.getOrderConfirmBtn));
    }

    public boolean isJumpResSuc(){
        boolean isOpen = new WebDriverWait(wd,5).until(new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                Boolean isPageJumpSuc = false;
                if(getOrderSucBlock().isDisplayed() || getOrderFailBlock().isDisplayed()){
                    isPageJumpSuc = true;
                }

                return isPageJumpSuc;
            }
        });
        if(!isOpen){
            System.out.println("ERROR! Order result page is not load successfully in 5 secs");
        } else {
            reInitPage();
        }
        return isOpen;
    }

    public boolean isJumpConfirmSuc(){
        boolean isOpen = new WebDriverWait(wd,5).until(new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                Boolean isPageJumpSuc = false;
                if(getOrderConfirmBlock().isDisplayed()){
                    isPageJumpSuc = true;
                }

                return isPageJumpSuc;
            }
        });
        if(!isOpen){
            System.out.println("ERROR! Confirm Order page is not load successfully in 5 secs");
        } else {
            reInitPage();
        }
        return isOpen;
    }

    public boolean isOrderSucPage(){
        boolean isSucPage = getOrderSucBlock().isDisplayed();
        System.out.println("order number is  " + getOrderNo().getText());
        return isSucPage;
    }

    public boolean isOrderFailPage(){
        boolean isFailPage = getOrderFailBlock().isDisplayed();
        String actualError = getFailMessage().getText();
        System.out.println("Error Message is " + actualError);
        return isFailPage;
    }

    public boolean isConfirmInfoSameAsFilled(OrderInfo order,Double productCost
                    ,Double discount,Double salesTax,Double shipFee,Double total){
        boolean isSame = true;
        if(!getEmailOnConfirm().equals(order.getEmailAddress())){
            isSame = false;
            System.out.println("ERROR! Email on confirm is not same to filled info: " +
                    "Value on confirm page is " + getEmailOnConfirm() + " but filled value is " + order.getEmailAddress());
        }

        if(!getCardNumOnConfirm().equals(order.getCardNumber())){
            isSame = false;
            System.out.println("ERROR! card number on confirm is not same to filled info: " +
                    "Value on confirm page is " + getCardNumOnConfirm() + " but filled value is " + order.getCardNumber());
        }

        if(!getQuantityOnConfirm().equals(order.getQuantity())){
            isSame = false;
            System.out.println("ERROR! quantity on confirm is not same to filled info: " +
                    "Value on confirm page is " + getQuantityOnConfirm() + " but filled value is " + order.getQuantity());
        }

        if(!getNameOnConfirm().equals(order.getName())){
            isSame = false;
            System.out.println("ERROR! Name on confirm is not same to filled info: " +
                    "Value on confirm page is " + getNameOnConfirm() + " but filled value is " + order.getName());
        }

        if(!getLine1OnConfirm().equals(order.getLine1())){
            isSame = false;
            System.out.println("ERROR! Line1 on confirm is not same to filled info: " +
                    "Value on confirm page is " + getLine1OnConfirm() + " but filled value is " + order.getLine1());
        }

        if(!getLine2OnConfirm().equals(order.getLine2())){
            isSame = false;
            System.out.println("ERROR! Line 2 on confirm is not same to filled info: " +
                    "Value on confirm page is " + getEmailOnConfirm() + " but filled value is " + order.getEmailAddress());
        }

        if(!getCityOnConfirm().equals(order.getCity())){
            isSame = false;
            System.out.println("ERROR! City on confirm is not same to filled info: " +
                    "Value on confirm page is " + getCityOnConfirm() + " but filled value is " + order.getCity());
        }

        if(!getStateOnConfirm().equals(order.getState())){
            isSame = false;
            System.out.println("ERROR! State on confirm is not same to filled info: " +
                    "Value on confirm page is " + getStateOnConfirm() + " but filled value is " + order.getState());
        }

        if(!getPostalCodeOnConfirm().equals(order.getPostalCode())){
            isSame = false;
            System.out.println("ERROR! Postal code on confirm is not same to filled info: " +
                    "Value on confirm page is " + getPostalCodeOnConfirm() + " but filled value is " + order.getPostalCode());
        }

        if(!getCountryOnConfirm().equals(order.getCountry())){
            isSame = false;
            System.out.println("ERROR! Country on confirm is not same to filled info: " +
                    "Value on confirm page is " + getCountryOnConfirm() + " but filled value is " + order.getCountry());
        }

        if(Math.abs(getProductCostOnConfirm() - (productCost)) > 0.01){
            isSame = false;
            System.out.println("ERROR! Product cost on confirm is not same to filled info: " +
                    "Value on confirm page is " + getProductCostOnConfirm() + " but filled value is " + productCost);
        }

        if(Math.abs(getDiscountOnConfirm() - (discount)) > 0.01){
            isSame = false;
            System.out.println("ERROR! Discount on confirm is not same to filled info: " +
                    "Value on confirm page is " + getDiscountOnConfirm() + " but filled value is " + discount);
        }

        if(Math.abs(getShipFeeOnConfirm() - (shipFee)) > 0.01){
            isSame = false;
            System.out.println("ERROR! Ship fee on confirm is not same to filled info: " +
                    "Value on confirm page is " + getShipFeeOnConfirm() + " but filled value is " + shipFee);
        }

        if(Math.abs(getSalesTaxOnConfirm() - (salesTax)) > 0.01){
            isSame = false;
            System.out.println("ERROR! Tax on confirm is not same to filled info: " +
                    "Value on confirm page is " + getSalesTaxOnConfirm() + " but filled value is " + salesTax);
        }

        if(Math.abs(getTotalOnConfirm() - (total)) > 0.01){
            isSame = false;
            System.out.println("ERROR! Product on confirm is not same to filled info: " +
                    "Value on confirm page is " + getTotalOnConfirm() + " but filled value is " + total);
        }

        return isSame;
    }


}
