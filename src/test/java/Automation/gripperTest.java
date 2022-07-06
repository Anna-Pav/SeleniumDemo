package Automation;

import Automation.baseClass.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class gripperTest extends TestBase {

    @Test
    void dragDrop() {
        driver.get("https://www.edgewordstraining.co.uk/webdriver/docs/cssXPath.html");

        //get the element
        WebElement gripper = driver.findElement(By.cssSelector("#slider > a"));

        //Use Actions class and pass driver in it
        Actions dragDrop = new Actions(driver);

        //save the object in a variable to reuse it when needed
        Actions newAction = (Actions) dragDrop.moveToElement(gripper) //move cursor to the gripper element
                .clickAndHold()  //click and hold
                .moveByOffset(10, 0) //move cursor by the offset
                .moveByOffset(10, 0) //move cursor by the offset
                .moveByOffset(10, 0) //move cursor by the offset
                .moveByOffset(10, 0) //move cursor by the offset
                .moveByOffset(10, 0) //move cursor by the offset
                .release();  //release cursor
               // .build();

        //new Action can be called repeatedly using perform method
        newAction.perform();
    }
}
