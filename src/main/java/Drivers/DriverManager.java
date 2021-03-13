package Drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){

    }

    private static ThreadLocal<WebDriver> drr=new ThreadLocal<>();
    public  static WebDriver getDriver(){
        return drr.get();
    }
    public static void setDriver(WebDriver driverRef) {
        drr.set(driverRef);
    }
    public static void unload(){
        drr.remove();

    }


}
