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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public  class Basepage {
    private static Logger log = LogManager.getLogger(Basepage.class.getName());


    protected static void sendKeys(By by, String keys){
       // log.debug("Entering Keys Into WebElement::"+by);

      WebElement element= ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
      element.clear();
      element.sendKeys(keys);
      ExtentLogger.pass(keys + " is Entered successfully. ");
    }
    protected static void click(By by){
      //  log.debug("Clicking On WebElement ::"+by);
        WebElement element=ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,by);
        element.click();
    }


    protected static String getText(By by){
       // log.info("Text Is Captured From WebElement ::"+by);
        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
        String text = element.getText();
        return text;
    }

    protected void moveToElement(By by){
      //  log.debug("Cursor Is Moved To WebElement ::"+by);
        Actions actions =new Actions(DriverManager.getDriver());
        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,by);
        actions.moveToElement(element).build().perform();
    }

    protected boolean isDisplayed(By by){
     //   log.debug("WebElement is displayed");
        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,by);
        return element.isDisplayed();
    }
    protected List<String> getMultipleText(By by){

        List<String> list= new ArrayList<>();
      List<WebElement>webElements = ExplicitWaitFactory.performExplicitWaitForMultiplesElements(WaitStrategy.PRESENCE,by);
        for (int i = 0; i <webElements.size() ; i++) {
      //      log.debug("Getting WebElement Text ::"+by);
            String name = webElements.get(i).getText();
            list.add(name);
        }
        return list;
    }

    protected String getCurrentWindowHandle(){
   //   log.debug("Getting Window Handling Mechanism");
        return DriverManager.getDriver().getWindowHandle();
    }

    protected void switchToSecondWindow(){
    //    log.debug("Switching To Child Window");
        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){
            String child_window=iterator.next();
            if (getCurrentWindowHandle() != child_window){
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
