package com.oriontech.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsDemoTest extends BaseUiTest {

    @Test
    public void handleAlerts() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name=cusid]")).sendKeys("53920");
        driver.findElement(By.cssSelector("input[name=submit]")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: "+ alert.getText());
        alert.accept();

        alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Customer Successfully Delete!"));
    }
}
