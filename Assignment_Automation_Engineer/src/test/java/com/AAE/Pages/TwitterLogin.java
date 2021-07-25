package com.AAE.Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwitterLogin {
	
	WebDriver driver;
	
	public TwitterLogin(WebDriver driver)
	{
		this.driver=driver;
		
	}

	By username = By.name("session[username_or_email]");
	By PasswordInput = By.name("session[password]");
	By Login = By.xpath("//div[@class='css-1dbjc4n']//span[text()='Log in']");
	
	public void login(String Username, String Password) throws Exception
	{
		driver.findElement(username).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(PasswordInput).sendKeys(Password);
		Thread.sleep(2000);
		List<WebElement> s =driver.findElements(Login);
		WebElement Login = s.iterator().next();
		Login.click();
		
	}
	
}
