package FameworkContants;


public final class FrameworkConstants {
    private FrameworkConstants() {

    }

    private static final String PROPERTIES_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/com/qa/config/Config.properties";

    public static String getPropertiesFilePath() {

        return PROPERTIES_FILE_PATH;
    }



}

