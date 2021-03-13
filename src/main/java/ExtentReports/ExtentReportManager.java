package ExtentReports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    protected ExtentReportManager() {

    }
     static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<>();
     public static ExtentTest getExtentTest(){

         return extentTestThreadLocal.get();
    }
     static void  setExtentTest(ExtentTest test){

         extentTestThreadLocal.set(test);
    }
     static void unload(){

         extentTestThreadLocal.remove();
    }

}
