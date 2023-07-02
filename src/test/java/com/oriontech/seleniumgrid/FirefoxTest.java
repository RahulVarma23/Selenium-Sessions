package com.oriontech.seleniumgrid;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirefoxTest {

    URL url;
    RemoteWebDriver driver;

    @Test
    public void firefoxTest() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        url = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url,firefoxOptions);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle() +"-> firefox");
    }

    @AfterMethod
    public void onTestFailure(ITestResult result) throws IOException {
        String methodName = result.getName().trim();
            takeScreenshot(methodName);
            driver.quit();

    }

    public String getDateTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public void takeScreenshot(String methodName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String filePath = ".//screenshots/" + methodName + getDateTime("dd-MM-YYYY_HH-mm-ss") + ".png";
        File destination = new File(filePath);
        FileUtils.copyFile(source , destination);
    }

}
