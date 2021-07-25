/**
 * 
 */
package com.AAE.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.AAE.Config.PropertiesFile;
import com.AAE.Pages.ComposeMail;
import com.AAE.Pages.EmailPage;
import com.AAE.Pages.Logout;
import com.AAE.Pages.SignIn_EmailID;
import com.AAE.Pages.SignIn_Password;
import com.AAE.Utility.BrowserControl;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Raushan
 *
 */
public class GmailActivities {
	WebDriver driver;
	PropertiesFile inputData;
	ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	ExtentTest test;
	public GmailActivities() throws Exception 
	{
		
		inputData = new PropertiesFile(); 
	
		
	}
	
	
	@BeforeSuite
	public void reports() 
	{
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("./Reports/AutomationAssignment.html");
		extent.attachReporter(sparkReporter);
	}
	
	@AfterSuite
	public void reportFulsh() {
		extent.flush();

	}
	
	@BeforeClass
	public void setup() 
	{
	String Browser =	inputData.dataExtract("browser");
		
		BrowserControl browser = new BrowserControl();
		driver=browser.browserControl(Browser);
		driver.manage().window().maximize(); 
	}


	@Test(priority=1) 
	public void loginTest() throws Exception 
	{
		/**
		 * 
		 *   InputData related to this methods
		 */

		
		String URL=inputData.dataExtract("URL");
		String EmailID =inputData.dataExtract("EmailID"); 
		String Password =inputData.dataExtract("Password");

		/* Operation */
		test = extent.createTest("TC1_Login to Gmail account");
		
		driver.get(URL);
		test.log(Status.INFO, "Navigate to Gmail URL:"+"https://www.gmail.com/");
		
		
		/* Create object of SingIn_EmailID Page and SignIn_Password page */
		SignIn_EmailID Step1 = new SignIn_EmailID(driver); 
		SignIn_Password Step2 =	new SignIn_Password(driver);
		
		
		/* Login to Gmail account */
		Step1.LoginStep1(EmailID); 
		test.log(Status.INFO, "Email-Id entered into Input field");
		Thread.sleep(3000);
		Step2.loginStep2(Password);
		test.log(Status.INFO, "Password entered into Input field and clicked on Next Button");
		
		/* Verify Successful Login */
		Assert.assertEquals(driver.getTitle(), "Gmail");
		test.log(Status.PASS, "Successfully logged in to your email account");

	}

	@Test(priority=2)
	public void getNumberOfTotalMailsTest() 
	{
		test = extent.createTest("TC2_Get the total numbers of mails available in user's account");
		EmailPage getMailCount = new EmailPage(driver);
		test.log(Status.INFO, "Getting total numbers on mail availble in inbox");
		String totalMails = getMailCount.getTotalNumberOfMailsInGmail();
		if(totalMails!=null) 
		{
			test.log(Status.PASS, "Total Number of mail is: "+totalMails);
		}
		else {
			test.log(Status.FAIL, "Not able to find the total numbers of mail");
		}
		
	}


	@SuppressWarnings("deprecation")
	@Test(priority = 3)
	public void getMailSenderNameTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EmailPage senderName = new EmailPage(driver);
		test=extent.createTest("TC3_Get the mail sender name of the first mail");	
		test.log(Status.INFO, "Getting the mail sender name.");
		  String mailSenderName = senderName.getMailSenderName();
		  if(mailSenderName!= null) 
		  {
			  test.log(Status.PASS, "First mail in the inbox is :"+mailSenderName);
		  }
		  else {
			test.log(Status.FAIL, "Not able to find the mail sender name. Some issue with code. Please check.");
		}
		  
		 
		
	}
	
	@Test(priority=4)
	public void composeMailTest() throws Exception
	{
		/* Get the data from properties files */
		String To = inputData.dataExtract("TO");
		String MailSubject = inputData.dataExtract("MailSubject");
		
		
		/* Creating object of ComposeMail class */
		ComposeMail mail = new ComposeMail(driver);
		test = extent.createTest("TC4_Compose Mail");
		
		test.log(Status.INFO, "Composing the mail and sending the mail");
		
		mail.composeMail(To,MailSubject);
		test.log(Status.PASS, "Mail has been sent successfully.");
	}
	
	@Test(priority=5)
	public void logoutFromAccountTest() throws Exception
	{
		test = extent.createTest("TC4_Logout from the google account.");
		Logout SignOut = new Logout(driver);
		test.log(Status.INFO, "Logging out from the account");
		SignOut.logoutFromAccount();
		test.log(Status.PASS, "Logged out from the account successfully.");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
