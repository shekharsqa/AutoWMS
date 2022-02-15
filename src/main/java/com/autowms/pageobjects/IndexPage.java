package com.autowms.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autowms.actiondriver.Action;
import com.autowms.base.BaseClass;
import com.autowms.utility.ExtentManager;
import com.aventstack.extentreports.Status;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		ExtentManager.test.log(Status.PASS, "SignIn button clicked.");
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		boolean flag = action.isDisplayed(getDriver(), myStoreLogo);
		if (flag) {
			ExtentManager.test.log(Status.PASS, "Logo Verified.");
		}else {
			ExtentManager.test.log(Status.FAIL, "Logo not Verified.");
		}
		return flag;
	}
	
	public boolean validateTitle(String actualTitle) {
		String myStoreTitel=getDriver().getTitle();
		boolean flag;
		if (actualTitle.equals(myStoreTitel)) {
			ExtentManager.test.log(Status.PASS, "Title Verified : " +myStoreTitel);
			flag = true;
		}else {
			ExtentManager.test.log(Status.FAIL, "Title NOT Verified : " +myStoreTitel);
			flag = false;
		}
		//Assert.assertEquals(actualTitle, "My Store");
		return flag;
	}
	
	/*
	 * public SearchResultPage searchProduct(String productName) throws Throwable {
	 * action.type(searchProductBox, productName);
	 * action.scrollByVisibilityOfElement(getDriver(), searchButton);
	 * action.click(getDriver(), searchButton); Thread.sleep(3000); return new
	 * SearchResultPage(); }
	 */
	
	

}
