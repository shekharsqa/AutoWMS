/**
 * 
 *//*
	 * package com.autowms.base;
	 * 
	 * import java.awt.Desktop; import java.io.File; import java.io.FileInputStream;
	 * import java.io.IOException; import java.net.MalformedURLException; import
	 * java.net.URL; import java.text.SimpleDateFormat; import java.util.Base64;
	 * import java.util.Date; import java.util.concurrent.TimeUnit;
	 * 
	 * import org.apache.commons.io.FileUtils; import org.apache.poi.util.IOUtils;
	 * import org.openqa.selenium.OutputType; import
	 * org.openqa.selenium.TakesScreenshot; import org.openqa.selenium.WebDriver;
	 * import org.openqa.selenium.chrome.ChromeDriver; import
	 * org.openqa.selenium.remote.DesiredCapabilities; import
	 * org.openqa.selenium.remote.RemoteWebDriver;
	 * 
	 * import org.testng.ITestResult; import org.testng.annotations.AfterMethod;
	 * import org.testng.annotations.AfterSuite; import
	 * org.testng.annotations.BeforeMethod; import
	 * org.testng.annotations.BeforeSuite;
	 * 
	 * import com.autowms.utility.ExtentManager; import
	 * com.aventstack.extentreports.ExtentReports; import
	 * com.aventstack.extentreports.ExtentTest; import
	 * com.aventstack.extentreports.Status; import
	 * com.aventstack.extentreports.markuputils.ExtentColor; import
	 * com.aventstack.extentreports.markuputils.MarkupHelper; //import
	 * com.aventstack.extentreports.reporter.ExtentHtmlReporter; import
	 * com.aventstack.extentreports.reporter.ExtentSparkReporter; import
	 * com.aventstack.extentreports.reporter.configuration.Theme; import
	 * com.google.common.util.concurrent.Uninterruptibles;
	 * 
	 * public class BaseClass_Bkp {
	 * 
	 * public static WebDriver driver;
	 * 
	 * 
	 * @BeforeSuite public void beforeSuite() throws IOException {
	 * ExtentManager.setExtent(); }
	 * 
	 * @AfterSuite public void afterSuite() throws IOException {
	 * ExtentManager.endReport(); }
	 * 
	 * 
	 * @BeforeMethod
	 * 
	 * 
	 * 
	 * //Below setup() method is for running at docker. public void setup() throws
	 * MalformedURLException { //System.setProperty("webdriver.chrome.driver",
	 * "E:\\SV_QA\\AutoSH\\AutoSJSH\\SJSHDrivers\\Chrome\\98\\chromedriver.exe");
	 * //driver = new ChromeDriver();
	 * 
	 * //String runmode = "Remote"; DesiredCapabilities cap = new
	 * DesiredCapabilities(); //cap.setBrowserName("CHROME");
	 * cap.setCapability("browserName", "chrome"); //WebDriver driver = new
	 * RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap); WebDriver
	 * driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
	 * //driver.manage().window().maximize(); driver.get(
	 * "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials"
	 * ); System.out.println("Title is:" +driver.getTitle());
	 * Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS); //driver.quit();
	 * }
	 * 
	 * 
	 * 
	 * //very basic setup method public void setup() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "E:\\SV_QA\\AutoSH\\AutoSJSH\\SJSHDrivers\\Chrome\\chromedriver.exe"); driver
	 * = new ChromeDriver(); driver.manage().window().maximize(); driver.get(
	 * "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials"
	 * ); }
	 * 
	 * 
	 * @AfterMethod public void tearDown(ITestResult result) throws IOException {
	 * //driver.close(); driver.quit(); }
	 ******** 
	 * 
	 * UserDefined Methods **********
	 * 
	 * ScreenShot Way-1) Screenshot saved as PNG/JPG and then attach public static
	 * String screenShot(WebDriver driver, String filename) { String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot
	 * takesScreenshot = (TakesScreenshot) driver; File source =
	 * takesScreenshot.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir") +
	 * "\\ScreenShots\\" + filename + "_" + dateName + ".png";
	 * 
	 * try { FileUtils.copyFile(source, new File(destination)); } catch (Exception
	 * e) { e.getMessage(); } return destination; }
	 * 
	 * ScreenShot Way-2) Capture screenshot as PNG/JPG  convert to Base64 and then
	 * attach with report. public static String getScreenShotAsbase64(WebDriver
	 * driver, String filename) throws IOException { String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot
	 * takesScreenshot = (TakesScreenshot) driver; File source =
	 * takesScreenshot.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir") +
	 * "\\ScreenShots\\" + filename + "_" + dateName + ".png";
	 * 
	 * FileUtils.copyFile(source, new File(destination)); byte[] imageBytes =
	 * IOUtils.toByteArray(new FileInputStream(destination)); return
	 * Base64.getEncoder().encodeToString(imageBytes); }
	 * 
	 * ScreenShot Way-3) Capture screenshot a Base64 and attach with report public
	 * static String getBase64() { return ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BASE64); }
	 * 
	 * 
	 * 
	 * 
	 * public String getCurrentTime() { String currentDate = new
	 * SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date()); return currentDate;
	 * }
	 * 
	 * 
	 * }
	 */