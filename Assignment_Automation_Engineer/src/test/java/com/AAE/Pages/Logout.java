/**
 * 
 */
package com.AAE.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Raushan
 *
 */
public class Logout {
	
	WebDriver driver;
	
	/**
	 * @author Raushan
	 * Constructor created below
	 *
	 */
	
	public Logout(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	/**
	 * @author Raushan
	 *	Required WebElements located below using different locators
	 */
	
	By MyProfileIcon = By.xpath("//a[@class='gb_C gb_Ma gb_h']"); 
	By SignOutButton = By.xpath("//a[@class='gb_Cb gb_Tf gb_2f gb_Pe gb_3c']");
	
	
	/**
	 * @author Raushan
	 *	Required methods to perform logout operation 
	 */
	
	public void logoutFromAccount() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(MyProfileIcon).click();
		Thread.sleep(2000);
		driver.findElement(SignOutButton).click();
		Thread.sleep(2000);
		
	}
}
