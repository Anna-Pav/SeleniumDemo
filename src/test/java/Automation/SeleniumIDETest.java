package Automation;

import Automation.baseClass.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SeleniumIDETest extends TestBase {


    @Test  //forget that tag and the play button won't be there
    void IDETest() throws InterruptedException {

        //Copied the boilerplate code from the IDE.java file

        // Test name: SmokeTest
        // Step # | name | target | value
        // 1 | open | /webdriver/ |
        driver.get("https://www.edgewordstraining.co.uk/webdriver/");
        // 2 | click | css=li:nth-child(1) span |
        driver.findElement(By.cssSelector("li:nth-child(1) span")).click();
        // 3 | click | id=username |
        driver.findElement(By.id("username")).click();
        // 4 | type | id=username | edgewords
        driver.findElement(By.id("username")).sendKeys("edgewords");
        // 5 | click | id=password |
        driver.findElement(By.id("password")).click();
        // 6 | type | id=password | edgewords123
        driver.findElement(By.id("password")).sendKeys("edgewords123");
        // 7 | click | linkText=Submit |
        driver.findElement(By.linkText("Submit")).click();
        // 8 | click | css=h1 |
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("h1")).click();
        // 9 | assertText | css=h1 | Add A Record To the Database
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Add A Record To the Database"));
        // 11 | click | css=.last span |
        driver.findElement(By.cssSelector(".last span")).click();
        // 12 | webdriverChooseOkOnVisibleConfirmation |  |
        driver.switchTo().alert().accept();
        // 13 | click | css=h1 |
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("h1")).click();
        // 14 | assertText | css=h1 | Access and Authentication

        assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Access and Authentication"));
    }
}
