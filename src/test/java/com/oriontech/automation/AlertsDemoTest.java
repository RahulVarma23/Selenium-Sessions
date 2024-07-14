package com.oriontech.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsDemoTest extends BaseUiTest {

    @Test()
    public void handleAlerts() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name=cusid]")).sendKeys("53920");
        driver.findElement(By.cssSelector("input[name=submit]")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: "+ alert.getText());
        alert.accept();
        alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Customer Successfully Delete!"));
    }
}
