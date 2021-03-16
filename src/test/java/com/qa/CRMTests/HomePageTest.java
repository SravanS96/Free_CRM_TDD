package com.qa.CRMTests;

import CustomizedAnnotations.FrameworkAnnotation;
import FreeCRM_Pages.CRMHomePage;
import Listeners.ListenerAction;
import com.qa.Base.Base.Base;
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
        homePage.doLogin().verifyFreeAccLink();

    }
    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_12_verify_FreeAccountLink() {
        homePage.doLogin().verifyFreeAccLink();

    }
    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_13_verify_FreeAccountLink_MyPlan(){
        homePage.doLogin().verifyFreeAccLink().verifyMyPlan();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_14_verify_FreeAccountLink_Invoice(){
        homePage.doLogin().verifyFreeAccLink().verifyInvoices();

    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_15_verify_FreeAccountLink_Charges(){
        homePage.doLogin().verifyFreeAccLink().verifyCharges();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_16_verify_FreeAccountLink_PhoneBilling(){
        homePage.doLogin().verifyFreeAccLink().verifyCharges();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Regression"})
    @Test
    public void TC_17_verify_FreeAccountLink_TerminateAccount(){
        homePage.doLogin().verifyFreeAccLink().verifyTerminateAccount();

    }




}
