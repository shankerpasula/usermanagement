package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage
{
	WebDriver driver;
	LoginPage loginpage;
	public LocalePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()='Locale']")
	static WebElement waitforlocalepage;
	
	@FindBy(how = How.ID, using = "defaultLocale")
	static WebElement list_defaultlocale;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnChoose']")
	static WebElement button_Choose;
	
	public void waitforLocalePage()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.
		visibilityOfAllElementsLocatedBy((By) waitforlocalepage));
		
	}
	
	public WebElement getDefaultLocaleList()
	{
		return list_defaultlocale;
	}
	
	public WebElement getChooseButton()
	{
		return button_Choose;
	}
}
