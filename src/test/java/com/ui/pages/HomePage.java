package com.ui.pages;

import com.constants.Browsers;
import static com.constants.Env.*;
import com.ui.utility.BrowserUtility;
import static com.ui.utility.PropertiesUtil.*;

import com.ui.utility.JSONUtility;
import com.ui.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

    public HomePage(Browsers browserName) {
        super(browserName);// to call the parent class constructor from the child constructor
//        gotoWebsite(readProperty(QA,"URL"));
        gotoWebsite(JSONUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage goToLoginPage(){ //Page functions -- cannot return void
        logger.info("Click the sign in button for log in");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage =new LoginPage(getDriver());//As per the LoginPage constructor it has a parameter driver. So we need to pass the driver here
        //for that we need to use the getter getDriver() .Here we are giving the session from one page class object to another page class object
        return loginPage;

    }

}
