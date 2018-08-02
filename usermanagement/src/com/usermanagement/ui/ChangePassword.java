package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePassword 
{
	WebDriver driver;

	public ChangePassword(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[text()='Change Password']")
	static WebElement waitforChangePasswordPage;
	
	@FindBy(how = How.ID, using = "currentPassword") 
	static WebElement textbox_currentpassword;

	@FindBy(how = How.ID, using = "password1") 
	static WebElement textbox_newpassword;
	
	@FindBy(how = How.ID, using = "password2") 
	static WebElement textbox_confirmpassword;
	
	@FindBy(how = How.ID, using = "password_button") 
	static WebElement button_confirm;
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='New password accepted, please click confirm']") 
	static WebElement msg_getnewpasswordaccepted;
	
	public void waitforChangePasswordPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) waitforChangePasswordPage));
	}
	
	public WebElement getCurrentPaswordTextBox()
	{
		return textbox_currentpassword;
	}
	
	public WebElement getNewPaswordTextBox() {
		return textbox_newpassword;
	}
	
	
	public WebElement getConfirmPaswordTextBox()
	{
		return textbox_confirmpassword;
	}
	
	public WebElement getConfirmButton()
	{
		return button_confirm;
	}
	
	public WebElement getNewPasswordAcceptancemessage()
	{
		return msg_getnewpasswordaccepted;
	}
	
}
