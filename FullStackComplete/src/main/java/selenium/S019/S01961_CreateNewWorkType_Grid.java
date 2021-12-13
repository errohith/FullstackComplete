package selenium.S019;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01961_CreateNewWorkType_Grid {

	static ChromeOptions option;
	//static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String workTypeName="Salesforce Project";
	static String description="Specimen";
	static String operatingHours="UK Shift";
	static String duration="7";
	static String actualText;
	static WebDriver driver;
	
	public static void main(String[] args) {
	
			
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

			// Webdriver Setup
//			WebDriverManager.chromedriver().setup();

			// ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// Create Chrome Driver Object
//			driver = new ChromeDriver(option);
			
//			option.setCapability("platformName", "Windows 10");
//			option.setCapability("browserVersion", "latest");
//			Map<String, Object> sauceOptions = new HashMap<>();
//			option.setCapability("sauce:options", sauceOptions);
			capabilities.setCapability(ChromeOptions.CAPABILITY, option);
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setCapability("disable-restore-session-state", true);
			driver = new RemoteWebDriver(new URL("http://192.168.0.186:5555/wd/hub"), capabilities);

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;
			

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();

			
			// 1) Launch the app
			driver.navigate().to("https://login.salesforce.com");
			//2) Click Login
			//driver.findElement(By.xpath("//div[@aria-label='Login']")).click();
			
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
			
			//8) Enter Work Type Name as 'Salesforce Project'
			driver.findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input")).sendKeys(workTypeName);
			
			//9) Enter Description as 'Specimen'
			driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);
			
			//10) Create new operating hours by Entering a name as 'UK Shift'
			driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
			driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
			driver.findElement(By.xpath("//span[text()='Name']/parent::label/following-sibling::input")).sendKeys(operatingHours);
			driver.findElement(By.xpath("//span[text()='Time Zone']/parent::span/following-sibling::div//a")).click();
			driver.findElement(By.xpath("//div[@class='select-options']/ul/li/a[contains(@title,'London')]")).click();
			driver.findElement(By.xpath("//h2[text()='New Operating Hours']/parent::div/following-sibling::div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
			
			//11) Enter Estimated Duration as '7'
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(duration);
			
			//12 Click on Save
			driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();
			
			//13 Verify the Created message 
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"), "Work Type"));
			actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]")).getText();
			Assert.assertEquals(actualText,"Work Type \""+workTypeName+"\" was created.");
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
