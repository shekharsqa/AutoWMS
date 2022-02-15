package com.autowms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autowms.base.BaseClass;
import com.autowms.dataprovider.DataProviders;
import com.autowms.pageobjects.IndexPage;
import com.autowms.utility.ExtentManager;
import com.autowms.utility.Log;
import com.aventstack.extentreports.Status;



public class IndexPageTest extends BaseClass{
	
	//Step-1
	private IndexPage indexPage;
	
	//Step-2
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke", dataProvider = "validations", dataProviderClass = DataProviders.class)
	public void indexPageTest(String actualTitle) throws Throwable {
		
	//VerifyLogo
		Log.startTestCase("Scenario:1 Verify Logo");
		ExtentManager.test.log(Status.INFO, "Step 1.0: Verifying Logo");
		indexPage= new IndexPage();
			boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	
	//VerifyTitle
		Log.startTestCase("Scenario:2 Verify Title");
		ExtentManager.test.log(Status.INFO, "Step 2.0: Verifying Title");
			boolean result1 = indexPage.validateTitle(actualTitle);
		Assert.assertTrue(result1);
		Log.endTestCase("verifyTitle");
		
		
		
	}
	
}
