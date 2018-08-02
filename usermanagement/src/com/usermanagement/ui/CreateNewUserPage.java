package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewUserPage {
	WebDriver driver;

	public CreateNewUserPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Create New User')]")
	static WebElement waitforcreatenewuserpage;
	
	@FindBy(how = How.XPATH, using = "//input[@name='selectAllCheckbox']")
	static WebElement checkbox_selectall;
	
	@FindBy(how = How.XPATH, using = "email")
	static WebElement textbox_email;
	
	@FindBy(how = How.NAME, using = "FirstName")
	static WebElement textbox_firstname;
	
	@FindBy(how = How.NAME, using = "LastName")
	static WebElement textbox_lastname;
	
	@FindBy(how = How.NAME, using = "UserId")
	static WebElement textbox_userid;
	
	@FindBy(how = How.NAME, using = "UserAdmin")
	static WebElement checkbox_useradmin;
	
	@FindBy(how = How.NAME, using = "AddUser")
	static WebElement button_adduser;
	
	@FindBy(how = How.NAME, using = "CopyUser")
	static WebElement button_copyuser;
	
	@FindBy(how = How.NAME, using = "Cancel")
	static WebElement button_cancel;
	
	public WebElement waitForCreateUserPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) waitforcreatenewuserpage));
		return null;
	}
	
	
	public WebElement getSelectAllCheckbox()
	{
		return checkbox_selectall;
	}
	
	public WebElement getEmailTextbox()
	{
		return textbox_email;
	}
	
	public WebElement getFirstNameTextbox()
	{
		return textbox_firstname;
	}
	
	public WebElement getLastNameTextbox()
	{
		return textbox_lastname;
	}
	
	public WebElement getUserIdTextbox()
	{
		return textbox_userid;
	}
	
	
	public WebElement getUserAdmincheckbox()
	{
		return checkbox_useradmin;
	}
	
	public WebElement getAddUserButton()
	{
		return button_adduser;
	}
	
	
	public WebElement getCopyUserButton()
	{
		return button_copyuser;
	}
	
	
	public WebElement getCancelButton()
	{
		return button_cancel;
	}
	
	
}
