package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='kinesisDiv']")
	static WebElement waitforLoginPage;

	@FindBy(how = How.ID, using = "username")
	static WebElement textbox_UserName;

	@FindBy(how = How.ID, using = "password")
	static WebElement textbox_Password;

	@FindBy(how = How.ID, using = "btnLogin")
	static WebElement button_Login;

	@FindBy(how = How.ID, using = "//span[@id='message']")
	static WebElement msg_Error;

	public void waitforLoginPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) waitforLoginPage));
	}

	public WebElement getUsernameTextbox() {
		return textbox_UserName;
	}

	public WebElement getPasswordTextbox() {
		return textbox_Password;
	}

	public WebElement getLoginButton() {
		return button_Login;
	}

	public WebElement getErrorMessage() {
		return msg_Error;
	}
}
