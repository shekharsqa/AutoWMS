package com.autowms.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.autowms.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	//public static ExtentHtmlReporter htmlReporter; 		//SH- this was depriciated after extentReport 5 version
	public static ExtentSparkReporter spark;				//SH- this was introduced after extentReport 5 version
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String ReportPath = System.getProperty("user.dir")+"/test-output/ExtentReport/"+"/MyReport"+System.currentTimeMillis()+".html";

	/* SH- Moved BeforeSuite (setExtent()) and AfterSuite (endReport()--extent.flush()) methods to this class.
	 * SH- We will call this class in BaseClass -- for this we have to make method static, so that other class can call by class name. and do not have to extend BaseClass 	 */
	public static void setExtent() throws IOException {
		spark = new ExtentSparkReporter(ReportPath);
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");*/
		
		/* Below properties have been moved to extent-config.xml file -- For that we will remove these lines and add config load line.*/
		/* spark.config().setDocumentTitle("AutoWMS Doc Title");	 
		spark.config().setReportName("AutoWMS Test Automation Report");
		spark.config().setTheme(Theme.STANDARD); */ 										/** SH- (Theme.DARK) or (Theme.STANDARD) **/

		/* Below code is for loadXMLConfig file If we are using XML config file*/
		/*final File CONF = new File("extent-config.xml");									//since our file is at root location so no path is needed.
		spark.loadXMLConfig(CONF);	*/										

		/* Below code is for loadJSONConfig file If we are using JSON config file*/
		final File CONF = new File("extent-config.json");								//since our file is at root location so no path is needed.
		spark.loadJSONConfig(CONF);

		
		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("HostName", "AutoWMS localhost");
		extent.setSystemInfo("ProjectName", "AutoWMS");
		extent.setSystemInfo("Tester", "SH");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() throws IOException {
		extent.flush();
		System.out.println(ReportPath);
		File htmlFile = new File(ReportPath);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}

}

















