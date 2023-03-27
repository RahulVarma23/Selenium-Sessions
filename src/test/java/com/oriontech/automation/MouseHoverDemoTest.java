package com.oriontech.automation;

import com.oriontech.core.CustomDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void runPrerequisite() {
        driver = CustomDriver.initializeChrome();
        driver.manage().window().maximize();
    }

    @Test(priority=-1)
    public void handleMouseMovement() throws InterruptedException {
        driver.get("https://www.orangehrm.com/");

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.orangehrm.com/";
        Assert.assertEquals(currentUrl,expectedUrl,"Urls are not matching");

        WebElement platformLink = driver.findElement(By.xpath("//a[text()='Platform']"));
        WebElement peopleMgmtLink = driver.findElement(By.xpath("//div[@class='secondary-menu']//*[contains(text(),'People Management')]"));
        WebElement hrLink = driver.findElement(By.cssSelector("a[href='features/hr-administration']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(platformLink).moveToElement(peopleMgmtLink).moveToElement(hrLink).click().build().perform();

        Thread.sleep(2000);
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/hr-administration"));
    }

    @Test()
    public void handleKeyPress() {
        driver.get("https://www.google.com/");

        String pageTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(pageTitle,expectedTitle,"Titles are not matching");

        WebElement searchbox = driver.findElement(By.cssSelector("[title=Search]"));

        Actions actions = new Actions(driver);
        actions.sendKeys(searchbox, "mobile").sendKeys(Keys.ENTER).build().perform();
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("mobile - google search"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
