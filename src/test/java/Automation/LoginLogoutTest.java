package Automation;

import Automation.Utilities.Helpers;
import Automation.baseClass.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //forcing order of tests

public class LoginLogoutTest extends TestBase {

    //THIS IS TESTING WITH JUNIT AND SELENIUM

    @Test
    @Tag("Run this but not ignore")
    //@Order(2) //@TestMethodOrder in public class must be implemented as well for this to work
    void firstTest() throws InterruptedException {

        //Test commands reference the driver object and call methods against it
        driver.get("https://www.edgewordstraining.co.uk/webdriver/");

        //Find element
        driver.findElement(By.linkText("Access Basic Examples Area"));

        //Find element and click it
        driver.findElement(By.linkText("Login To Restricted Area")).click();

        //Type input
        driver.findElement(By.id("username")).sendKeys("edgewords");
        driver.findElement(By.id("password")).sendKeys("edgewords123");

        driver.findElement(By.linkText("Submit")).click();
        Thread.sleep(4000);

        //Check if user logged in successfully
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Body Text is: " + bodyText);

        try {
            assertThat("Not logged in", bodyText, containsString("User is Logged in"));
        } catch (AssertionError e) {
            //Continue past assertion fail
            //Append errors in caught assertion failure
            verificationErrors.append(e.toString());
        }

        //Instantiate the helpers class to access its methods
        Helpers helpers = new Helpers(driver);

        //calling the waitForElement method from the helpers class on an element and saving it in a variable
        WebElement logoutLink = helpers.waitForElementToBeClickable(By.linkText("Log Out"), 3);
        logoutLink.click();

        //Call the method from helpers class that handles the alert pop-up
        helpers.handleAlert();
    }

    @Test
    //@Order(1)
    void secondTest(){
        driver.get("https://www.edgewordstraining.co.uk/demo-site/");
    }

}
