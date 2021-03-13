package ExtentReports;

import FameworkContants.DynamicReportEnum;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.Utils.ReadPropertyUtil;
import com.qa.Utils.ScreenShotUtils;

public final class ExtentLogger {


    private ExtentLogger() {

    }


    private static void pass(String message) {

        ExtentReportManager.getExtentTest().pass(message);
    }

    private static void fail(String message) {

        ExtentReportManager.getExtentTest().fail(message);
    }

    private static void skip(String message) {

        ExtentReportManager.getExtentTest().skip(message);

    }

    public static void pass(String message, boolean isScreenShotNeed) {

        if (ReadPropertyUtil.dynamicReportScreenShots(DynamicReportEnum.PASSED_TESTCASE_SCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeed) {
            ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());
        } else {
            pass(message);
        }

    }

    public static void fail(String message, boolean isScreenShotNeed) {

        if (ReadPropertyUtil.dynamicReportScreenShots(DynamicReportEnum.FAILED_TESTCASE_SCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeed) {
            ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());
        } else {
            fail(message);
        }

    }

    public static void fail(String message,Throwable throwable, boolean isScreenShotNeed) {

        if (ReadPropertyUtil.dynamicReportScreenShots(DynamicReportEnum.FAILED_TESTCASE_SCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeed) {
            ExtentReportManager.getExtentTest().fail(throwable, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());
        } else {
            fail(message);
        }

    }

    public static void skip(String message, boolean isScreenShotNeed) {

        if (ReadPropertyUtil.dynamicReportScreenShots(DynamicReportEnum.SKIPPED_TESTCASE_SCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenShotNeed) {
            ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Img()).build());
        } else {
            skip(message);
        }

    }

    public static void info(String message){

        ExtentReportManager.getExtentTest().info(message);

    }


}
