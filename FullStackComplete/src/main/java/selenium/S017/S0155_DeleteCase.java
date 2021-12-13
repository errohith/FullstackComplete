package selenium.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;

public class S0155_DeleteCase extends BaseClass{
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="S0155_DeleteCase";
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
 
	@Test(dependsOnMethods = {"selenium.S017.S0153_CreateNewCase.newCaseCreation"}, dataProvider="data")
	public void deleteCase(String caseID) throws InterruptedException {
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
//		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
	
		driver.findElement(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[7]//a")).click();
		
		driver.findElement(By.xpath("(//a[@title='Delete'])")).click();
		
		driver.findElement(By.xpath("//h2[text()='Delete Case']/parent::div//following-sibling::div[contains(@class,'modal-footer')]//button[@title='Delete']")).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), caseID));
		String actualMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		Assert.assertEquals(actualMsg, "Case \""+caseID+"\" was deleted. Undo");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,\"Search this list\")]")).sendKeys(caseID,Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p/*[contains(@class,'rich-text-editor')]/span"), "No items to display."));
		Assert.assertEquals(driver.findElement(By.xpath("//p/*[contains(@class,'rich-text-editor')]/span")).getText(),"No items to display.");
	}
}

