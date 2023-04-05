package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
