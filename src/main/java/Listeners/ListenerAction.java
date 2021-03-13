package Listeners;

import CustomizedAnnotations.FrameworkAnnotation;
import ExtentReports.ExtentLogger;
import ExtentReports.Reports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerAction implements ITestListener, ISuiteListener {

    private static final Logger log = LogManager.getLogger(ListenerAction.class.getName());

    @Override
    public void onStart(ISuite suite) {
        log.info("Initializing Extent Reports");
        Reports.initreports();

    }
    @Override
    public void onFinish(ISuite suite) {
        try {
            Reports.flushReports();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }
    @Override
    public void onTestFailure(ITestResult result) {
        log.error(result.getMethod().getMethodName() + " is Failed");
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", result.getThrowable());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.error(result.getMethod().getMethodName() + " is Skipped");
        ExtentLogger.skip(result.getMethod().getMethodName() + "is Skipped");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Case Executing is :: " + result.getMethod().getMethodName());
        Reports.createTest(result.getMethod().getMethodName());
        ExtentLogger.info("Test Case Executing is :: " + result.getMethod().getMethodName());

        //We have to add the 'author name' and type of test case when the test is starting.
        Reports.addAuthorsToReport(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).addAuthors());
        Reports.addCategoriesToReport(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).addCategories());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is Passed");
        log.info(result.getMethod().getMethodName() + "is Passed");

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
        *
        *
        *
        *
         */
    }
}
