package com.oriontech.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import staticData.enums.WidgetType;

public class BrowserNavigationCommands extends BaseUiTest {

    String locator = "a[href*=%s]";
    private static final String URL = "https://jqueryui.com/droppable/";

    @Test
    public void handleBrowserNavigation() {
        driver.get(URL);
        clickOnWidget(WidgetType.AUTOCOMPLETE.getValue());
        refreshPage();
        driver.navigate().back();
        driver.navigate().forward();
    }

    public void clickOnWidget(String widgetType) {
        String formattedLocator = String.format(locator, widgetType);
        System.out.println(formattedLocator);
        driver.findElement(By.cssSelector(formattedLocator)).click();
    }
}
