package selenium.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;

public class S0156_CreateCasewithoutmandatoryfields extends BaseClass{
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="S0156_CreateCaseNegative";
		sheetName="Sheet1";
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void gotoCaseTab() {
		//Click on the toggle menu button from the left corner
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//Click view All and click Sales from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
			driver.findElement(By.xpath("//div[@class='slds-truncate']//p[contains(text(),'Manage your sales')]")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='More']")));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dataProvider="data")
	public void newCaseCreationNegative(String Salutation,
										String FirstName,
										String LastName,
										String Status,
										String Subject,
										String Description) throws InterruptedException {
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
//		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']/parent::a")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@title='New']/parent::a")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Contacts']"))));
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		
		driver.findElement(By.xpath("//span[@title='New Contact']")).click();
		
		driver.findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
		
		
		driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[contains(@title,'"+Status+"')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys(Subject);
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys(Description);
		
		driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		
		String errorText = driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
		Assert.assertEquals(errorText,"These required fields must be completed: Case Origin, Status");
		
		errorText=driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div[contains(@class,'help')]")).getText();
		Assert.assertEquals(errorText,"Complete this field.");
		
		errorText=driver.findElement(By.xpath("//span[text()='Case Origin']/ancestor::div[1]/following-sibling::ul/li[contains(@class,'help')]")).getText();
		Assert.assertEquals(errorText,"Complete this field.");
		
	}
}
