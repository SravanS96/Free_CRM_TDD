package ExtentReports;


import FameworkContants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class Reports {

    private Reports(){

    }
    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initreports(){
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilepathPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Admin96");
            spark.config().setDocumentTitle("MyReport");

        }
    }

    public static  void flushReports() throws IOException {
        if(Objects.nonNull(extent)){
            extent.flush();
        }

        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilepathPath()).toURI());
    }
    public static void createTest(String testCaseName){
        test =extent.createTest(testCaseName);
        ExtentReportManager.setExtentTest(test);

    }
    /*
    *
    *     " To add Author name and To add category of the test
    *      This two methods are used in Listeners class....."
    *
    *
     */

        public static void addAuthorsToReport(String[] authors){

        for (String tempVar:authors){

            //This step is used to add the Author of the test case.
            ExtentReportManager.getExtentTest().assignAuthor(tempVar);

        }

    }
    public static void addCategoriesToReport(String[] categories){

        for (String tempVar:categories){

            //This step is used to add the category type of the test case.
            ExtentReportManager.getExtentTest().assignCategory(tempVar);
        }

    }

}