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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.testNG.Base.BaseClass;

public class S01962_EditWorkTypeNegative extends BaseClass{

	//static String timeFrameEnd="6";
	//static String timeFrameStart="9";
	
	int lastColNum;
	String genericNotification;
	String timeFrameStartErrMsg;
	String timeFrameEndErrMsg;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="TestData";
		sheetName="EditWorkTypeNegative";
		
	}
	
	@Test(dataProvider = "data", groups = {"Regression"})
	public void EditWorkTypeNegative(String timeFrameEnd, String timeFrameStart) {
	
			
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
			
			//7) Click on the Arrow button at the end of the first result
			//Thread.sleep(500);
			lastColNum=driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
			driver.findElement(By.xpath("//table/tbody/tr[4]/td["+lastColNum+"]//a")).click();
			
			//8) Click on Edit
			driver.findElement(By.xpath("//a[@title='Edit']")).click();
			
			//9) Enter Time Frame Start as '9'
			driver.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(timeFrameStart);
			
			//10) Enter Time Frame End as '6'
			driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(timeFrameEnd);
			
			//11) Click on Save
			driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
			
			//12) Verify the error message
			genericNotification=driver.findElement(By.xpath("//div[@class='genericNotification']/span")).getText();
			//Validate the Generic Error Message
			Assert.assertEquals(genericNotification,"Review the errors on this page.");
			
			//Validate Timeframe Start Error Message
			timeFrameStartErrMsg=driver.findElement(By.xpath("//span[text()='Timeframe Start']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul[contains(@class,'has-error')]/li")).getText();
			Assert.assertEquals(timeFrameStartErrMsg,"Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe Start");
			
			//Validate Timeframe End Error Message
			timeFrameEndErrMsg=driver.findElement(By.xpath("//span[text()='Timeframe End']/ancestor::div[contains(@class,'uiInputNumber')]/following-sibling::ul[contains(@class,'has-error')]/li")).getText();
			Assert.assertEquals(timeFrameEndErrMsg,"Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe End");
			
			driver.findElement(By.xpath("//button[@title='Close this window']")).click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
