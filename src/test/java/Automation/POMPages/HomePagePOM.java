package Automation.POMPages;

import Automation.baseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM extends TestBase {

    //BUILDING POM PAGES
    //They need 2 imports for webdriver and PageFactory

    //Step 1 - declare webdriver field  -->extended TestBase instead
    //private WebDriver driver;

    //Step 2 - declare constructor that uses the webdriver field
    public HomePagePOM(WebDriver driver) {
        this.driver = driver;

        //Step 3 - Initialise Page Factory with the driver inside the constructor
        PageFactory.initElements(driver, this);
    }

    //Step 4 - create your locators
    @FindBy (linkText = "Login To Restricted Area") //finds an element with the text
    WebElement loginLink;  //saves the element in variable

    //Step 5 - create your methods that use the locators for an action
    public void Login(){
        loginLink.click();  //clicks the element
    }

}
