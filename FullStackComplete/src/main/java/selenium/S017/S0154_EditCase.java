package selenium.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;

public class S0154_EditCase extends BaseClass{
	
 
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="S0154_EditCase";
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
	
	@Test(dependsOnMethods = {"selenium.S017.S0153_CreateNewCase.newCaseCreation"},dataProvider = "data")
	public void editCase(String caseID,String CaseOrigin,
						 String Status,
						 String Priority) throws InterruptedException {
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
//		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
	
		driver.findElement(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[7]//a")).click();
		
		driver.findElement(By.xpath("(//a[@title='Edit'])")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']")).click();
		
		driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[@title='"+Status+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Priority']/parent::span//following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='"+Priority+"']")).click();	
		
		driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[4]//span[@class='slds-truncate']"), Status));
		String actualStatus = driver.findElement(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[4]//span[@class='slds-truncate']")).getText();
		Assert.assertEquals(actualStatus,Status);
	}
}
