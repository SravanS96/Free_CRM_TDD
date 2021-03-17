package FreeCRM_Pages;

import CRM.Factory.ExplicitWaitFactory;
import ExtentReports.ExtentReportManager;
import FameworkContants.WaitStrategy;
import com.qa.Utils.ReadPropertyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class CRMHomePage extends Basepage {
    CRM_LoginPage loginPage;
    private static Logger log = LogManager.getLogger(Basepage.class.getName());

    public CRMHomePage() {

    }

    private static By LoginButton1=By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']");
    protected static By settingsBtn = By.xpath("//div[@role='listbox']");
    protected static By email_Field_login = By.xpath("//input[@name='email']");
    protected static By password_Field_login = By.xpath("//input[@name='password']");
    protected static By loginButton2 =By.xpath("//div[text()='Login']");
    protected static By FreeAccLink=By.xpath("//a[normalize-space()='Free account']");
    protected static  By FreeAccSettingsLogo=By.xpath("//div[@class='sub header']");
    protected static By dealsPage=By.xpath("//div[contains(text(),'Deals')]");

    //Card details
    protected static By PayUsingDebit_or_CreditCard =By.xpath("//a[normalize-space()='Pay using a Debit or Credit Card']");
    protected static By cardDetails_NameOnCard =By.xpath("//input[@id='name']");
    protected static By cardDetails_cardNumber=By.xpath("//input[@id='number']");
    protected static By cardDetails_ExpairyDate=By.xpath("//input[@id='expiration']");
    protected static By carsDetails_CVV=By.xpath("//input[@id='cvc']");
    protected static By cardDetails_Address=By.xpath("//input[@id='address']");
    protected static By cardDetails_CityName=By.xpath("//input[@id='city']");
    protected static By cardDetails_StateName=By.xpath("//input[@id='state']");
    protected static By cardDetails_ZipCode=By.xpath("//input[@id='zipcode']");
    protected static By cardDetails_CountryDropDown=By.xpath("//input[@class='search']");
    protected static By cardDetails_saveButton=By.xpath("//button[normalize-space()='Save Card']");

    //Account Settings Menu
      public static By myPlan=By.xpath("//div/a[normalize-space()='My Plan']");
    protected static By invoices=By.xpath("//a[normalize-space()='Invoices']");
    protected static By charges=By.xpath("//div/a[normalize-space()='Charges']");
    protected static By telephonyBilling=By.xpath("//div/a[normalize-space()='Telephony Billing']");
    protected static By terminateAccount=By.xpath("//a[normalize-space()='Terminate Account']");
    protected static By invoicesAmmount=By.xpath("//tr/th[contains(text(),'Amount')]");
    protected static By chargesDescription=By.xpath("//th[normalize-space()='Description']");
    protected static By phoneBillingUpdateToPro=By.xpath("//button[normalize-space()='Upgrade to Pro']");
    protected static By deleteAccConformingField =By.xpath("//input[@name='confirm']");
    protected static By terminateAccButton=By.xpath("//button[normalize-space()='Terminate Account']");



    protected String dealsPageActualText ="Deals";
    protected String ActualLogoText ="Manage your preferences";
    protected static String invoiceActualText ="Amount";
    protected static String chargesActualText ="Description";
    protected static String ProButtonActualText="Upgrade to Pro";


    public boolean verifySuccessfulLogin() {
        log.info("current step ::" + " verifying homepage is loaded or not");

        if (isDisplayed(settingsBtn)) {
            ExtentReportManager.getExtentTest().pass("Login successful");
        } else {
            ExtentReportManager.getExtentTest().fail("Login was not successful");
        }
        return isDisplayed(settingsBtn);
    }

    public static String doLogin(){
        click(LoginButton1);
        sendKeys(email_Field_login, ReadPropertyUtil.getUsername("username"));
        sendKeys(password_Field_login,ReadPropertyUtil.getPassword("password"));
        click(loginButton2);
       String DealsPageActualText= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,dealsPage).getText();


        return DealsPageActualText;
    }
    public static String verifyFreeAccLink(){
        click(FreeAccLink);
        String logoSubText=ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,FreeAccSettingsLogo).getText();

        return logoSubText;

    }
    public static boolean verifyMyPlan(){
        click(myPlan);
       // String myPlanText=ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,myPlan).getText();
       boolean myPlanIsDisplayed= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,myPlan).isDisplayed();
        click(PayUsingDebit_or_CreditCard);
        sendKeys(cardDetails_NameOnCard,"Shiva Kumar");
        sendKeys(cardDetails_cardNumber,"90879654321233");
        sendKeys(cardDetails_ExpairyDate,"90/89");
        sendKeys(carsDetails_CVV,"960");
        sendKeys(cardDetails_Address,"xxxxxxxxaaaaabbbbbbb,dddddddd.");
        sendKeys(cardDetails_CityName,"Chennai");
        sendKeys(cardDetails_StateName,"Tamilnadu");
        sendKeys(cardDetails_ZipCode,"988934");
        click(cardDetails_CountryDropDown);
        sendKeys(cardDetails_CountryDropDown,"china");
        click(cardDetails_saveButton);


        return myPlanIsDisplayed;
    }

    public static String verifyInvoices(){
        click(invoices);
       WebElement invoiceTableHeadAmount= ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,invoicesAmmount);

      return invoiceTableHeadAmount.getText();
    }

    public static String verifyCharges(){

        click(charges);
        WebElement chargesTableHeadDescription=ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE,chargesDescription);


        return chargesTableHeadDescription.getText();
    }
    public static String verifyTelephonyBilling() {
        click(telephonyBilling);
        WebElement updateToProButton = ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, phoneBillingUpdateToPro);
        String ProButtonExpectedText = updateToProButton.getText();
        if (ProButtonExpectedText.equals(ProButtonActualText)) {
            click(phoneBillingUpdateToPro);
            verifyMyPlan();

        } else {
            throw new RuntimeException("Exception Occurred  at ::"+ new Object().getClass().getEnclosingMethod().getName());
        }
        return ProButtonExpectedText;
    }

    public static boolean verifyTerminateAccount(){
        click(terminateAccount);
        sendKeys(deleteAccConformingField,"delete me");
        WebElement deleteAccButton=ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,terminateAccButton);
        boolean isDisplatyedDeleteButton=deleteAccButton.isDisplayed();

        return isDisplatyedDeleteButton;

    }
}




