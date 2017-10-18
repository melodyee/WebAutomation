package zerozero.com.preorder.test.common.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import zerozero.com.preorder.test.common.Locators;
import zerozero.com.preorder.test.common.object.OrderInfo;

/**
 * Created by libingxin on 16/3/24.
 */
public class HomePage {
    private WebDriver wd;

    private WebElement homePageTitle;
    private WebElement orderNowButton;

    public HomePage(WebDriver wd) {
        this.wd = wd;
    }

    public WebElement getHomePageTitle() {
        homePageTitle = wd.findElement(By.xpath(Locators.homePageTitle));
        return homePageTitle;
    }

    public WebElement getOrderNowBtn() {
        orderNowButton = wd.findElement(By.xpath(Locators.homePageOrderNow));
        return orderNowButton;
    }
}
