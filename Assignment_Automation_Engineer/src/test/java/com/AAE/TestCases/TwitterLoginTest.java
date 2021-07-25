package com.AAE.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AAE.Pages.TwitterLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TwitterLoginTest {
	WebDriver driver;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void gotoTwitter() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/login");
		Thread.sleep(5000);
	}
	
	
	@Test
	public void LoginTest() throws Exception {
		TwitterLogin log = new TwitterLogin(driver); 
		
		log.login("pandeyraushan33@gmail.com", "1qaz@WSX");
		
	}
	@AfterTest
	public void closeBrowser() 
	{
		driver.quit();
	}
}
