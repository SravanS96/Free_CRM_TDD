package com.qa.Base.Base;


import Drivers.Drivers;
import FreeCRM_Pages.CRM_LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base{
    private static final Logger log = LogManager.getLogger(CRM_LoginPage.class.getName());


    protected Base(){

    }

    @BeforeMethod
    protected void setUP(){
        log.info("Current Step ::"+"Setting Up environment");
       // System.out.println(" Setting Up environment");

        Drivers.initDriver("browser", "headless_mode");

    }

    @AfterMethod
    protected void tearDown() {
        log.info("Current Step ::"+"Closing environment");
       // System.out.println("Closing environment");
        Drivers.closeDriver();

    }
}


