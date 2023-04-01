package com.oriontech.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Set;

public class MultipleWindowHandle extends BaseUiTest {
    private static final String URL = "https://www.lambdatest.com/selenium-playground/window-popup-modal-demo";

    @Test
    public void handleMultipleWindows() {
        driver.get(URL);
        driver.findElement(By.cssSelector("[title*='Twitter']")).click();
        System.out.println(driver.getTitle());
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String currentWindow : allWindowHandles){
            if(!currentWindow.equals(mainWindowHandle)){
                driver.switchTo().window(currentWindow);
            }
        }
        System.out.println(driver.getTitle());
    }

    @Test
    public void handleMultipleWindowsBasedOnTitle() {
        driver.get(URL);
        driver.findElement(By.cssSelector("[title*='Twitter']")).click();
        System.out.println(driver.getTitle());
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String currentWindow : allWindowHandles){
            String pageTitle = driver.switchTo().window(currentWindow).getTitle();
            if(pageTitle.contains("Twitter")){
                driver.switchTo().window(currentWindow);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.switchTo().window(mainWindowHandle);
    }
}
