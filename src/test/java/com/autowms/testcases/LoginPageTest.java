package com.autowms.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autowms.base.BaseClass;
import com.autowms.dataprovider.DataProviders;
import com.autowms.pageobjects.HomePage;
import com.autowms.pageobjects.IndexPage;
import com.autowms.pageobjects.LoginPage;
import com.autowms.utility.ExtentManager;
import com.autowms.utility.Log;
import com.aventstack.extentreports.Status;

public class LoginPageTest extends BaseClass {
	//SH- This class is extending BaseClass, so we can directly user "driver" as this is already defined in baseClass.
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test (groups = {"Smoke","Sanity"}, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginPageTest(String uname, String pswd) throws Throwable{
		
		Log.startTestCase("Scenario:2 Verify Login");
			ExtentManager.test.log(Status.INFO, "Step 2.0: Verifying Title");
				boolean result = loginPage.verifyLogin(uname, pswd, homePage);
			Assert.assertTrue(result);
		Log.endTestCase("verify Login");  
	    
	}
	
	/*
	 @Test (priority=3)
		public void sampleCase() {
			//test = extent.createTest("TestCaseName : sampleTest");		/ This will move to ListenerClass, so that we dont have to write again and again in every @Test
			ExtentManager.test.createNode("Validation 1");							// Node is like Steps 
			//AssertJUnit.assertTrue(true);
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 2");
			//Assert.assertTrue(true);
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 3");
			//Assert.assertTrue(true);
			Assert.assertTrue(true);
		}
	 */
	
	

}
