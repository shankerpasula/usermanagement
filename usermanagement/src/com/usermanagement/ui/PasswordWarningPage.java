package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordWarningPage
{
	WebDriver driver;
   
	@FindBy(how = How.ID, using = "header-title")
	static WebElement waitforpasswordwarningpage;
	
	@FindBy(how = How.XPATH, using = "//input[@name='change_btn']")
	static WebElement button_changepasword;
	
	@FindBy(how = How.XPATH, using = "//input[@name='continue_btn']")
	static WebElement button_continue;
	
	
    public PasswordWarningPage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void waitforPasswordWarningPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) waitforpasswordwarningpage));
	} 
    
    
    public WebElement getChangePasswordButton()
    {
    	return button_changepasword;
    }
    
    public WebElement getContinueButton()
    {
    	return button_continue;
    }
}
