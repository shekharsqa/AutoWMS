package com.autowms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autowms.actiondriver.Action;
import com.autowms.base.BaseClass;


public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	/* WebElements of the Home Page */
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	/* Initlize the elements of the Page */
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	/* User defined function for Home Page*/
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
}
