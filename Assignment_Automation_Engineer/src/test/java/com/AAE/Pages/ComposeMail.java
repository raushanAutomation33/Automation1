/**
 * 
 */
package com.AAE.Pages;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Raushan
 *
 */
public class ComposeMail {
	
	WebDriver driver;

	/**
	 * @author Raushan
	 * Constructor created below
	 *
	 */
	public ComposeMail(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	
	
	/**
	 * @author Raushan
	 *	Required WebElements located below using different locators
	 */
	
	By composeButton= By.xpath("//div[@class='T-I T-I-KE L3']");
	By To = By.xpath("//table[@class='GS']//textarea[@name='to']");
	By SubjectInput = By.xpath("//input[@name='subjectbox']");
	By MessageBody = By.xpath("//div[@aria-label='Message Body']");
	By SendButton = By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");
	
	
	
	/**
	 * @author Raushan
	 *	Required methods to perform Mail Compose operation 
	 */
	public String Date() 
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Time== " +format.format(now));
		return format.format(now);
	}
	
	
	@SuppressWarnings("deprecation")
	public void composeMail(String ToEmail, String Subject) throws Exception
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(composeButton).click();
		Thread.sleep(3000);
		driver.findElement(To).sendKeys(ToEmail);
		driver.findElement(SubjectInput).sendKeys(Subject);
		driver.findElement(MessageBody).sendKeys(Date());
		driver.findElement(SendButton).click();
		
		
	}

}
