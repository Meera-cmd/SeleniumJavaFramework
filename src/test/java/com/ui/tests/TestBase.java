package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browsers.CHROME;

public class TestBase {
    protected HomePage homePage; // protected because it will be accessible in the child classes
    Logger logger= LoggerUtility.getLogger(this.getClass());

    @BeforeMethod(description = "Load the homePage of the website")
    public void setUp() {
        logger.info("Load the home page of the website");
        homePage = new HomePage(CHROME);

    }

    public BrowserUtility getInstance(){
        return homePage;
    }
}
