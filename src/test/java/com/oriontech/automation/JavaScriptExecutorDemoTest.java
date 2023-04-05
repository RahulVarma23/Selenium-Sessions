package com.oriontech.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemoTest extends BaseUiTest {
    private static final String URL = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";
    @Test
    public void scrollToElement() {
        driver.get(URL);
        WebElement element = driver.findElement(By.xpath("//a[text()='Bulma']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll to element
        js.executeScript("arguments[0].scrollIntoView();",element);

        //generate alert
        js.executeScript("alert('welcome to selenium!')");

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
