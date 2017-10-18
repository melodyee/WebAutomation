package zerozero.com.preorder.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.logging.Level;

/**
 * Created by yangfan on 16/3/15.
 */
public class WD {
    public static WebDriver getWebDriverIns(String browser) {
        WebDriver wd = null;
        switch (browser) {
            case "firefox": {
                System.out.println("*** Start creating web driver [firefox]:");
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("databaseEnabled", true);
                caps.setCapability("webStorageEnabled", true);
                caps.setCapability("javascriptEnabled", true);
                LoggingPreferences prefs = new LoggingPreferences();
                prefs.enable(LogType.BROWSER, Level.WARNING);
                prefs.enable(LogType.DRIVER, Level.INFO);
                caps.setCapability(CapabilityType.LOGGING_PREFS, prefs);

                FirefoxProfile fp = new FirefoxProfile();
                fp.setPreference("browser.tabs.closeWindowWithLastTab", false);
                fp.setPreference("startup.homepage_welcome_url", "about:blank");
                fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");
                caps.setCapability(FirefoxDriver.PROFILE, fp);

                wd = new FirefoxDriver(caps);

                System.out.println("*** End creating web driver [firefox]");
            }
            break;
            case "safari": {
                System.out.println("*** Start creating web driver [safari]:");
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("databaseEnabled", true);
                caps.setCapability("webStorageEnabled", true);
                caps.setCapability("javascriptEnabled", true);
                LoggingPreferences prefs = new LoggingPreferences();
                prefs.enable(LogType.BROWSER, Level.WARNING);
                prefs.enable(LogType.DRIVER, Level.INFO);
                caps.setCapability(CapabilityType.LOGGING_PREFS, prefs);
                wd = new SafariDriver(caps);
                System.out.println("*** End creating web driver [safari]");
            }
        }
        return wd;
    }
}
