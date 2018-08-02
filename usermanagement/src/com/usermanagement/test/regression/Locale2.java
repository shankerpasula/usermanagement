package com.usermanagement.test.regression;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.usermanagement.test.config.TestConfiguration;
import com.usermanagement.ui.ChangePassword;
import com.usermanagement.ui.CreateNewUserPage;
import com.usermanagement.ui.HomePage;
import com.usermanagement.ui.LocalePage;
import com.usermanagement.ui.LoginPage;
import com.usermanagement.ui.PasswordWarningPage;
import com.usermanagement.ui.SecurityQuestionsPage;
import com.usermanagement.utils.DropDownHandlers;
import com.usermanagement.utils.GetData;
import com.usermanagement.utils.UserManagement;


public class Locale2
{
	private final static Logger logger = Logger.getLogger(Locale.class.getName());
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	CreateNewUserPage createnewuserpage;
	LocalePage localepage;
	DropDownHandlers dropdownhandlers ;
	ChangePassword changepassword;
	PasswordWarningPage passwordwarningpage;
	SecurityQuestionsPage securityquestionspage;
	UserManagement usermanagement;


	@BeforeMethod
	public void preTest()
	{
		driver = TestConfiguration.createDriverInstance();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		createnewuserpage = new CreateNewUserPage(driver);
		localepage = new LocalePage(driver);
		changepassword = new ChangePassword(driver);
		passwordwarningpage = new PasswordWarningPage(driver);
		securityquestionspage = new SecurityQuestionsPage(driver);
		usermanagement = new UserManagement(driver);		
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, HomePage.class);

		GetData.fromProperties("configuration","log4jpath");
		logger.info("Starting Locale class Execution...........");
	}

	@Test
	public void LocaleStoredInTheDatabase() throws IOException, InterruptedException
	{
		/*##################################################################################################
		 * Objective: Verify that the Locale information is stored for the next session
		 * a user logs in.
		 * 
		 * Scenario: Precondition: Test sites must be set up and URL's communicated by
		 * the Engineering team. Access to User Management (Operations User) will be
		 * needed for testing. Below is an example of User Management URL but is not
		 * necessarily the correct environment to be used.
		 * 
		##################################################################################################*/		 

		//Start a new session by using IE browser where Language is set to English, and navigate to the login page for user management
		//driver.navigate().to(GetData.fromProperties("configuration","url"));
		usermanagement.login();
				
		// the Language Used to display the User Management Login Page
		String lang = driver.findElement(By.id("localeSelectionMenu")).getText();	
		System.out.println(lang);
				
		//Close IE Browser by right clicking the X icon
				
				
		//Start a new session by using IE browser where Primary Language is set to Chinese and secondary to Japanese, and navigate to the login page for user management
				
				
		//Evaluate the Language Used to display the User Management Login Page
				
				
		//Close IE Browser by right clicking the X icon
				
				
		//Start a new session by using IE browser where Primary Language is set to Chinese and secondary to German, and navigate to the login page for user management
				
				
		//Evaluate the Language Used to display the User Management Login Page
				
				
		//Close IE Browser by right clicking the X icon

			}

			@AfterMethod
			public void postTest() {
				//driver.close();
				logger.info("End of Locale class Execution...........");
			}

		}

	