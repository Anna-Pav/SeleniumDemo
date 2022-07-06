package Automation.POMTests;

import Automation.Utilities.Helpers;
import Automation.baseClass.TestBase;
import dev.failsafe.internal.util.Assert;
import org.apache.commons.logging.Log;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import Automation.POMPages.*;


public class loginTest extends TestBase {

    //Instantiate the helper class to use its method when needed
    Helpers helpers = new Helpers(driver);

    //TEST CASES USING THE POM PAGES
    @Test
    void testLoginRestrictedArea (){

        //Instantiate the POM pages/classes that you need
        HomePagePOM homePagePOM = new HomePagePOM(driver);

        driver.get("https://www.edgewordstraining.co.uk/webdriver/");
        homePagePOM.Login();
    }

    @DisplayName("Data read from CSV file for login")  //replaces the name of the method in the log for readability
    @ParameterizedTest //now that we have a csv file with data we can use them as parameters in out test instead of hardcoding them
    @CsvFileSource(files="testData.csv", useHeadersInDisplayName = true )  //giving the data source and whether we want the headers of it
    void testLoginData(String usernameCSV, String passwordCSV) throws InterruptedException {

        //Instantiate the POM pages/classes that you need
        LoginPagePOM loginPagePOM = new LoginPagePOM(driver);

        driver.get("https://www.edgewordstraining.co.uk/webdriver/sdocs/auth.php");
        loginPagePOM.login(usernameCSV,passwordCSV);  //we parameterized the username/password from the csv file

        Thread.sleep(2000);
        MatcherAssert.assertThat(loginPagePOM.getBodyText(), containsString("User is Logged in"));
        helpers.takeScreenshot("screenshot", driver);

    }

    @Test
    void testFailedLogin() throws InterruptedException {

        LoginPagePOM invalidData = new LoginPagePOM(driver);
        driver.get("https://www.edgewordstraining.co.uk/webdriver/sdocs/auth.php");

        boolean result = invalidData.failedLogin("something", "something");
        Thread.sleep(1000);
        MatcherAssert.assertThat("expected login to fail", result, is(not(false)));

        //Calls the method that clicks on the alert from the helpers class
        helpers.handleAlert();
    }


}
