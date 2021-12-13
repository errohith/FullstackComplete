package selenium.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;
import selenium.utility.Util;

public class S0153_CreateNewCase extends BaseClass{
 
	public static String caseID;
	public int rowNum=0;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="S0153_CreateNewCase";
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
	
	@Test(dataProvider = "data")
	public void newCaseCreation(String Salutation,
								String FirstName, 
								String LastName, 
								String CaseOrigin, 
								String Status, 
								String Subject, 
								String Description) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='New Case']")));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='New Case']")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Contacts']"))));
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		
		driver.findElement(By.xpath("//span[@title='New Contact']")).click();
		
		driver.findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
		
		driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']")).click();
		
		driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[@title='"+Status+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys(Subject);
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys(Description);
		
		driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//span[contains(@class,'toastMessage')]")), "Case"));
		String actualToastMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		caseID = driver.findElement(By.xpath("//p[@title='Case Number']/following-sibling::p//lightning-formatted-text")).getText();
		
		Assert.assertEquals(actualToastMsg,"Case \""+caseID+"\" was created.");	
		rowNum=rowNum+1;
		//new Util().writeExcel("S0154_EditCase", sheetName, caseID,"caseID",Browser,rowNum);
		//new Util().writeExcel("S0155_DeleteCase", sheetName, caseID,"caseID",Browser,rowNum);
	}
}
