package FreeCRM_Pages;

import CRM.Factory.ExplicitWaitFactory;
import Drivers.DriverManager;
import ExtentReports.ExtentLogger;
import FameworkContants.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public  class Basepage {
    private static Logger log = LogManager.getLogger(Basepage.class.getName());


    protected static void sendKeys(By by, String keys){

      WebElement element= ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
      element.clear();
      element.sendKeys(keys);
      ExtentLogger.pass(keys + " is Entered successfully. ");
    }
    protected static void click(By by){
        log.info("Clicked On WebElement");

        WebElement element=ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,by);
        element.click();
        ExtentLogger.info(by+"  ::  Clicked");
    }


    protected static String getText(By by){

        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
        return element.getText();
    }

    protected void moveToElement(By by){

        Actions actions =new Actions(DriverManager.getDriver());
        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
        actions.moveToElement(element).build().perform();
    }

    protected boolean isDisplayed(By by){
        log.info("Element is Displayed");

        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,by);
        return element.isDisplayed();
    }
    protected List<String> getMultipleText(By by){

        List<String> list= new ArrayList<>();
      List<WebElement>webElements = ExplicitWaitFactory.performExplicitWaitForMultiplesElements(WaitStrategy.PRESENCE,by);
        for (WebElement webElement : webElements) {

            String name = webElement.getText();
            list.add(name);
        }
        return list;
    }

    protected String getCurrentWindowHandle(){

        return DriverManager.getDriver().getWindowHandle();
    }

    protected void switchToSecondWindow(){

        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        for (String child_window : windows) {
            if (!getCurrentWindowHandle().equals(child_window)) {
                DriverManager.getDriver().switchTo().window(child_window);
            }
        }
    }

    protected String getPageTitle(){

        return DriverManager.getDriver().getTitle();
    }

    protected void switchToDefaultWindow(){

        DriverManager.getDriver().switchTo().defaultContent();
    }

    protected  void closeCurrentWindow(){
        DriverManager.getDriver().close();
    }

}
