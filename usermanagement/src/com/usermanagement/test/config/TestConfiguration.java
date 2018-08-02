package com.usermanagement.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.usermanagement.utils.GetData;

public class TestConfiguration 
{
	public static WebDriver createDriverInstance()
	{
		WebDriver driver = null;
		String browser = GetData.
				fromProperties("configuration", "browser");
/*		String url = GetData.
				fromProperties("configuration", "url");*/
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",
					"./browser-drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./browser-drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"./browser-drivers/IEDriverServer32.exe");
			DesiredCapabilities Cap = new DesiredCapabilities();
			Cap.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			Cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(Cap);
		}
	
		else
		{
			System.err.print("Invalid browser option");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.get(url);
		return driver;
	}
}


/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
