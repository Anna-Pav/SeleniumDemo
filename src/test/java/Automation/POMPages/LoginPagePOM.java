package Automation.POMPages;

import Automation.baseClass.TestBase;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPagePOM extends TestBase {

    //BUILDING POM PAGES
    //They need 2 imports for webdriver and PageFactory

    //Step 1 - declare webdriver field   --> I extended testBse class instead that holds the driver
    //private WebDriver driver;

    //Step 2 - declare constructor that uses the webdriver field
    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;

        //Step 3 - Initialise Page Factory with the driver inside the constructor
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,3), this); //AjaxElm reducing stale element exceptions
    }

    //Step 4 - create your locators
    @FindBy (id = "username") WebElement username;
    @FindBy (id="password") WebElement password;
    @FindBy (linkText = "Submit") WebElement submitButton;
    @FindBy (tagName = "body") WebElement confirmationMessage;

    //Step 5 - create your methods that use the locators for an action

    public void login(String usernameInput, String passwordInput) throws InterruptedException {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        Thread.sleep(1000); //just to give time to see the acction
        submitButton.click();
    }

    public String getBodyText(){
       return confirmationMessage.getText();
    }

    public boolean failedLogin(String usernameInput, String passwordInput) {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        submitButton.click();

        //if alert message appears, login failed.
        boolean alertMsg=false; //Assuming there is no alert

        try {
            driver.switchTo().alert(); //if driver catches the alert - means login failed
                   alertMsg=true;                       //and so alert is now true
           // System.out.println("Login failed as expected!");
        } catch (NoAlertPresentException e) {
            //will jump here if driver fails to catch an alert - so login is successful
           // System.out.println("Oh no, Login successful!");
        }
        return  alertMsg; //true if login failed
    }

}
