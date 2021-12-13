package selenium.S014;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0142_VerifyDashboardSubscribe {

	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String dashboardName = "Velmurugan";
	static String actualText;
	static String subscribeText;
	static WebElement tableElement;
	
	public static void main(String[] args) {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

			// Webdriver Setup
			WebDriverManager.chromedriver().setup();

			// ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			// Create Chrome Driver Object
			driver = new ChromeDriver(option);

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();

			// 1. Login to https://login.salesforce.com
			driver.navigate().to("https://login.salesforce.com");
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();

			// 2. Click on the toggle menu button from the left corner
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

			// 3. Click View All and click Dashboards from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			WebElement dashboardElement = driver
					.findElement(By.xpath("//p[@class='slds-truncate' and text()='Dashboards']"));
			js.executeScript("arguments[0].scrollIntoView();", dashboardElement);
			dashboardElement.click();

			// 4. Click on the Dashboards tab
			WebElement dashboardtabElement = driver.findElement(By.xpath("//a[@title='Dashboards']/span"));
			js.executeScript("arguments[0].click();", dashboardtabElement);

			// 5. Search the Dashboard 'Salesforce Automation by Your Name'
			driver.findElement(By.xpath("//span[@title='Created On']")).click();
			driver.findElement(By.xpath("//input[contains(@class,'search-text-field') and contains(@placeholder,'Search recent')]")).sendKeys(dashboardName, Keys.ENTER);
			tableElement = driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/th//a[contains(@title,'"+dashboardName+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(tableElement));
			subscribeText=driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td[5]//span[@class='slds-assistive-text']")).getText();
			if(!subscribeText.equalsIgnoreCase("True")) {
				//6. Click on the Dropdown icon and Select Subscribe
				List<WebElement> tdElements = driver.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td"));
				driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td["+(tdElements.size())+"]//button")).click();
				driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Subscribe']")).click();
				
				//7. Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window. 
				driver.findElement(By.xpath("//input[@id='daily']/following-sibling::span")).click();
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
				
				//8.Verify Whether the dashboard is subscribed.
				Assert.assertEquals(actualText,"You started a dashboard subscription.");
				Assert.assertEquals(driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td[5]//span[@class='slds-assistive-text']")).getText(), "True");
				
			}
			else {
				System.out.println("Selected Dashboard already Subscribed...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finally {
			//Close the driver
			driver.quit();		
		}


	}

}
