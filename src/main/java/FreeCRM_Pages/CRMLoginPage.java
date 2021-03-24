package FreeCRM_Pages;


import CRM.Factory.ExplicitWaitFactory;
import ExtentReports.ExtentLogger;
import ExtentReports.Reports;
import FameworkContants.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public final class CRMLoginPage extends Basepage {

    public CRMLoginPage() {

    }
    private static final Logger log = LogManager.getLogger(CRMLoginPage.class.getName());

    protected static By aboutLink = By.xpath("//a[text()='About']");
    protected static By signUpLink = By.xpath("//span[@class='mdi-chart-bar icon icon-md']");
    protected static By CRMDropDown = By.xpath("//a[text()='CRM']");
    protected static By aboutUsText = By.xpath("//h1[text()='Free CRM About Us']");
    protected static By email_Field_login = By.xpath("//input[@name='email']");
    protected static By password_Field_login = By.xpath("//input[@name='password']");
    protected static By login_Btn = By.xpath("//div[@class='ui fluid large blue submit button']");
    protected static By apps_toggle = By.xpath("//ul[@class='rd-navbar-nav']/li[4]");
    protected static By zoomVideo_Link=By.xpath("//li/a[text()='Zoom Video']");
    protected static By zoomVideo_Page_HeaderTitle=By.xpath("//h1[normalize-space()='Welcome to BigBlueButton.']");
    protected static By apps_dropDown = By.xpath("//ul[@class='rd-navbar-nav']/li[4]/ul/li/a");
    protected static By android_App_link = By.xpath("//a[normalize-space()='Android']");
    protected static By iOS_App_link = By.xpath("//a[normalize-space()='iPhone / iPad']");
    protected static By supportLink=By.xpath("//li/a[text()='Support']");
    protected static By supportLink_childPage_HeaderTitle=By.xpath("//span[@class='header__name']");
    protected static By loginButton1 =By.xpath("//span[normalize-space()='Log In']");
    protected static By loginButton2 =By.xpath("//div[text()='Login']");
    protected static By forgot_Password_Button=By.xpath("//a[text()='Forgot your password?']");
    protected static String Expected_aboutUsText = "Free CRM About Us";
    protected static String Expected_CRM_Dropdown = "CRM for Any Business;HIPAA CRM;Dental CRM;Automotive CRM;Call Center CRM;Insurance CRM;Real Estate CRM;Professional Services CRM;Contractor Builder CRM;Independent Sales CRM";
    protected static By crmDropdown = By.xpath("//ul[@class='rd-navbar-nav']/li[2]/ul/li/a");
    protected static String Expected_App_Dropdown = "Android;iPhone / iPad";
    protected static String Expected_Android_pageTitle = "Cogmento Free CRM - Apps on Google Play";
    protected static String Expected_iOS_pageTitle = "\u200ECogmento on the App Store";
    protected static String Expected_ZoomPageHeaderTitle=" Welcome to BigBlueButton.";
    protected static String Expected_Support_ChildPageText="Cogmento Help Center";
    protected static String Expected_Zoom_Page_HeaderTitle="Welcome to BigBlueButton.";

    public CRMLoginPage ClickOnAboutUsLink(){

        log.debug("Current Step ::"+"Clicking on About Us Link");

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());

        click(aboutLink);
        Assert.assertEquals(Expected_aboutUsText,getText(aboutUsText));

        return this;
    }
    public CRMLoginPage ClickOnSignUpLink(){

        log.info("Current Step ::"+"Clicking On SignUp Link ");
        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        click(signUpLink);
        Reports.test.pass("Clicked on SignUp ");
       Assert.assertTrue(isDisplayed(email_Field_login));
        return this;
    }
    public CRMLoginPage CRMDropDownVerification(){

        log.debug("Current Step ::"+"Storing all CRM DropDown Elements To List And Comparing");

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());

        moveToElement(CRMDropDown);
        List<String> actual_list = getMultipleText(crmDropdown);
        List<String> expected_list = Arrays.asList(Expected_CRM_Dropdown.split(";"));
        if(!actual_list.equals(expected_list)){
            assert  false;
        }

        return this;
    }

    public CRMLoginPage appsDropDownVerification(){

      log.debug("Current Step ::"+"Storing all App DropDown Elements To List And Comparing");

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());

        click(apps_toggle);
        List<String> names = getMultipleText(apps_dropDown);
        List<String> expectedNames = Arrays.asList(Expected_App_Dropdown.split(";"));
        Assert.assertTrue(names.equals(expectedNames),"");

        return this;
    }

    public CRMLoginPage andriodApperification(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        log.debug("Current Step ::"+"Clicking on Apps Toggle");
        click(apps_toggle);
        log.debug("Current Step ::"+"Clicking On Android");
        click(android_App_link);
        Assert.assertEquals(getPageTitle(),Expected_Android_pageTitle);
        return this;
    }

    public CRMLoginPage iOSApperification(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
       log.debug("Clicking on Apps Toggle");
        click(apps_toggle);
        log.debug("Current Step ::"+"Clicking On IOS");
        click(iOS_App_link);
        switchToSecondWindow();
        Assert.assertEquals(getPageTitle(),Expected_iOS_pageTitle);
        return this;
    }
    public CRMLoginPage zoomLinkVerification(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        log.debug("Current Step ::"+"Clicking On Zoom Link");
        click(zoomVideo_Link);
        String zoomText =ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,zoomVideo_Page_HeaderTitle).getText();
        Assert.assertEquals(zoomText,Expected_Zoom_Page_HeaderTitle);
        closeCurrentWindow();
        return this;
    }
    public CRMLoginPage support_Link_Verification(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        log.debug("Current Step ::"+"Clicking On SupportUs Link");
        click(supportLink);
       switchToSecondWindow();
       String actualSupportText= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,supportLink_childPage_HeaderTitle).getText();
       Assert.assertEquals(actualSupportText,Expected_Support_ChildPageText);
       return this;
    }
    public CRMLoginPage loginButton_Verificaton(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        click(loginButton1);
        log.debug("Current Step ::"+"Clicking On Login Button ");
      boolean forgotButtonPresent=ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,forgot_Password_Button).isDisplayed();
     Assert.assertTrue(forgotButtonPresent);

        return this;
    }
    public CRMLoginPage loginData_Verification(){

        log.debug("Current Step ::"+"Checking the login data");
        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        click(loginButton1);

        return this;
    }

    public CRMLoginPage navigateToLoginPage(){

       log.info("Current Step ::"+"Navigating To LogIn Page");
        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        click(loginButton1);

        return this;
    }

    public boolean loginPageContents(){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        log.info("Current Step ::"+"Checking Login Page Elements loaded or Not");
        boolean isAllDisplayed = false;

        if(isDisplayed(email_Field_login) && isDisplayed(password_Field_login) && isDisplayed(loginButton2) && isDisplayed(forgot_Password_Button) ){
            isAllDisplayed =true;
        }

        return isAllDisplayed;
    }

    public CRMHomePage doUserLogin(String username, String password){

        ExtentLogger.info("Step Executing is :: " + new Object(){}.getClass().getEnclosingMethod().getName());
        log.debug("Current Step ::"+"Entering UserName");
        sendKeys(email_Field_login,username);
        log.debug("Current Step ::"+"Entering Password");
        sendKeys(password_Field_login,password);
        click(loginButton2);
        return new CRMHomePage();
    }



}



