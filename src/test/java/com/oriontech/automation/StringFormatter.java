package com.oriontech.automation;

import staticData.enums.WidgetType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class StringFormatter extends BaseUiTest {

    String locator = "a[href1=%s]";
    private static final String URL = "https://jqueryui.com/droppable/";

    @Test
    public void handleMultipleElementsWithFormatter() {
        driver.get(URL);
        clickOnWidget(WidgetType.AUTOCOMPLETE.getValue());
    }

    public void clickOnWidget(String widgetType) {
        String formattedLocator = String.format(locator, widgetType);
        System.out.println(formattedLocator);
        driver.findElement(By.cssSelector(formattedLocator)).click();
    }
}
