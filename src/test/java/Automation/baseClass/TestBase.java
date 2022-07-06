package Automation.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBase {

    //This class uses all the repeated code needed in the test cases
    //such as the before and after methods, webdriver instance and verification errors field
    //keeping the test files nice and tidy

    protected WebDriver driver; //instance of driver accessible to all methods

    //Create a field to collect verification errors
    protected StringBuffer verificationErrors = new StringBuffer();

    @BeforeEach
    void setUp(){
        //Fetch webDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown(){
         driver.quit();

        //report any verification errors
        String verificationErrorsString = verificationErrors.toString();
        if(!verificationErrorsString.isEmpty()){
            fail("Found Verification Errors: " + verificationErrorsString);
        }
    }
}
