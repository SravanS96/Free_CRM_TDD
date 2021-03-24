package com.qa.CRMTests;

import CustomizedAnnotations.FrameworkAnnotation;
import FreeCRM_Pages.CRMHomePage;
import FreeCRM_Pages.CRMLoginPage;
import com.qa.Base.Base.Base;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ListenerAction;

@Listeners(ListenerAction.class)
public class LoginPageTest extends Base {

    CRMLoginPage loginPage = new CRMLoginPage();
    CRMHomePage homePage = new CRMHomePage();
    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Smoke","Regression"})
    @Test
    public void TC_01_verify_About_link() {

        loginPage.ClickOnAboutUsLink();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Smoke","Regression"})
    @Test
    public void TC_02_verify_SignUp_link() {

        loginPage.ClickOnSignUpLink();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"},addCategories = {"Smoke","Regression"})
    @Test
    public void TC_03_verify_CRM_DropDown() {

        loginPage.CRMDropDownVerification();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public void TC_04_verify_App_DropDown() {

        loginPage.appsDropDownVerification();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public void TC_05_verify_Android_App_link() {

        loginPage.appsDropDownVerification().andriodApperification();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public void TC_06_verify_IOS_App_link() {

        loginPage.appsDropDownVerification().iOSApperification();
    }

    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public void TC_07_verify_Zoom_Page_Link(){

        loginPage.zoomLinkVerification();
    }


    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public  void TC_08_Support_Link_Verification(){

        System.out.println("Test cae running is"+"TC_08_Support_Link_Verification");
        loginPage.support_Link_Verification();
    }


    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test(dataProvider = "getData")
    public void TC_09_login_Button_Verification(String username, String password){

        homePage = loginPage.navigateToLoginPage().doUserLogin(username,password);
        boolean success = homePage.verifySuccessfulLogin();
        Assert.assertTrue(success,"Login Failed");

    }


    @FrameworkAnnotation(addAuthors = {"Admin96"}, addCategories = {"Smoke","Regression"})
    @Test
    public void TC_10_verify_LogingPage_Elements(){

        System.out.println("Test cae running is"+"TC_08_Support_Link_Verification");
        loginPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.loginPageContents(),"All Elements not found");

    }


  @DataProvider(name = "getData" ,parallel= true)
    public Object[] getData(){
      return new Object[][]{
              {"RAJU","PASSWROD"},{"raju","passwprd"},{"sravanch.svu2015@gmail.com","Testing123"}
      };
  }
}
