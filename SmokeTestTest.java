// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SmokeTestTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void smokeTest() {
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
    driver.findElement(By.cssSelector("h1")).click();
    // 9 | assertText | css=h1 | Add A Record To the Database
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Add A Record To the Database"));
    // 11 | click | css=.last span | 
    driver.findElement(By.cssSelector(".last span")).click();
    // 12 | webdriverChooseOkOnVisibleConfirmation |  | 
    driver.switchTo().alert().accept();
    // 13 | click | css=h1 | 
    driver.findElement(By.cssSelector("h1")).click();
    // 14 | assertText | css=h1 | Access and Authentication
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Access and Authentication"));
  }
}
