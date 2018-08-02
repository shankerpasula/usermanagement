package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityQuestionsPage 
{
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//h2[text()='Security Questions']")
	static WebElement waitforsecurityquestionspage;
	
	@FindBy(how = How.XPATH, using = "PwmResponse_Q_Random_0")
	static WebElement list_response_Q_1;
	
	@FindBy(how = How.XPATH, using = "PwmResponse_Q_Random_1")
	static WebElement list_response_Q_2;
	
	@FindBy(how = How.XPATH, using = "PwmResponse_Q_Random_2")
	static WebElement list_response_Q_3;
	
	
	@FindBy(how = How.XPATH, using = "PwmResponse_Q_Random_3")
	static WebElement list_response_Q_4;
	
	
	@FindBy(how = How.XPATH, using ="PwmResponse_R_Random_0")
	static WebElement list_response_A_1;
	
	@FindBy(how = How.XPATH, using ="PwmResponse_R_Random_1")
	static WebElement list_response_A_2;
	
	@FindBy(how = How.XPATH, using ="PwmResponse_R_Random_2")
	static WebElement list_response_A_3;

	@FindBy(how = How.XPATH, using ="PwmResponse_R_Random_3")
	static WebElement list_response_A_4;
	
	@FindBy(how = How.ID, using ="message")
	static WebElement msg_responsemet;
	
	@FindBy(how = How.ID, using ="setresponses_button")
	static WebElement button_save;
	
	
	@FindBy(how = How.ID, using ="button_cancel")
	static WebElement button_cancel;
	
	@FindBy(how = How.XPATH, using ="//input[@name='change_btn']")
	static WebElement button_goback;
	
	@FindBy(how = How.XPATH, using ="//input[@name='confirm_btn']")
	static WebElement button_confirmresponse;
	
	@FindBy(how = How.XPATH, using ="//input[@name='button_cancel")
	static WebElement button_cancelresponse;
	
	public SecurityQuestionsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitforSecurityQuestionsPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) waitforsecurityquestionspage));
	}
	
	public WebElement getQ1DropdownList()
	{
		return list_response_Q_1;
		
	}
	
	public WebElement getQ2DropdownList()
	{
		return list_response_Q_2;
		
	}
	
	public WebElement getQ3DropdownList()
	{
		return list_response_Q_3;
		
	}
	
	public WebElement getQ4DropdownList()
	{
		return list_response_Q_4;
		
	}
	
	
	public WebElement getR1TextBox()
	{
		return list_response_A_1;
	}
	
	public WebElement getR2TextBox()
	{
		return list_response_A_2;
	}
	
	public WebElement getR3TextBox()
	{
		return list_response_A_3;
	}
	
	public WebElement getR4TextBox()
	{
		return list_response_A_4;
	}
	
	public WebElement getResponsesMetRequirementsmessage()
	{
		return msg_responsemet;
	}
	
	public WebElement getSaveButton()
	{
		return button_save;
	}
	
	
	public WebElement getCancelButton()
	{
		return button_cancel;
	}
	
	
	public WebElement getGoBackButton()
	{
		return button_goback;
	}
	
	
	public WebElement getConfirmResponeButton()
	{
		return button_confirmresponse;
	}
	
	public WebElement getCancelReponseButton()
	{
		return button_cancelresponse;
	}
}
