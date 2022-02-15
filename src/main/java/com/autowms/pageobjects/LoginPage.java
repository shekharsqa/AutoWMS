
package com.autowms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autowms.actiondriver.Action;
import com.autowms.base.BaseClass;
import com.autowms.utility.ExtentManager;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyLogin(String uname, String pswd,HomePage homePage) throws Throwable {
		//define flag
		boolean flag;
		
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		
		//get the URL of home page
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		if (actualURL.equals(expectedURL)) {
			flag = true;
			ExtentManager.test.log(Status.PASS, "Login Verified.");		
		}else {
			flag = false;
			ExtentManager.test.log(Status.FAIL, "Login NOT Verified.");
		}
		//homePage=new HomePage();
		//return homePage;
		return flag;
	}
	
	
	/*
	 * public HomePage verifyLogin(String uname, String pswd,HomePage homePage)
	 * throws Throwable { action.scrollByVisibilityOfElement(getDriver(), userName);
	 * action.type(userName, uname); action.type(password, pswd);
	 * action.JSClick(getDriver(), signInBtn); Thread.sleep(2000); homePage=new
	 * HomePage(); return homePage; }
	 */
	
	/*
	 * public AddressPage login(String uname, String pswd,AddressPage addressPage)
	 * throws Throwable { action.scrollByVisibilityOfElement(getDriver(), userName);
	 * action.type(userName, uname); action.type(password, pswd);
	 * action.click(getDriver(), signInBtn); Thread.sleep(2000); addressPage=new
	 * AddressPage(); return addressPage; }
	 * 
	 * public AccountCreationPage createNewAccount(String newEmail) throws Throwable
	 * { action.type(emailForNewAccount, newEmail); action.click(getDriver(),
	 * createNewAccountBtn); return new AccountCreationPage(); }
	 */
	
}






