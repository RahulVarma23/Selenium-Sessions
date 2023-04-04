package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesDemoTest extends BaseUiTest {

    @Test
    public void handleIframe() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        Assert.assertTrue(driver.getTitle().contains("Droppable"));

        Thread.sleep(2000);

        WebElement frameElement = driver.findElement(By.cssSelector(".demo-frame"));

        driver.switchTo().frame(frameElement);

        WebElement destination = driver.findElement(By.cssSelector("div[class*='droppable']"));
        WebElement source = driver.findElement(By.cssSelector("div[class*='draggable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();
        Assert.assertTrue(destination.getText().equals("Dropped!"));

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[href*=accordion]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/accordion/"));
    }
}
