package selenium.S019;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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

public class S01964_DeleteWorkType {

	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static int lastColNum;
	static String Message;
	static String workTypeName;
	
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
			
			//7) Click on the Arrow button at the end of the first result
			Thread.sleep(500);
			lastColNum=driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
			workTypeName=driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
			driver.findElement(By.xpath("//table/tbody/tr[1]/td["+lastColNum+"]//a")).click();
			
			//8) Click on Delete
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
			driver.findElement(By.xpath("//h2[text()='Delete Work Type']/parent::div/following-sibling::div[contains(@class,'modal-footer')]//button[@title='Delete']")).click();
			
			//12) Verify the message
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
			Message=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			Assert.assertEquals(Message,"Work Type \""+workTypeName+"\" was deleted. Undo");
			
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
