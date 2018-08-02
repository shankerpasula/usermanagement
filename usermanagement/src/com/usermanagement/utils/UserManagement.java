package com.usermanagement.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.usermanagement.ui.CreateNewUserPage;
import com.usermanagement.ui.HomePage;
import com.usermanagement.ui.LocalePage;
import com.usermanagement.ui.LoginPage;

public class UserManagement {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	CreateNewUserPage createnewserpage;
	LocalePage localepage;

	public UserManagement(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {
		loginpage = new LoginPage(driver);
		String username = GetData.fromProperties("configuration", "username");
		String password = GetData.fromProperties("configuration", "password");
		loginpage.getUsernameTextbox().sendKeys(username);
		loginpage.getPasswordTextbox().sendKeys(password);
		loginpage.getLoginButton().click();
	}

	public void brandNewUserLogin(String email, String password) {
		loginpage = new LoginPage(driver);
		loginpage.getUsernameTextbox().sendKeys(email);
		loginpage.getPasswordTextbox().sendKeys(password);
		loginpage.getLoginButton().click();
	}

	public void Login(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.getUsernameTextbox().sendKeys(userName);
		loginpage.getPasswordTextbox().sendKeys(password);
		loginpage.getLoginButton().click();
	}

	public void selectDefaultLocale(String selectLanguage) {
		localepage = new LocalePage(driver);
		String defaultLocale = "en_US";
		String selectedLocale = localepage.getDefaultLocaleList().getAttribute("value");
		if (!selectedLocale.equals(defaultLocale)) {
			DropDownHandlers.selectOptionByVisibleText(localepage.getDefaultLocaleList(), selectLanguage);
		}
		Assert.assertEquals(defaultLocale, defaultLocale);
	}

	public boolean defaultLocale(String locale) {
		localepage = new LocalePage(driver);
		String defaultLocale = "en_US";
		String selectedLocale = localepage.getDefaultLocaleList().getAttribute("value");
		if (selectedLocale.equals(defaultLocale)) {
			Assert.assertEquals(selectedLocale, defaultLocale);
			return true;

		} else {
			Assert.assertNotEquals(selectedLocale, defaultLocale);
			return false;
		}

	}

	public void Logout() {
		homepage = new HomePage(driver);
		homepage.getLogoutButton();
	}

	public void createNewUser(String emailID, String firstName, String lastName,
			String userID)
	{
		homepage = new HomePage(driver);
		createnewserpage = new CreateNewUserPage(driver);
		homepage.waitforHomePage();
		homepage.getNewUserlink().click();
		createnewserpage.waitForCreateUserPage();
		createnewserpage.getEmailTextbox().sendKeys(emailID);
		createnewserpage.getFirstNameTextbox().click();
		createnewserpage.getFirstNameTextbox().sendKeys(firstName);
		createnewserpage.getLastNameTextbox().sendKeys(lastName);
		createnewserpage.getUserIdTextbox();
		createnewserpage.getUserAdmincheckbox().click();
		createnewserpage.getAddUserButton().click();

	}

	@SuppressWarnings("unchecked")
	public String getBrandNewUserPassword(String email) throws IOException {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password = null;
		String dropBox = GetData.fromProperties("configuration", "dropboxpath");
		System.out.println(dropBox);
		File folder = new File(dropBox);
		// System.out.println("List of Files : "+folder.listFiles().length);
		for (File file : folder.listFiles()) {
			if (file.getName().contains(email)) {
				List<String> content = FileUtils.readLines(file);
				for (String line : content) {
					if (line.startsWith("Your temporary password is:")) {
						password = line.split(":")[1].trim();
						System.out.println(email + " : " + password);
						if (password != null) {
							/*
							 * StoreData.toProperties("newuser", new String[] { "newUser", "tempPassword" },
							 * new String[] { email, password }, "getNewUserCredentials");
							 */
						}
						break;
					}

				}
			}
		}
		System.out.println("Done " + email);
		System.out.println("Done " + password);
		return password;

	}
}