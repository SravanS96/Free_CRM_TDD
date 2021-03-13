package CRM.Factory;

import Drivers.DriverManager;
import ExtentReports.ExtentLogger;
import FameworkContants.WaitStrategy;
import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public final class ExplicitWaitFactory{
    private ExplicitWaitFactory() {

    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement element = null;
        try{

            if(waitStrategy== WaitStrategy.CLICKABLE){
                element=new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitlyWait())
                        .until(ExpectedConditions.elementToBeClickable(by));

            }else if(waitStrategy== WaitStrategy.PRESENCE){
                element=new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitlyWait())
                        .until(ExpectedConditions.presenceOfElementLocated(by));

            }else if(waitStrategy== WaitStrategy.VISIBLE){
                element= new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitlyWait())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));

            }else if(waitStrategy==WaitStrategy.NONE){
                element=DriverManager.getDriver().findElement(by);
            }

        }catch (StaleElementReferenceException exception){
            ExtentLogger.fail("Stale Element Exception Occurred ", exception.fillInStackTrace());

        }catch (TimeoutException exception){
            ExtentLogger.fail("Element not found with in " + AppConstants.getExplicitlyWait() + " Seconds ",exception.fillInStackTrace());

        }catch (Exception exception){
            ExtentLogger.fail("Exception Occurred ", exception.fillInStackTrace());

        }

        return element;
    }

    public static List<WebElement> performExplicitWaitForMultiplesElements(WaitStrategy waitStrategy, By by){
        List<WebElement> element = null;
        if(waitStrategy == WaitStrategy.PRESENCE){
            element=new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitlyWait())
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        }else if(waitStrategy== WaitStrategy.VISIBLE){
            element= new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitlyWait())
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

        }else if(waitStrategy==WaitStrategy.NONE){
            element=DriverManager.getDriver().findElements(by);
        }

        return element;

    }
}
