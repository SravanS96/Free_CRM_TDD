package ExtentReports;

import Drivers.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.Utils.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {


    private ExtentLogger() {

    }


    public static void pass(String message) {

        ExtentReportManager.getExtentTest().log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());

    }


    public static void fail(String message,Throwable throwable) {

        ExtentReportManager.getExtentTest().log(Status.FAIL,message);
        ExtentReportManager.getExtentTest().log(Status.FAIL, throwable, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());

    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().log(Status.SKIP, message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot()).build());
    }

    public static void info(String message){
        ExtentReportManager.getExtentTest().log(Status.INFO, message);
    }

    private static String getScreenShot(){
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
