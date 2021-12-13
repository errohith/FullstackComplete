package selenium.S014;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.testNG.Base.BaseClass;

public class S0138_CreateNewDashboard {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String dashboardName="Salesforce Automation by Velmurugan";
	static String actualText;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
			
			//Webdriver Setup
			WebDriverManager.chromedriver().setup();
			
			//ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			
			//Create Chrome Driver Object
			driver=new ChromeDriver(option);

			//Create JavascriptExecutor instance and assign driver object		
			js=(JavascriptExecutor)driver;
			
			//Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			//Maximize window
			driver.manage().window().maximize();
			
			//1. Login to https://login.salesforce.com
			driver.get("https://login.salesforce.com");
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			//2. Click on the toggle menu button from the left corner
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//3. Click View All and click Dashboards from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			WebElement dashboardElement=driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Dashboards']"));
			js.executeScript("arguments[0].scrollIntoView();", dashboardElement);
			dashboardElement.click();
			
			//4. Click on the New Dashboard option
			CloseTab();
			driver.findElement(By.xpath("//a[@title='New Dashboard']/div")).click();
			
			//5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(dashboardName);
			driver.findElement(By.id("submitBtn")).click();
			driver.switchTo().defaultContent();
			
			//6.Click on Save and Verify Dashboard name.
			Thread.sleep(5000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driver.findElement(By.xpath("//div[@class='actionRibbon']//button")).click();
			driver.findElement(By.xpath("//div[@class='actionRibbon']/following::button")).click();
			driver.switchTo().defaultContent();
			
			//Expected Result:The New Dashboard is created Successfully
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			actualText=driver.findElement(By.xpath("//h1/span[text()='Dashboard']/following-sibling::span")).getText();
			Assert.assertEquals(actualText, dashboardName);
			driver.switchTo().defaultContent();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			//Close the driver
			//driver.quit();
		}
	}
	
	public static void CloseTab() {
		List<WebElement> listItem = driver.findElements(By.xpath("//ul[contains(@class,'tabBarItems slds-grid') and @role='presentation']/li[contains(@class,'oneConsoleTabItem')]//button[contains(@title,'Close')]"));
		for (WebElement item : listItem) {
			item.click();	
		}
	}

}
