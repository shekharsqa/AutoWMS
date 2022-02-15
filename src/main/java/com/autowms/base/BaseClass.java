/**
 * 
 */
package com.autowms.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autowms.utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
public class BaseClass {
	
	public static Properties prop;
	
	// Declare ThreadLocal Driver
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//public static WebDriver driver;
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}	
	
	
	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			System.out.print(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			  //WebDriverManager.chromedriver().setup(); // Set Browser to ThreadLocalMap
			  WebDriverManager.chromedriver().driverVersion("99.0.4844.17").setup();
			  driver.set(new ChromeDriver());	 
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		//getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		/*
		 * getDriver().manage().timeouts().implicitlyWait
		 * (Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		 */
		//PageLoad TimeOuts
		/*
		 * getDriver().manage().timeouts().pageLoadTimeout
		 * (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		 */
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		ExtentManager.endReport();
		}	
	

	
}
