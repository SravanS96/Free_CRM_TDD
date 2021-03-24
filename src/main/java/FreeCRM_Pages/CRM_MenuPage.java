package FreeCRM_Pages;

import CRM.Factory.ExplicitWaitFactory;
import FameworkContants.WaitStrategy;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class CRM_MenuPage extends Basepage{
    private Object getTodayDate;
    private static Logger log = LogManager.getLogger(Basepage.class.getName());

    public CRM_MenuPage(){

    }
    //Menu List
    protected By home= By.xpath("//i[@class='home icon']");
     protected By calendar=By.xpath("//i[@class='calendar icon']");
     protected By contacts=By.xpath("//i[@class='users icon']");
     protected By company=By.xpath("//i[@class='building icon']");
     protected By deals=By.xpath("////i[@class='money icon']");
     protected By tasks=By.xpath("//a[@href='/tasks']");
     protected By cases=By.xpath("//a[@href='/cases']");
     protected By calls=By.xpath("//i[@class='phone icon']");
     protected By documents=By.xpath("//a[@href='/documents']");
     protected By email=By.xpath("//a[@href='/email']");
     protected By campigns=By.xpath("//a[@href='/campaigns']");
     protected By forms=By.xpath("//a[@href='/forms']");

    //Home page elements
     protected By contactsActivityStreamPage=By.xpath("//div[text()='Contacts activity stream']");

     //calendar web elements
     protected By monthButton=By.xpath("//button[@class='rbc-active']");
     protected By calendarAddSymbol=By.xpath("//div[@id='main-nav']//div[2]//button[1]//i[1]");
     protected By createCalendarEvent=By.xpath("//div[@class='ui header item mb5 light-black']");
     protected By eventTitle=By.xpath("//input[@name='title']");
     protected By dateField=By.xpath("//label[normalize-space()='Start Date']/..//input");
     protected By saveButton=By.xpath("//button[normalize-space()='Save']");
     protected By calender_Dropdown=By.xpath("//div[@name='calendar']");
     protected By call_reminder=By.xpath("//span[normalize-space()='Call Remainder']");
     protected By dateEventName= By.xpath("//div[text()='Client Call']");
     protected String createEventText="Create new Event";
     protected String eventName="Client Call";





     public String verifyHome(){
         log.info("current step ::" + " Verifying the Home");
       String homeExpected= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,contactsActivityStreamPage).getText();
         return homeExpected;
     }
     public String verifyCalendar(){
         log.info("current step ::" + " Verifying the calendar");
         moveToElement(calendar);
         click(calendar);
        String monthButtonText= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,monthButton).getText();
         return monthButtonText;
     }

     public String getTodayDate(){
         log.info("current step ::"+ " Generating today date");
         Date date=new Date();
         //The required time and date format is specified below
         String reqFormat="dd/MM/yyyy HH:00";
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat(reqFormat);
         String currentDate=simpleDateFormat.format(date);
         System.out.println(currentDate);

         return currentDate;
     }
     @SneakyThrows
     public CRM_MenuPage verifyCalendarCreateEvent(){
         log.info("current step ::"+ " creating a new calendar event");

         moveToElement(calendar);
         click(calendarAddSymbol);
         moveToElement(eventTitle);
        String eventCreate= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,createCalendarEvent).getText();
         ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,eventTitle).sendKeys(eventName);
         ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,calender_Dropdown).click();
         Thread.sleep(2000);
         ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,call_reminder).click();
         String currentDateFieldText= ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,dateField).getAttribute("value");

         if( currentDateFieldText.equals(getTodayDate())){
             log.info("current step ::"+ " Checking the event dates");
             Assert.assertEquals(eventCreate,createEventText);
             click(saveButton);
             log.info("Event successfully created");
        }
         else {
             log.error("Event is not created");
             throw new RuntimeException("Event not created");
         }

         return this;
     }

     public String verify_Created_CalendarEvent(){

         log.info("current step ::"+ " verifying the event name with respect to date");
         moveToElement(calendar);
         click(calendar);
         String dateName= ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE,dateEventName).getText();

         return dateName;
     }






}
