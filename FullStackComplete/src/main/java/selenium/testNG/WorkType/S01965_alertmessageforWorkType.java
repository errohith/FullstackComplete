package selenium.testNG.WorkType;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.testNG.Base.BaseClass;

public class S01965_alertmessageforWorkType extends BaseClass{
	
	//static String workTypeName="Bootcamp";
	String errMsgNotification;
	String alertMsg;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="TestData";
		sheetName="alertmessageforWorkType";
		
	}

	@Test(dataProvider = "data", enabled = true,groups = {"Functional"})
	public void alertmessageforWorkType(String workTypeName) {
		
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
			
			//8) Enter Work Type Name as 'Bootcamp'
			driver.findElement(By.xpath("//span[text()='Work Type Name']/parent::label/following-sibling::input")).sendKeys(workTypeName);
			
			//9) Click on Save
			driver.findElement(By.xpath("//div[contains(@class,'inlineFooter')]//button[@title='Save']")).click();
			
			//10)Verify the error message.
			
			errMsgNotification=driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
			Assert.assertEquals(errMsgNotification,"These required fields must be completed: Estimated Duration");
			
			alertMsg=driver.findElement(By.xpath("//span[text()='Estimated Duration']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul/li")).getText();
			Assert.assertEquals(alertMsg,"Complete this field.");
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
