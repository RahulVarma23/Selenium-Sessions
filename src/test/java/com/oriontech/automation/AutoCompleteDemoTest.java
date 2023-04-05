package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutoCompleteDemoTest extends BaseUiTest {

    private static final String URL  = "https://www.google.com/";

    @Test
    public void handleGoogleSearch() {
        driver.get(URL);
        driver.findElement(By.name("q")).sendKeys("mobile");
        List<WebElement> webElementList = driver.findElements(By.cssSelector("ul[jsname=bw4e9b]>li"));

        for(WebElement element: webElementList){
            if(element.getText().equals("mobile shop wakad")){
                element.click();
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains("mobile shop wakad"));
    }
}
