package com.ui.tests;

import com.constants.Browsers;
import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Locale;

import static com.constants.Browsers.CHROME;

public class TestBase {
    protected HomePage homePage; // protected because it will be accessible in the child classes
    Logger logger= LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;
    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Load the homePage of the website")
    public void setUp(@Optional("chrome") String browser,
                      @Optional("false") boolean isLambdaTest,
                      @Optional("true") boolean isHeadless, ITestResult result) {
        this.isLambdaTest=isLambdaTest;

        WebDriver lambdaDriver;
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
            homePage=new HomePage(lambdaDriver);

        } else {
            logger.info("Load the home page of the website");
            homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadless);

        }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown() {
        if(isLambdaTest){
            LambdaTestUtility.quitSession();
        }else {
            homePage.quit();
        }
    }
}


