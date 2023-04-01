package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarPickerDemoTest extends BaseUiTest {

    private static final String URL = "https://demo.guru99.com/test/";
    @Test
    public void handleCalendar() {
        String pattern = "dd-MM-yyyy HH:mm";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        Date date = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate= simpleDateFormat.format(date);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedFormattedDate = simpleDateFormat.format(date);

        String [] arr1 = expectedFormattedDate.split(" ");
        String expectedDate = arr1[0];
        String [] arr =formattedDate.split(" ");
        String date1 = arr[0];
        String time = arr[1];

        System.out.println(date1);
        System.out.println(time);

        driver.get(URL);
        WebElement calendarBox = driver.findElement(By.cssSelector("[name=bdaytime]"));
        calendarBox.sendKeys(date1);
        calendarBox.sendKeys(Keys.ARROW_RIGHT);
        calendarBox.sendKeys(time);
        driver.findElement(By.cssSelector("[type=submit]")).click();

        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Your Birth Date')]"));
        Assert.assertTrue(element.getText().contains("Your Birth Date is "+expectedDate));
        Assert.assertTrue(element.getText().contains("Your Birth Time is "+time));
    }
}
