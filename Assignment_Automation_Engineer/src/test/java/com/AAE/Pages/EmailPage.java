/**
 * 
 */
package com.AAE.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Raushan Pandey
 *
 */
public class EmailPage {
	
	WebDriver driver;
	WebDriverWait wait;
	/**
	 * @author Raushan
	 * Constructor created below
	 *
	 */	
	public EmailPage (WebDriver driver)
	{
		this.driver= driver;
	}
	
	/**
	 * @author Raushan
	 *	Required WebElements located below using different locators
	 */
	
	By TotalMailCount = By.xpath("//div[contains(@class,'J-J5-Ji amH J-JN-I')]//span[@class='Dj']/span[@class='ts']");
	By firstMailInInbox =By.xpath(("//tr[1]//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4']/span"));
	
	
	
	
	
	
	/**
	 * @author Raushan
	 *	Required method to get the total count of mails in the inbox.
	 */
	
	@SuppressWarnings("deprecation")
	public String getTotalNumberOfMailsInGmail() 
	{
		
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TotalMailCount));
		String totalMailsCount= driver.findElement(TotalMailCount).getText();
		System.out.println("totalMail:"+totalMailsCount);
	
		return totalMailsCount;
		
	}
	
	/**
	 * @author Raushan
	 *	Required method to get the senderName who is on top
	 */
	
	@SuppressWarnings("deprecation")
	public String getMailSenderName() 
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstMailInInbox));
		String senderName = driver.findElement(firstMailInInbox).getText();
		return senderName;
		
		   
	}
	

	
}
