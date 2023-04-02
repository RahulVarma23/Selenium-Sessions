package com.oriontech.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WebTableDemoTest extends BaseUiTest {

    private static final String URL = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";
    @Test
    public void printWebTable() {
        driver.get(URL);
        int rowsCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
        int columnCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td")).size();

        for(int row =1 ;row<=rowsCount; row++ ){
            for(int column=1; column<=columnCount; column++){
                String locator = "//table[@id='example']/tbody/tr[%d]/td[%d]";
                String cellText = driver.findElement(By.xpath(String.format(locator,row,column))).getText();
                System.out.print(cellText+" ");
            }
            System.out.println();
        }
    }
}
