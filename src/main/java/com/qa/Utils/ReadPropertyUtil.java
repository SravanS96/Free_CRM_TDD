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
    public static String getUsername(String username){
        try(FileInputStream fis =new FileInputStream(FrameworkConstants.getPropertiesFilePath())){
            property=new Properties();
            property.load(fis);


        }   catch (FileNotFoundException e){
            e.printStackTrace();

        }   catch (IOException e){
            e.printStackTrace();

        }
        return property.getProperty(String.valueOf(username));
    }
    public static String getPassword(String password) {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertiesFilePath())) {
            property = new Properties();
            property.load(fis);


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return property.getProperty(String.valueOf(password));
    }


}

