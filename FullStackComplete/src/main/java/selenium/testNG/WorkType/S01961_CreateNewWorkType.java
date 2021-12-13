package selenium.testNG.WorkType;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.testNG.Base.BaseClass;
import selenium.utility.Util;

public class S01961_CreateNewWorkType extends BaseClass {

	/*
	 * static String workTypeName="Salesforce Project"; 
	 * static String description="Specimen"; 
	 * static String operatingHours="UK Shift"; 
	 * static String duration="7";
	 */
	String actualText;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="TestData";
		sheetName="CreateNewWorkType";
		
	}
	
	@Test(dataProvider = "data", groups = {"smoke"})
	public void CreateNewWorkType(String workTypeName,String description,String operatingHours,String duration) {
		try {
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
			driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(duration);
			
			//12 Click on Save
			//wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")), duration+"0"));
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")));
			
			//13 Verify the Created message 
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]"), "Work Type"));
			actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Work Type')]")).getText();
			Assert.assertEquals(actualText,"Work Type \""+workTypeName+"\" was created.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}	
}
