package selenium.POM.BaseClass;

import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
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

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public String fileName;
	public String sheetName;
	public String Browser;
	public static List<String> caseID_Chrome;
	public static List<String> caseID_Firefox;
	
	@Parameters({"Browser"})
	@BeforeClass(alwaysRun = true)
	public void browserIntialization(String Browser) {
		this.Browser=Browser;
		caseID_Chrome = new LinkedList<>();
		caseID_Firefox = new LinkedList<>();
	}
	
	@Parameters({"URL"})
	@BeforeMethod(alwaysRun = true)
	public void init(String URL) {
		
		System.out.println("Invoke Before Method");
		
			// Webdriver Setup
			if(Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// ChromeOption Setup
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
				// Create Chrome Driver Object
				driver = new ChromeDriver(option);
			}
			else if(Browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				//firefox option setup
				FirefoxOptions option = new FirefoxOptions();
				option.addPreference("dom.webnotifications.enabled", false);
				option.addPreference("dom.push.enabled", false);
				// Create Firefox Driver Object
				driver = new FirefoxDriver(option);
			}
			

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;
			

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();
			
			// 1) Launch the app
			driver.navigate().to(URL);
			
			//2) Click Login
			driver.findElement(By.xpath("//div[@aria-label='Login']")).click();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			System.out.println("Invoke After Method");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='User']/parent::span")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//img[@title='User']/parent::span")));
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		//driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
	
	@DataProvider(name = "data")
	public String[][] testData() {
		return new Util().readExcel(fileName,sheetName,Browser);		
	}
	
	

}
