package Drivers;

import com.qa.Utils.ReadPropertyUtil;
import constants.AppConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public final class Drivers {


    private Drivers() {

    }


    public static void initDriver(String browser ,String headlessMode) {
        if (Objects.isNull(DriverManager.getDriver())) {

            if(ReadPropertyUtil.getBrowser(browser).equalsIgnoreCase("chrome")){
                System.setProperty(AppConstants.getCHROMEDRIVER_VALUE(), AppConstants.getCHROMEDRIVER_PATH());
                if(ReadPropertyUtil.getBrowser(headlessMode).equalsIgnoreCase("yes")){
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");
                    DriverManager.setDriver(new ChromeDriver(chromeOptions));
                }else {
                    DriverManager.setDriver(new ChromeDriver());
                }


            }else if (ReadPropertyUtil.getBrowser(browser).equalsIgnoreCase("firefox")){

                System.setProperty(AppConstants.getGECKODRIVER_VALUE(),AppConstants.getGECKODRIVER_PATH());
                DriverManager.setDriver(new FirefoxDriver());

            }

        }

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();

        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(AppConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        DriverManager.getDriver().get(ReadPropertyUtil.getURL("url"));

    }


    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}




