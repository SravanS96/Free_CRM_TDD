package FameworkContants;

import com.qa.Utils.ReadPropertyUtil;

public final class FrameworkConstants {
    private FrameworkConstants() {

    }
    static Object value = null;
    private static final String PROPERTIES_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/com/qa/config/Config.properties";
    private static final String EXTENT_REPORT_FILEPATH = System.getProperty("user.dir") + "/extent-test-output";
    private static final String EXCEL_SHEET_PATH=System.getProperty("user.dir")+"/src/main/resources/excels/TestDataForCRM.xlsx";

    public static String getPropertiesFilePath() {

        return PROPERTIES_FILE_PATH;
    }
    public static String getExtentReportFilepathPath() {
        if(ReadPropertyUtil.dynamicReportScreenShots(DynamicReportEnum.OVERRIDE_REPORTS).equalsIgnoreCase("yes")){
          return   EXTENT_REPORT_FILEPATH +"/"+System.currentTimeMillis()+"index.html";
        }
        else {
          return   EXTENT_REPORT_FILEPATH +"/"+"index.html";
        }
    }
    public static String getExcelSheetPath(){
        return EXCEL_SHEET_PATH;
    }

}

