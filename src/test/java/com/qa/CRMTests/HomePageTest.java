package com.qa.CRMTests;

import CRM.Factory.ExplicitWaitFactory;
import CustomizedAnnotations.FrameworkAnnotation;
import FameworkContants.WaitStrategy;
import FreeCRM_Pages.CRMHomePage;
import Listeners.ListenerAction;
import com.qa.Base.Base.Base;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerAction.class)
public final class HomePageTest extends Base {


    private HomePageTest(){

    }

    CRMHomePage homePage=new CRMHomePage();

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Smoke","Regression"})
    @Test
    public void TC_11_verify_SignUp_link(){
       String DealsPageExpectedText= homePage.doLogin();
       Assert.assertEquals(DealsPageExpectedText,"Deals Summary");
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_12_verify_FreeAccountLink() {
         homePage.doLogin();
        String actual=CRMHomePage.verifyFreeAccLink();
        Assert.assertEquals(actual,"Manage your preferences");

    }
    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_13_verify_FreeAccountLink_MyPlan(){
        homePage.doLogin();
        CRMHomePage.verifyFreeAccLink();
        boolean myPlanIsDisplayed=CRMHomePage.verifyMyPlan();
        Assert.assertFalse(myPlanIsDisplayed,"Payment Is Failed Returning To myPlans.... ");

    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_14_verify_FreeAccountLink_Invoice(){
        homePage.doLogin();
        CRMHomePage.verifyFreeAccLink();
        String actualText=CRMHomePage.verifyInvoices();
        Assert.assertEquals(actualText,"Amount");

    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_15_verify_FreeAccountLink_Charges(){
        homePage.doLogin();
        CRMHomePage.verifyFreeAccLink();
       String actualText= CRMHomePage.verifyCharges();
       Assert.assertEquals(actualText,"Description");
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_16_verify_FreeAccountLink_PhoneBilling(){
        homePage.doLogin();
        CRMHomePage.verifyFreeAccLink();
        String actualText=CRMHomePage.verifyTelephonyBilling();
        Assert.assertEquals(actualText,"Upgrade to Pro");
        boolean flag=ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,CRMHomePage.myPlan).isDisplayed();
        Assert.assertFalse(flag);


    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_17_verify_FreeAccountLink_TerminateAccount(){
        homePage.doLogin();
        CRMHomePage.verifyFreeAccLink();
        boolean flag=CRMHomePage.verifyTerminateAccount();

        Assert.assertTrue(flag);

    }




}
