package com.oriontech.automation;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarPickerDemoTest {


    @Test
    public void handleCalendarPicker() {
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(new Date());
        System.out.println(formattedDate);
    }
}
