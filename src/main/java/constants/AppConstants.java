package constants;

import java.io.File;

public final class AppConstants {
   private AppConstants(){

    }
      public static final int PAGE_LOAD_TIMEOUT=20;
    // public static final int IMPLICITLY_WAIT=10;

    private static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+ File.separator+"src/main/resources/executables/chromedriver.exe";

    private static final String GECKO_DRIVER_PATH=System.getProperty("user.dir")+ File.separator+"src/main/resources/executables/geckodriver.exe";

    private static final String CHROME_DRIVER_VALUE="webdriver.chrome.driver";

    private static final String GECKO_DRIVER_VALUE="webdriver.gecko.driver";

    private static final int EXPLICITLY_WAIT = 20;

    public static int getExplicitlyWait(){
        return EXPLICITLY_WAIT;
    }

   // private static final String URL="https://freecrm.com/";
    //CHROME_DRIVER_VALUE

    public static String getCHROMEDRIVER_VALUE() {
        return CHROME_DRIVER_VALUE;

    }
    //CHROMEDRIVER_PATH
    public static String getCHROMEDRIVER_PATH() {
        return CHROMEDRIVER_PATH;
    }
    public static String getGECKODRIVER_VALUE() {
        return GECKO_DRIVER_VALUE;

    }
    public static String getGECKODRIVER_PATH() {
        return GECKO_DRIVER_PATH;
    }

}
