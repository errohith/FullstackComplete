package selenium.POM.ThreadLocal.CucumberPages_Implementation1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;

public class Hooks extends CucumberBaseClass {
	
	@Before
	public void preCondition() throws IOException {
		fis = new FileInputStream(new File(".\\src\\main\\resources\\config.properties"));
		prop = new Properties();
		prop.load(fis);
		
		// Webdriver Setup
		System.out.println(prop.getProperty("URL"));
					if(prop.getProperty("Browsers").equalsIgnoreCase("Chrome")) {
						WebDriverManager.chromedriver().setup();
						// ChromeOption Setup
						ChromeOptions option = new ChromeOptions();
						option.addArguments("--disable-notifications");
						// Create Chrome Driver Object
						browserInstance = new ChromeDriver(option);
					}
					else if(prop.getProperty("Browsers").equalsIgnoreCase("Firefox")) {
						WebDriverManager.firefoxdriver().setup();
						//firefox option setup
						FirefoxOptions option = new FirefoxOptions();
						option.addPreference("dom.webnotifications.enabled", false);
						option.addPreference("dom.push.enabled", false);
						// Create Firefox Driver Object
						browserInstance = new FirefoxDriver(option);
					}
					setDriver(browserInstance);	

					// Create JavascriptExecutor instance and assign driver object
					
					js = (JavascriptExecutor) browserInstance;
					setJSExecutor(js);
					

					// Wait Setup
					getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					wait = new WebDriverWait(browserInstance, Duration.ofSeconds(10));
					setWait(wait);

					// Maximize window
					getDriver().manage().window().maximize();
					
					// 1) Launch the app
					getDriver().navigate().to(prop.getProperty("URL"));
					
					//2) Click Login
					getDriver().findElement(By.xpath("//div[@aria-label='Login']")).click();
		

	}
	@After
	public void postCondition() {
		try {
			System.out.println("Invoke After Method");
			Thread.sleep(1000);
			getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='User']/parent::span")));
			getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//img[@title='User']/parent::span")));
			getDriver().findElement(By.xpath("//a[text()='Log Out']")).click();
		//getDriver().close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			getDriver().quit();
			closeThread();
		}
		
	}

}
