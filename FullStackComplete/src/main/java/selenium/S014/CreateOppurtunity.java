package selenium.S014;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOppurtunity {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String opportunityName="Salesforce Automation by Vels";
	static String actualText;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Webdriver Setup
		WebDriverManager.chromedriver().setup();
		
		//ChomeOptions Setup
		option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		//Create Chrome Driver Object
		driver = new ChromeDriver(option);
		
		//Create JavascriptExecutor instance and assign driver object
		js = (JavascriptExecutor)driver;
		
		//Wait Setup
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Maximize Window
		driver.manage().window().maximize();
		
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		
		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("//div[@class='slds-truncate']//p[contains(text(),'Manage your sales')]")).click();
		
		//4. Click on Opportunity tab 
		WebElement opportunityButton = driver.findElement(By.xpath("//a[@title='Opportunities']/span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", opportunityButton);
		
		//5. Click on New button
		driver.findElement(By.xpath("//a[@title='New']/div")).click();
		
		//6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::div[1]/input")).sendKeys(opportunityName);
		
		//7. Choose close date as Today
		SimpleDateFormat dft=new SimpleDateFormat("M/dd/yyyy");
		Date dt = new Date();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(dft.format(dt));
		
		//8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input[@class='slds-input slds-combobox__input']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		
		//9. click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();		
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']//div")), opportunityName));
		actualText=driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']//div")).getText();
		
		
		//Assertion
		System.out.println(actualText);
		Assert.assertEquals(actualText.replace("\"", ""), opportunityName);
		
		
		//Close the driver
		driver.quit();
		
		
		
		
		
		
		
		

	}

}
