package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class GetAttributeDemoTest extends BaseUiTest {

    private static final String URL = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";

    @Test
    public void getAttributeOfElement() {
        driver.get(URL);
        WebElement element = driver.findElement(By.id("example_previous"));
        String value = element.getAttribute("aria-disabled");
        System.out.println(value);
        Assert.assertTrue(value.equals("true"));
    }

    @Test
    public void getAttributeOfTextBox() throws IOException {
        driver.get("https://www.facebook.com");
        WebElement element = driver.findElement(By.name("email"));

        element.sendKeys("rahulvarma@gmail.com");
        String value = element.getAttribute("value");
        System.out.println(value);
        driver.close();
    }
}
