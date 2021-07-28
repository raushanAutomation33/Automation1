/**
 * 
 */
package com.AAE.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Raushan
 *
 */
public class BrowserControl {
		WebDriver driver;
		
	public WebDriver browserControl(String browserName) 
	{
		if(browserName.equals("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		return driver;
	}

}
