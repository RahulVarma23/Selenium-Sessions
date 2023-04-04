package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebTable2Demo extends BaseUiTest {

    String URL = "file:///C:/Users/HP/Downloads/website.html";

    @Test
    public void findCountriesPerContinent() {
        System.out.println(findCountriesPerCon());
    }

    public Map<String, Integer> findCountriesPerCon() {
        driver.get(URL);
        List<WebElement> webElementList = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));

        List<String> continent = new ArrayList<>();

        for(WebElement element : webElementList){
           String name= element.getText();
            continent.add(name);
        }
       // List<String> continent  = webElementList.stream().map(ele->ele.getText()).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String name: continent){
            if(map.containsKey(name)){
                map.put(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }

        return map;
    }
}
