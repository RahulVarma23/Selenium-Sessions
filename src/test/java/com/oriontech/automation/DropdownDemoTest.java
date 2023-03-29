package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class DropdownDemoTest extends BaseUiTest {

	@Test
	public void demo1() {
	  driver.get("https://www.google.com");
	  String title = driver.getTitle();
	  System.out.println("Title is: "+title);
	  String currentUrl = driver.getCurrentUrl();
	  System.out.println("Url is: "+currentUrl);
	  driver.quit();  
	}
	
	@Test
	public void handleDropdown() throws InterruptedException {
		  driver.get("https://www.facebook.com");
		  String title = driver.getTitle();
		  System.out.println("Title is: "+title);
		  String currentUrl = driver.getCurrentUrl();
		  System.out.println("Url is: "+currentUrl);
		  driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		  Thread.sleep(2000);
		  boolean isElementPresent =driver.findElement(By.xpath("//button[@name='websubmit']")).isDisplayed();	  
		  Assert.assertTrue(isElementPresent , "Sign Up element is not present");
		  driver.findElement(By.name("firstname")).sendKeys("Rahul");
		  WebElement dayDropdown = driver.findElement(By.cssSelector("#day"));
		  WebElement monthDropdown = driver.findElement(By.cssSelector("#month"));
		  WebElement yearDropdown = driver.findElement(By.cssSelector("#year"));

		  Select select = new Select(dayDropdown);
		  select.selectByIndex(2);
		  select = new Select(monthDropdown);
		  select.selectByValue("12");

		  select = new Select(yearDropdown);
		  select.selectByVisibleText("2010");

		List<WebElement> list = select.getOptions();
		List<String> newList = new ArrayList<>();

		for( WebElement webElement : list){
			newList.add(webElement.getText());
		}
		Assert.assertTrue(newList.contains("1905") , "Value is not present in dropdown");
		driver.quit();
		}
}
