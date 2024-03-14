package com.base.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.app.pages.HomePage;

public class Base 
{
	public static WebDriver driver;
	public static String URL;
	public static String browserName;
	public static String chromePath;
	public static String projectPath = System.getProperty("user.dir");

	public static FileInputStream fi;
	public static FileOutputStream fo;

	public static Properties systemconfigproperties; 
	public static Properties dataconfigproperties;

	public static HomePage homePage;  // add this to base class

	@BeforeSuite
	public void read_Config_properties() throws IOException
	{
		PropertyUtils.read_system_config_properties();
		PropertyUtils.read_data_config_properties();		
	}

	@BeforeMethod
	public void int_browser_and_launch_URL() throws IOException
	{
		browserName = systemconfigproperties.getProperty("browserName");
		URL = systemconfigproperties.getProperty("url");
		chromePath = systemconfigproperties.getProperty("chromePath");

		System.out.println("Browser Name : " + browserName);

		switch(browserName) 
		{
		case "Edge":
			System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
			driver = new EdgeDriver();
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "path/to/fireFoxdriver");
			driver = new FirefoxDriver();
			break;

		case "Safari":
			System.setProperty("webdriver.safari.driver", "path/to/safaridriver");
			driver = new SafariDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();


			System.out.println(browserName + "loaded successfully");			
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


			TestBaseUtils.pagefactoryinstances();
		}
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
