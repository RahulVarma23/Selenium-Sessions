package com.oriontech.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	@Test(enabled=false)
	public void initializeChrome() {	
	  //System.setProperty("webdriver.chrome.driver", ".//src//main//resources//driver//chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--headless");
	  WebDriver driver = new ChromeDriver(options); 
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  System.out.println("Title is: "+title);
	  String currentUrl = driver.getCurrentUrl();
	  System.out.println("Url is: "+currentUrl);
	  driver.quit();  
	}
	
	@Test
	public void handleDropdown() throws InterruptedException {	
		  //System.setProperty("webdriver.chrome.driver", ".//src//main//resources//driver//chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		  //options.addArguments("--headless");
		  WebDriver driver = new ChromeDriver(options); 
		  driver.get("https://www.facebook.com");
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  System.out.println("Title is: "+title);
		  String currentUrl = driver.getCurrentUrl();
		  System.out.println("Url is: "+currentUrl);
		  
		  driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		  
		  Thread.sleep(2000);
		  boolean isElementPresent =driver.findElement(By.xpath("//button[@name='websubmit']")).isDisplayed();	  
		  Assert.assertEquals(isElementPresent, true , "Sign Up element is not present");  
		  driver.quit();  
		}
}
