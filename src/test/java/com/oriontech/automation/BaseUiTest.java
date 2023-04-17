package com.oriontech.automation;

import core.CustomDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class BaseUiTest {

    protected WebDriver driver;

    @BeforeSuite
    public void cleanUp() {
        String directoryToClean = ".//screenshots";
        File file = new File(directoryToClean);
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException("Directory not found" +e);
        }
    }

    @Parameters("browser")
    @BeforeMethod
    public void initializeDriver(@Optional("chrome") String browser) {
        driver = CustomDriver.initializeChrome(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void onTestFailure(ITestResult result) throws IOException {
        String methodName = result.getName().trim();
        if(ITestResult.FAILURE==result.getStatus()){
            takeScreenshot(methodName);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String getDateTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void takeScreenshot(String methodName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String filePath = ".//screenshots/" + methodName + getDateTime("dd-MM-YYYY_HH-mm-ss") + ".png";
        File destination = new File(filePath);
        FileUtils.copyFile(source , destination);
    }
}
