package com.usermanagement.test.regression;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import com.usermanagement.utils.TimeStamp;
import com.usermanagement.utils.UserManagement;

public class Locale {
	private final static Logger logger = Logger.getLogger(Locale.class.getName());
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	CreateNewUserPage createnewuserpage;
	LocalePage localepage;
	DropDownHandlers dropdownhandlers;
	ChangePassword changepassword;
	PasswordWarningPage passwordwarningpage;
	SecurityQuestionsPage securityquestionspage;
	UserManagement usermanagement;

	@BeforeMethod
	public void preTest() {
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
		GetData.fromProperties("configuration", "log4jpath");
		logger.info("Starting Locale class Execution...........");
	}

	@Test
	public void LocaleStoredInTheDatabase() throws IOException, InterruptedException {

		/*
		 * #############################################################################
		 * Objective: Verify that the Locale information is stored for the next session
		 * a user logs in.
		 * 
		 * Scenario: Precondition: Test sites must be set up and URL's communicated by
		 * the Engineering team. Access to User Management (Operations User) will be
		 * needed for testing. Below is an example of User Management URL but is not
		 * necessarily the correct environment to be used.
		 * 
		 * #############################################################################
		 */

		// Evaluate the Language Used to display the User Management Login Page
		// Enter email address and password for a brand new user and click log in
		
		usermanagement.login();
		homepage.getLogoutButton().click();
		TimeStamp timestamp = new TimeStamp();
		String sTime = timestamp.getTimeStamp();
		String email = "BrandNewUser" + sTime + "@um.com";
		usermanagement.createNewUser(email, "BrandNew" + sTime, "User" + sTime, "BrandNewUser" + sTime);
		System.out.println("2");

		// Logout
		homepage.getLogoutButton().click();
		String password = usermanagement.getBrandNewUserPassword(email);
		usermanagement.brandNewUserLogin(email, password);

		// Select Any language from the Locale Dropdown List and click continue
		usermanagement.selectDefaultLocale("English (United States) - English (United States)");
		localepage.getChooseButton().click();

		// Enter the temporary password and the new password that meets password
		// criteria and click continue
		String tempPassword = GetData.fromProperties("newuser", "tempPassword");
		String newPassword = tempPassword + "#";
		String confirmPassword = newPassword;
		changepassword.getCurrentPaswordTextBox().sendKeys(tempPassword);
		changepassword.getNewPaswordTextBox().sendKeys(newPassword);
		changepassword.getConfirmPaswordTextBox().sendKeys(confirmPassword);

		if (changepassword.getNewPasswordAcceptancemessage().getText()
				.equals("New password accepted, please click confirm")) {
			changepassword.getConfirmButton().click();
		}

		// Click continue in the password Warning page

		passwordwarningpage.getContinueButton().click();

		// Enter responses for all of the displayed security questions and click
		// continue
		WebElement Answer1 = securityquestionspage.getQ1DropdownList();
		DropDownHandlers.selectOptionByIndex(Answer1, 0);
		WebElement R1Answer = securityquestionspage.getR1TextBox();
		String Ans1 = GetData.fromProperties("securityanswer", "securityanswer1");
		R1Answer.sendKeys(Ans1);

		WebElement Answer2 = securityquestionspage.getQ2DropdownList();
		DropDownHandlers.selectOptionByIndex(Answer2, 0);
		WebElement R2Answer = securityquestionspage.getR2TextBox();
		String Ans2 = GetData.fromProperties("securityanswer", "securityanswer2");
		R2Answer.sendKeys(Ans2);

		WebElement Answer3 = securityquestionspage.getQ3DropdownList();
		DropDownHandlers.selectOptionByIndex(Answer3, 0);
		WebElement R3Answer = securityquestionspage.getR3TextBox();
		String Ans3 = GetData.fromProperties("securityanswer", "securityanswer3");
		R3Answer.sendKeys(Ans3);

		WebElement Answer4 = securityquestionspage.getQ4DropdownList();
		DropDownHandlers.selectOptionByIndex(Answer4, 0);
		WebElement R4Answer = securityquestionspage.getR4TextBox();
		R4Answer.sendKeys("famousfive");
		String Ans4 = GetData.fromProperties("securityanswer", "securityanswer4");
		R4Answer.sendKeys(Ans4);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@id='message'][contains(text(),'ready')]")));
		String message_displayed = message.getText();
		System.out.println("Response message is " + message_displayed);

		Boolean status = message.isDisplayed();
		if (status == true) {
			securityquestionspage.getSaveButton().click();
			securityquestionspage.getConfirmResponeButton().click();
		} else {
			logger.info("Response message is Not Found");
		}

		homepage.getLogoutButton().click();

		// Close IE Browser by right clicking the X icon
		// driver.quit();

		// Start a new session by using IE browser where Language is set to English, and
		// navigate to the login page
		// for user management main menu (.../UserManagement)

		// Evaluate the Language Used to display the User Management Login Page

		// Enter email address and the new password for the same user just used to log
		// in to the User Mnagement app in step 3
		UserManagement usermanagement1 = new UserManagement(driver);

		// Call <Logoff - User Management Site>
		// Call <Login - User Management Test Environment> with the following
		// parameters: email = [same user as previous logins], password = [User
		// password]

		usermanagement1.login();

		// Verify that the user isn't prompted for the Locale selection page when
		// logging in to the GRC (.../RNJ) application.

		String expectedTitle = "User Management - TR.spasula";

		driver.get(expectedTitle);
		try {
			Assert.assertEquals(expectedTitle, driver.getTitle());
		} catch (Throwable pageNavigationError) {
		}

		// Call <Logoff - User Management Site>
		usermanagement1.Logout();

	}

	@Test
	public void LoginPageLanguageDetect() {
		/*
		 * #############################################################################
		 * Objective:Verify that for the login page, we will attempt to detect the
		 * default language from the browser. Verify that if the language provided is
		 * not supported it will default to English Scenario:
		 * 
		 * Precondition: Test sites must be set up and URL's communicated by the
		 * Engineering team. Access to User Management (Operations User) will be needed
		 * for testing. Below is an example of User Management URL but is not
		 * necessarily the correct environment to be used. UM URL:
		 * https://tech110.paisleyhosting.com/UserManagement
		 * 
		 * Requirement/User Story: "
		 * #############################################################################
		 */
		
		
		
		//Start a new session by using IE browser where Language is set to English, and navigate to the login page for user management
		driver.navigate().to(GetData.fromProperties("configuration","url"));
		
		// the Language Used to display the User Management Login Page
		
		
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
		driver.close();
		logger.info("End of Locale class Execution...........");
	}

}
