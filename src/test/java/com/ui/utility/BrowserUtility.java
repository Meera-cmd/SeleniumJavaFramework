package com.ui.utility;

import com.constants.Browsers;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//this class has browser related functions which helps in hiding the selenium functions
public abstract class BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();//Variables that are created inside the class and they are non static are called as instance variables and they are created in the heap m/m. Here WebDriver is a non-primitive datatype and the default value of driver is null

    //driver is an instance variable and this is initialised by the constructor
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);//initialise the instance variable driver--> local variable and this.driver is the instance variable
        //this keyword is used to differentiate the local and instance variable if the names are the same

    }

    public BrowserUtility(String browserName) {
        logger.info("Launching the browser " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver.set(new EdgeDriver());
        } else {
            logger.error("Invalid Browser.....Please select chrome or edge");
            System.err.println("Invalid Browser.....Please select chrome or edge");
        }
    }

    public BrowserUtility(Browsers browserName) {
        if (browserName == Browsers.CHROME) {
            driver.set(new ChromeDriver());
        } else if (browserName == Browsers.EDGE) {
            driver.set(new EdgeDriver());
        } else if (browserName == Browsers.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
    }

    public BrowserUtility(Browsers browserName, boolean isHeadless) {
        if (browserName == Browsers.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");// if --headless=old is given because otherwise a wilte screen will be shown, this is to launch the browser in headless mode
                options.addArguments("--window-size=1920,1080");//to execute in full screen mode
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browsers.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");// if --headless=old is given because otherwise a white screen will be shown, this is to launch the browser in headless mode
                options.addArguments("disable-gpu");// if headless is not working to make sure that the browser is not launched
                driver.set(new EdgeDriver(options));
            } else {
                driver.set(new EdgeDriver());
            }
        } else if (browserName == Browsers.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");// if --headless=old is given because otherwise a wilte screen will be shown, this is to launch the browser in headless mode
                options.addArguments("--window-size=1920,1080");//to execute in full screen mode
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
            }
        }
    }

    public WebDriver getDriver() { //getter
        return driver.get();
    }

    public void gotoWebsite(String url) {
        logger.info("Visiting the url  " + url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximise the window");
        driver.get().manage().window().maximize();
    }

    //Click an element
    public void clickOn(By locator) {
        logger.info("Finding the locator " + locator);
        WebElement webelement = driver.get().findElement(locator); //Find the element
        logger.info("Click the locator");
        webelement.click();
    }

    //Enter values in to the text fields
    public void enterText(By locator, String texttoenter) {
        logger.info("Finding the locator " + locator);
        WebElement webelement = driver.get().findElement(locator); //Find the element
        logger.info("Enter the text " + texttoenter);
        webelement.sendKeys(texttoenter);
    }

    //Get the text of a webelement
    public String getVisibleText(By locator) {
        logger.info("Finding the locator " + locator);
        WebElement webelement = driver.get().findElement(locator); //Find the element
        logger.info("Returning the visible texts " + webelement.getText());
        return webelement.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path =  "./screenshots/" + name + "-" + timeStamp + ".png"; // give the
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void quit() {
        getDriver().quit();
    }
}
