package com.ui.utility;

import com.constants.Browsers;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//this class has browser related functions which helps in hiding the selenium functions
public abstract class BrowserUtility {
    Logger logger=LoggerUtility.getLogger(this.getClass());
    private WebDriver driver;//Variables that are created inside the class and they are non static are called as instance variables and they are created in the heap m/m. Here WebDriver is a non-primitive datatype and the default value of driver is null
    //driver is an instance variable and this is initialised by the constructor
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver = driver;//initialise the instance variable driver--> local variable and this.driver is the instance variable
        //this keyword is used to differentiate the local and instance variable if the names are the same

    }
    public BrowserUtility(String browserName){
        logger.info("Launching the browser "+browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }
        else{
            logger.error("Invalid Browser.....Please select chrome or edge");
            System.err.println("Invalid Browser.....Please select chrome or edge");
        }
    }
    public BrowserUtility(Browsers browserName) {
        if (browserName == Browsers.CHROME) {
            driver = new ChromeDriver();
        } else if (browserName == Browsers.EDGE) {
            driver = new EdgeDriver();
        } else if (browserName == Browsers.FIREFOX) {
            driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() { //getter
        return driver;
    }

    public void gotoWebsite(String url){
        logger.info("Visiting the url  "+url);
        driver.get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximise the window");
        driver.manage().window().maximize();
    }

    //Click an element
    public void clickOn(By locator){
        logger.info("Finding the locator "+locator);
        WebElement webelement=driver.findElement(locator); //Find the element
        logger.info("Click the locator");
        webelement.click();
    }

    //Enter values in to the text fields
    public void enterText(By locator,String texttoenter){
        logger.info("Finding the locator "+locator);
        WebElement webelement=driver.findElement(locator); //Find the element
        logger.info("Enter the text "+texttoenter);
        webelement.sendKeys(texttoenter);
    }

    //Get the text of a webelement
    public String getVisibleText(By locator){
        logger.info("Finding the locator "+locator);
        WebElement webelement=driver.findElement(locator); //Find the element
        logger.info("Returning the visible texts "+webelement.getText());
        return webelement.getText();
    }
}
