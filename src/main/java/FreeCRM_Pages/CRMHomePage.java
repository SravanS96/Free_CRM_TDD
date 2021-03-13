package FreeCRM_Pages;

import ExtentReports.ExtentReportManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public final class CRMHomePage extends Basepage {
    private static Logger log = LogManager.getLogger(Basepage.class.getName());
    public CRMHomePage(){

    }

    protected static By settingsBtn=By.xpath("//div[@role='listbox']");

    public boolean verifySuccessfulLogin(){
        if (isDisplayed(settingsBtn)) {
            ExtentReportManager.getExtentTest().pass("Login successful");
        } else {
            ExtentReportManager.getExtentTest().fail("Login was not successful");
        }
        return isDisplayed(settingsBtn);
    }



}
