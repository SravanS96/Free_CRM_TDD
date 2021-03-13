package ExtentReports;

import Drivers.DriverManager;
import FreeCRM_Pages.Basepage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.Utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
    private static final Logger log = LogManager.getLogger(Basepage.class.getName());

    private ExtentLogger() {

    }


    public static void pass(String message) {
        log.info(message);
        ExtentReportManager.getExtentTest().log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());

    }


    public static void fail(String message,Throwable throwable) {
        log.error(message);
        ExtentReportManager.getExtentTest().log(Status.FAIL,message);
        ExtentReportManager.getExtentTest().log(Status.FAIL, throwable, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());

    }

    public static void skip(String message) {
        log.info(message);
        ExtentReportManager.getExtentTest().log(Status.SKIP, message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot()).build());
    }

    public static void info(String message){
        log.info(message);
        ExtentReportManager.getExtentTest().log(Status.INFO, message);
    }

    private static String getScreenShot(){
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
