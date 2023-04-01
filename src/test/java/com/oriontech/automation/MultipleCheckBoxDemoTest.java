package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleCheckBoxDemoTest extends BaseUiTest {

    private final static String URL = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";

    @Test
    public void handleMultipleCheckboxes() throws InterruptedException {
        driver.get(URL);
        List<WebElement> listOfWebElement = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[@class='  select-checkbox']"));

//        for(WebElement element : listOfWebElement){
//            element.click();
//        }
//        Iterator<WebElement> itr = listOfWebElement.iterator();
//        while(itr.hasNext()){
//            Thread.sleep(500);
//            WebElement element = itr.next();
//            element.click();
//        }
        listOfWebElement.stream().forEach(element-> element.click());
    }
}
