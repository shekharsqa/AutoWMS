package com.autowms.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autowms.base.BaseClass;
import com.autowms.utility.ExtentManager;

public class LoginPageTest extends BaseClass{
	/*SH- This class is extending BaseClass, so we can directly user "driver" as this is already defined in baseClass.*/
	
	/*TestCase-1: Verify the Image on Login Page -- Dummy Website: https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials*/	
	@Test(priority=1)
	public void loginPageTest() {
		//test = extent.createTest("TestCaseName : loginPageTest"); 		/** This will move to ListenerClass, so that we dont have to write again and again in every @Test **/
		
		WebElement imgElement = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		Assert.assertTrue(imgElement.isDisplayed());		
	}
	
	/*TestCase-2: */
	@Test (priority=2)
	public void loginTest() {
		//test = extent.createTest("TestCaseName : loginTest");			/** This will move to ListenerClass, so that we dont have to write again and again in every @Test **/
		
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");
		ExtentManager.test.info("Username entered.");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		ExtentManager.test.info("Password entered.");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		ExtentManager.test.info("Login button clicked.");
		
			String actualTitle = driver.getTitle();
			String expectedTitle = "OrangeHRM";
			Assert.assertEquals(actualTitle, expectedTitle);
			//ExtentManager.test.pass("Login Test Successful.");
	}
	
	/*TestCase-3: */
	@Test (priority=3)
		public void sampleCase() {
			//test = extent.createTest("TestCaseName : sampleTest");		/** This will move to ListenerClass, so that we dont have to write again and again in every @Test **/
			ExtentManager.test.createNode("Validation 1");							/** Node is like Steps **/
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 2");
			Assert.assertTrue(true);
			
			ExtentManager.test.createNode("Validation 3");
			Assert.assertTrue(true);
		}
	
}
