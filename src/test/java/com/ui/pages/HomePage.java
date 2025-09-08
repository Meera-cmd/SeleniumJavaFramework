package com.ui.pages;

import com.constants.Browsers;
import com.ui.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

    public HomePage(Browsers browserName) {
        super(browserName);// to call the parent class constructor from the child constructor
        gotoWebsite("http://www.automationpractice.pl/index.php");
        maximizeWindow();
    }

    public LoginPage goToLoginPage(){ //Page functions -- cannot return void
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage =new LoginPage(getDriver());//As per the LoginPage constructor it has a parameter driver. So we need to pass the driver here
        //for that we need to use the getter getDriver() .Here we are giving the session from one page class object to another page class object
        return loginPage;

    }

}
