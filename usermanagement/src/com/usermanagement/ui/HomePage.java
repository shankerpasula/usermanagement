package com.usermanagement.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='contentContainer']")
	static WebElement waitforhomepage;

	@FindBy(how = How.XPATH, using = "//a[text()='New User']")
	static WebElement link_NewUser;

	@FindBy(how = How.XPATH, using = "//a[text()='Change Password']")
	static WebElement link_ChangePasword;

	@FindBy(how = How.XPATH, using = "//a[text()='Administer User'")
	static WebElement link_AdministerUser;

	@FindBy(how = How.XPATH, using = "//a[text()='User Group Membership'")
	static WebElement link_UserGroupMembership;

	@FindBy(how = How.XPATH, using = "//a[text()='User Group Membership'")
	static WebElement link_ImportUsers;

	@FindBy(how = How.XPATH, using = "//a[text()='Export Users'")
	static WebElement link_ExportUsers;

	@FindBy(how = How.XPATH, using = "//a[text()='View Password Rules'")
	static WebElement link_ViewPasswordRules;

	@FindBy(how = How.XPATH, using = "//a[text()='Edit Password Rules'")
	static WebElement link_EditPasswordRules;

	@FindBy(how = How.XPATH, using = "//a[text()='Client Settings'")
	static WebElement link_ClientSettings;

	@FindBy(how = How.XPATH, using = "//a[text()='Change Password'")
	static WebElement link_ChangePassword;

	@FindBy(how = How.XPATH, using = "//a[text()='Modify Security Questions'")
	static WebElement link_ModifySecurityQuestions;

	@FindBy(how = How.XPATH, using = "//a[text()='Set Default Locale'")
	static WebElement link_SetDefaultLocale;

	@FindBy(how = How.XPATH, using = "//a[text()='Set Default Locale'")
	static WebElement link_ReturntoApplication;

	@FindBy(how = How.XPATH, using = "//a[text()='System Administration Activity'")
	static WebElement link_SystemAdministrationActivity;

	@FindBy(how = How.XPATH, using = "//a[text()='User Access Activity'")
	static WebElement link_UserAccessActivity;

	@FindBy(how = How.XPATH, using = "//a[text()='User Summary'")
	static WebElement link_UserSummary;

	@FindBy(how = How.XPATH, using = "//a[text()='User Admin Summary'")
	static WebElement link_UserAdminSummary;

	@FindBy(how = How.XPATH, using = "//a[text()='Change Client'")
	static WebElement link_ChangeClient;

	@FindBy(how = How.XPATH, using = "//a[text()=''")
	static WebElement link_getlink;

	@FindBy(how = How.ID, using = "userLink")
	static WebElement link_Logout;

	public void waitforHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) waitforhomepage));
	}

	public WebElement getNewUserlink() {
		return link_NewUser;
	}

	public WebElement getChangePawordlink() {
		return link_ChangePasword;
	}

	public WebElement getAdministerUserlink() {
		return link_AdministerUser;
	}

	public WebElement getUserGroupMembershiplink() {
		return link_UserGroupMembership;
	}

	public WebElement getImportUserslink() {
		return link_ImportUsers;
	}

	public WebElement getExportUserslink() {
		return link_ExportUsers;
	}

	public WebElement getViewPasswordRuleslink() {
		return link_ViewPasswordRules;
	}

	public WebElement getEditPasswordRuleslink() {
		return link_EditPasswordRules;
	}

	public WebElement getClientSettingslink() {
		return link_ClientSettings;
	}

	public WebElement getChangePasswordlink() {
		return link_ChangePassword;
	}

	public WebElement getModifySecurityQuestionslink() {
		return link_ModifySecurityQuestions;
	}

	public WebElement getSetDefaultLocalelink() {
		return link_SetDefaultLocale;
	}

	public WebElement getReturntoApplicationlink() {
		return link_ReturntoApplication;
	}

	public WebElement getSystemAdministrationActivitylink() {
		return link_SystemAdministrationActivity;
	}

	public WebElement getUserAccessActivitylink() {
		return link_UserAccessActivity;
	}

	public WebElement getUserSummarylink() {
		return link_UserSummary;
	}

	public WebElement getUserAdminSummarylink() {
		return link_UserAdminSummary;
	}

	public WebElement getChangeClientlink() {
		return link_ChangeClient;
	}

	public WebElement getlink() {
		return link_getlink;
	}

	public WebElement getLogoutButton() {
		return link_Logout;
	}

}
