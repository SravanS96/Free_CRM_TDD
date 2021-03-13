package com.qa.Utils;

import FameworkContants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ReadPropertyUtil {


    private static Properties property;
   private static FileInputStream fis;

    private ReadPropertyUtil() {

    }


    public static String getURL(String value) {

        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertiesFilePath())) {
            property=new Properties();
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(String.valueOf(value));
    }


    //This method is returning the browser which is mentioned in the property file.
    public static String getBrowser(String browser){

        try(FileInputStream fis =new FileInputStream(FrameworkConstants.getPropertiesFilePath())){
            property=new Properties();
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(String.valueOf(browser));
    }


}
//
//    //Throwing Exception if the properties file key is "null"
//    public static String get(ConfigEnumProperties key) throws Exception {
//        String vaulue="";
//        if (Objects.isNull(vaulue)|| Objects.isNull(CONFIGMAP.get(key))) {
//            throw new Exception("Property" + key + "is missing please check properties file");
//
//        }
//      return get(key.toLowerCase());
//    }
//}
//
//

