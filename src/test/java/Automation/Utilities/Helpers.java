package Automation.Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Helpers {

    //This class holds methods that can be repeated in different test cases
    //keeping the test files nice and tidy

    //Field to hold the driver
    WebDriver driver;

    //Constructor to set the field - Constructor runs when the class is instantiated
    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    //UTILITY METHODS HERE
    //Wait Utility Method to be reused for clickable elements
    public WebElement waitForElementToBeClickable(By locator, int timeoutSeconds){

        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return myWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Accepts the pop up message on the webpage
    public void handleAlert(){

        String alertText = driver.switchTo().alert().getText(); //saving the alert text in a variable to check it in the console
        driver.switchTo().alert().accept();

        System.out.println("Accepted alert with text: " + alertText);
    }

    //Method to take screenshot with error handling
    public void takeScreenshot(String filename, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(scrFile, new File("C:\\Users\\maria\\IdeaProjects\\SeleniumProject" + filename + ".png"));
        }catch (IOException e) {
            System.out.println("Unable to capture screenshot with filename " + filename);
        }
    }
}
