package zerozero.com.preorder.test.common;

/**
 * Created by yangfan on 16/3/15.
 */
public class Locators {
    public static String preorderURL = "http://preorder_stage.gethover.com/preorder/index";
    public static int singlePriceForProduct = 399;
    public static int singleBaseShipFee = 5;

    public static String orderTitle = "//h1/p";
    public static String expectTileForPreoder = "PLACE YOUR ORDER";
    public static String email = "//input[@name='email']";
    public static String quantity = "//select[@id='quantity']";

    public static String cardNum = "//input[@name='cardNumber']";
    public static String cvc = "//input[@name='cvc']";
    public static String expireMon = "//select[@id='exp_month']";
    public static String expireYear = "//select[@id='exp_year']";

    public static String name = "//input[@name='name']";
    public static String line1 = "//input[@name='line1']";
    public static String line2 = "//input[@name='line2']";
    public static String city = "//input[@name='city']";
    public static String state = "//input[@name='state']";
    public static String postalCode = "//input[@name='postalCode']";
    public static String country = "//select[@id='country']";
    public static String agreeCheck = "//div[@class='preorder__agree']/a";
    public static String orderButtonLocator = "//input[contains(@class,'stripeType') and @id='submit-btn']";
    public static String errorMessageOnPage = "//div[@class='preorder--input']/em";

    //
    public static String productCost = "//span[@id='productCost']";
    public static String disCount = "//span[@id='discount']";
    public static String tax = "//span[@id='tax']";
    public static String shippingFee = "//span[@id='shippingFee']";
    public static String total = "//span[@id='total']";

    //Element on order result page
    public static String orderSuc = "//div[@class='result__success']";
    public static String orderFail = "//div[@class='result__fail']";
    public static String orderNo = "//em[@id='orderNo']";
    public static String orderErrMsg = "//h2[@id='error_message']";
    public static String orderConfirmBlock = "//div[@class='confirm__wrapper']";
    public static String getOrderConfirmBtn = "//input[@id='confirmBtn']";
    public static String emailOnConfirm = "//span[contains(text(),'E-mail Address')]/following-sibling::p";
    public static String cardNumOnConfirm = "//span[contains(text(),'Card Number')]/following-sibling::p";
    public static String quantityOnConfirm = "//span[contains(text(),'Quantity')]/following-sibling::p";
    public static String nameOnConfirm = "//span[contains(text(),'Name')]/following-sibling::p";
    public static String line1OnConfirm = "//span[contains(text(),'Line 1')]/following-sibling::p";
    public static String line2OnConfirm = "//span[contains(text(),'Line 2')]/following-sibling::p";
    public static String cityOnConfirm = "//span[contains(text(),'City')]/following-sibling::p";
    public static String stateOnConfirm = "//span[contains(text(),'State')]/following-sibling::p";
    public static String postalCodeOnConfirm = "//span[contains(text(),'Postal Code')]/following-sibling::p";
    public static String countryOnConfirm = "//span[contains(text(),'Country')]/following-sibling::p";
    public static String productCostOnConfirm = "//span[contains(text(),'Product Cost')]/following-sibling::p";
    public static String discountOnConfirm = "//span[contains(text(),'Discount')]/following-sibling::p";
    public static String salesTaxOnConfirm = "//span[contains(text(),'Sales Tax')]/following-sibling::p";
    public static String shipFeeOnConfirm = "//span[contains(text(),'Ship Fee')]/following-sibling::p";
    public static String totalOnConfirm = "//span[contains(text(),'Total')]/following-sibling::p";

    //Element on homepage
    public static String homePageTitle = "//div[@class='banner__text']/h1";
    public static String homePageOrderNow = "//div[@class='preorder__btn'/span]";


}
