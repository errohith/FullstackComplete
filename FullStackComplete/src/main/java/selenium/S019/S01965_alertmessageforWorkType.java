package selenium.S019;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01965_alertmessageforWorkType {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String workTypeName="Bootcamp";
	static String errMsgNotification;
	static String alertMsg;

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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();

			// 1) Launch the app
			driver.navigate().to("https://www.salesforce.com/");
			
			//2) Click Login
			driver.findElement(By.xpath("//div[@aria-label='Login']")).click();
			
			//3) Login with the credentials
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			//4) Click on the App Laucher Icon left to Setup
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

			//5) Click on View All
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			//6) Click on Work Types
			WebElement worktypeElement = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Types']"));
			js.executeScript("arguments[0].scrollIntoView();", worktypeElement);
			worktypeElement.click();
			
			//7) Click on New
			driver.findElement(By.xpath("//a[@title='New']")).click();
			
			//8) Enter Work Type Name as 'Bootcamp'
			driver.findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input")).sendKeys(workTypeName);
			
			//9) Click on Save
			driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();
			
			//10)Verify the error message.
			
			errMsgNotification=driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
			Assert.assertEquals(errMsgNotification,"These required fields must be completed: Estimated Duration");
			
			alertMsg=driver.findElement(By.xpath("//span[text()='Estimated Duration']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul/li")).getText();
			Assert.assertEquals(alertMsg,"Complete this field.");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//Close the driver
			driver.quit();		
		}
		
		
		

	}

}
