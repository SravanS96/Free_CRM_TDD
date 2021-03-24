package com.qa.CRMTests;

import CustomizedAnnotations.FrameworkAnnotation;
import FreeCRM_Pages.CRMHomePage;
import FreeCRM_Pages.CRM_MenuPage;
import com.qa.Base.Base.Base;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ListenerAction;

@Listeners(ListenerAction.class)
public final class MenuPageTest extends Base {
    private MenuPageTest(){

    }
    CRMHomePage homePage=new CRMHomePage();
    CRM_MenuPage menuPage=new CRM_MenuPage();

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_18_verify_Home(){

        homePage.doLogin();
      String homeExpected=menuPage.verifyHome();
        Assert.assertEquals(homeExpected,"Contacts activity stream");
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_19_verify_Calendar(){
     homePage.doLogin();
     String monthButtonText=menuPage.verifyCalendar();
     Assert.assertEquals(monthButtonText,"Month");

    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_20_verify_CreateCalendarEvent(){
        homePage.doLogin();
        String todayDate=menuPage.getTodayDate();
        String DateText=menuPage.verifyCalendarCreateEvent().verify_Created_CalendarEvent();
        Assert.assertEquals(DateText,"Client Call");
    }



}
