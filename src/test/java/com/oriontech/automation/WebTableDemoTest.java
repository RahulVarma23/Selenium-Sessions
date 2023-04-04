package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticData.enums.EmployeeTableColumnIndex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebTableDemoTest extends BaseUiTest {

    private static final String URL = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";
    private static final String locator = "//table[@id='example']/tbody/tr/td[%s]";

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


    @Test
    public void shouldValidateIfNameColumnIsSorted() {
        driver.get(URL);
        String formattedLocator = String.format(locator, EmployeeTableColumnIndex.NAME.getIndex());
        List<WebElement> webElementList = driver.findElements(By.xpath(formattedLocator));
        List<String> columnValues = new ArrayList<>();

        for(WebElement element: webElementList){
            String text = element.getText();
            columnValues.add(text);
        }

        List<String> copyList = new ArrayList<>(columnValues);
        Collections.sort(copyList);

        // List<String> sortedList = columnValues.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(copyList.equals(columnValues));
    }

    @Test
    public void shouldValidateIfOfficeColumnIsSorted() {
        driver.get(URL);
        String formattedLocator = String.format(locator, EmployeeTableColumnIndex.OFFICE.getIndex());
        List<WebElement> webElementList = driver.findElements(By.xpath(formattedLocator));
        List<String> columnValues = getTextInListOfWebElement(webElementList);

        List<String> copyList = new ArrayList<>(columnValues);
        Collections.sort(copyList);

        // List<String> sortedList = columnValues.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(copyList.equals(columnValues));
    }

    public List<String> getTextInListOfWebElement(List<WebElement>webElementList) {
        List<String> columnValues = new ArrayList<>();
        for(WebElement element: webElementList){
            String text = element.getText();
            columnValues.add(text);
        }
        return columnValues;
    }
}
