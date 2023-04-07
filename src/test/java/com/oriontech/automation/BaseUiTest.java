package com.oriontech.automation;

import core.CustomDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class BaseUiTest {

    WebDriver driver;

    @BeforeMethod
    public void runPrerequisite() {
        driver = CustomDriver.initializeChrome();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String methodName = result.getName().trim();
        takeScreenshot(methodName);
        driver.quit();
    }

    public String getDateTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(date);
        return formattedDate;
    }

    public void takeScreenshot(String methodName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String filePath = ".//screenshots/" + methodName + getDateTime("dd-MM-YYYY_HH-mm-ss") + ".png";
        File destination = new File(filePath);
        FileUtils.copyFile(source , destination);
    }
}
