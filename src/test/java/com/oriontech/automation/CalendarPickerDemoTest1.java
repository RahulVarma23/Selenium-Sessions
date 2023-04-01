package com.oriontech.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class CalendarPickerDemoTest1 extends BaseUiTest {


    String URL = "https://www.goibibo.com/";
    String MonthToBeSelected = "August 2023";
    String DAY = "20";

    @Test
    public void datePicker() {
        driver.get(URL);
        //close login pop up
        driver.findElement(By.cssSelector("span[class='logSprite icClose']")).click();
        // Clicking on Departure Date Picker Box
        driver.findElement(By.xpath("//span[text()='Departure']")).click();
        while (true)
        {
            String monthOnPage = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']")).getText();
            if (monthOnPage.equals(MonthToBeSelected))
            {
                break;
            } else {
                driver.findElement(By.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
            }
        }
        driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/p[text()=" + DAY + "]")).click();
    }
}
