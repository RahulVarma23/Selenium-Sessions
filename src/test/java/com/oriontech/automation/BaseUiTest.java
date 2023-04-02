package com.oriontech.automation;

import core.CustomDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseUiTest {

    WebDriver driver;

    @BeforeMethod
    public void runPrerequisite() {
        driver = CustomDriver.initializeChrome();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
