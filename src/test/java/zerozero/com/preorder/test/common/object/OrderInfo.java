package zerozero.com.preorder.test.common.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by yangfan on 16/3/15.
 */
public class OrderInfo {
    String emailAddress;
    String quantity;
    String cardNumber;
    String cvc;
    String expireMon;
    String expireYear;
    String name;
    String line1;
    String line2;
    String city;
    String state;
    String postalCode;
    String country;
    boolean isAgree;



    public OrderInfo(){
        setEmailAddress("yangfan01@zerozero.cn");
        Random rand = new Random();
        int quantityInt = rand.nextInt(10) + 1;
        setQuantity(String.valueOf(quantityInt));
        setCardNumber("4242424242424242");
        setCvc("123");
        setExpireMon("05");
        setExpireYear("2017");
        setName("NameForCameraTest");
        setLine1("AdressforTestLin1");
        setLine2("AdressforTestLin2");
        setCity("CityTest");
        setState("stateTest");
        setIsAgree(true);
        setPostalCode("90878");

        switch(rand.nextInt(3)) {
            case 0:
                setCountry("US");
                break;
            case 1:
                setCountry("UK");
                break;
            case 2:
                setCountry("CN");
                break;
        }
    }

    public boolean isAgree() {
        return isAgree;
    }

    public void setIsAgree(boolean agree) {
        isAgree = agree;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpireMon() {
        return expireMon;
    }

    public void setExpireMon(String expireMon) {
        this.expireMon = expireMon;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
