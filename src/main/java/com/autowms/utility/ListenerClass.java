package com.autowms.utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.autowms.base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentManager.test = ExtentManager.extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentManager.test.log(Status.PASS, "Pass Test case is: " + result.getName());

			/* Way-1) SH- Use Below Code for capture screenshot as PNG/JPG and then attach to report.*/
			/*
				 * String pathString=BaseClass.screenShot(BaseClass.driver, result.getName());
				 * ExtentManager.test.addScreenCaptureFromPath(pathString);
			*/

			/** Way-2) SH- Use this for capture screenshot as PNG and convert to Base64 and attach to report. **/
			
			/*
			  String pathString; 
			  try { 
				  pathString = BaseClass.getScreenShotAsbase64(BaseClass.driver, result.getName());
				  ExtentManager.test.addScreenCaptureFromBase64String(pathString); } 
			  catch
			  	(IOException e) 
			  { 
				  e.printStackTrace(); 
			  }
			 */
			
			/** Way-3) SH- Use this for capture screenshot as Base64 and attach to report. **/
			String pathString;
			try {
				pathString = BaseClass.getScreenShotAsbase64(BaseClass.driver, result.getName());
				ExtentManager.test.addScreenCaptureFromBase64String(BaseClass.getBase64());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			/* SH-Adding screenshot to report */
			String pathString = BaseClass.screenShot(BaseClass.driver, result.getName());
			ExtentManager.test.addScreenCaptureFromPath(pathString);

		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			ExtentManager.test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
			/* SH-Adding screenshot to report */
			String pathString = BaseClass.screenShot(BaseClass.driver, result.getName());
			ExtentManager.test.addScreenCaptureFromPath(pathString);
		}
	}

	/*
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult result) { //
	 * TODO Auto-generated method stub }
	 */

	/*
	 * public void onStart(ITestContext context) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * public void onFinish(ITestContext context) { // TODO Auto-generated method
	 * stub }
	 */

}
