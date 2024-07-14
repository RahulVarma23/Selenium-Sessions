package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomDriver {

	public static WebDriver initializeChrome(String browser) {

		switch(browser){
			case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			return new ChromeDriver(options);

			case "firefox":
				FirefoxOptions options1 = new FirefoxOptions();
				//options.addArguments("--headless");
				return new FirefoxDriver(options1);

			default:
				return new EdgeDriver();
		}



//		if(browser.equalsIgnoreCase("chrome")){
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			//options.addArguments("--headless");
//			return new ChromeDriver(options);
//		}else if(browser.equalsIgnoreCase("firefox")){
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			//options.addArguments("--headless");
//			return new FirefoxDriver(options);
//		}
//		return null;
	}
}
