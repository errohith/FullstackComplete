package selenium.POM.ThreadLocal.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.utility.Util;

public class CucumberBaseClass extends DriverFactory {
	
	public static WebDriver browserInstance;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
//	public static List<String> caseID_Chrome;
//	public static List<String> caseID_Firefox;
	public static Properties prop;
	public static FileInputStream fis;
	
//	@BeforeTest(alwaysRun = true)
//	public void listInitialization() {
//		caseID_Chrome = new LinkedList<>();
//		caseID_Firefox = new LinkedList<>();
//	}
//	
//	@Parameters({"Browser"})
//	@BeforeClass(alwaysRun = true)
//	public void browserAndPropFileIntialization(String Browser) throws IOException {
//		this.Browser=Browser;
//		fis = new FileInputStream(new File(".\\src\\main\\resources\\config.properties"));
//		prop = new Properties();
//		prop.load(fis);
//	}
//	
//	//@Parameters({"URL"})
//	@BeforeMethod(alwaysRun = true)
//	public void init() {
//		
//		System.out.println("Invoke Before Method");
//		
//
//			// Webdriver Setup
//			if(Browser.equalsIgnoreCase("Chrome")) {
//				WebDriverManager.chromedriver().setup();
//				// ChromeOption Setup
//				ChromeOptions option = new ChromeOptions();
//				option.addArguments("--disable-notifications");
//				// Create Chrome Driver Object
//				browserInstance = new ChromeDriver(option);
//			}
//			else if(Browser.equalsIgnoreCase("Firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				//firefox option setup
//				FirefoxOptions option = new FirefoxOptions();
//				option.addPreference("dom.webnotifications.enabled", false);
//				option.addPreference("dom.push.enabled", false);
//				// Create Firefox Driver Object
//				browserInstance = new FirefoxDriver(option);
//			}
//			setDriver(browserInstance);	
//
//			// Create JavascriptExecutor instance and assign driver object
//			
//			js = (JavascriptExecutor) browserInstance;
//			setJSExecutor(js);
//			
//
//			// Wait Setup
//			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			wait = new WebDriverWait(browserInstance, Duration.ofSeconds(10));
//			setWait(wait);
//
//			// Maximize window
//			getDriver().manage().window().maximize();
//			
//			// 1) Launch the app
//			getDriver().navigate().to(prop.getProperty("URL"));
//			
//			//2) Click Login
//			getDriver().findElement(By.xpath("//div[@aria-label='Login']")).click();
//		
//	}
//	
//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//		try {
//			System.out.println("Invoke After Method");
//			Thread.sleep(1000);
//			getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='User']/parent::span")));
//			getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//img[@title='User']/parent::span")));
//			getDriver().findElement(By.xpath("//a[text()='Log Out']")).click();
//		//getDriver().close();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			getDriver().quit();
//			closeThread();
//		}
//	}
//	@DataProvider(name = "data")
//	public String[][] testData() {
//		return new Util().readExcel(fileName,sheetName,Browser);		
//	}
}
