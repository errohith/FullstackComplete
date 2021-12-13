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

public class S01963_EditWorkType extends BaseClass{

	//static String timeFrameEnd="18";
	//static String timeFrameStart="9";
	
	int lastColNum;
	String successMessage;
	String workTypeName;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="TestData";
		sheetName="EditWorkType";
		
	}
	
	@Test(alwaysRun = true,dependsOnMethods = {"selenium.testNG.WorkType.S01962_EditWorkTypeNegative.EditWorkTypeNegative"}, dataProvider = "data", groups = {"Regression"})
	public void EditWorkType(String timeFrameEnd, String timeFrameStart) {
	
			
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
			Thread.sleep(1000);
			lastColNum=driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
			workTypeName=driver.findElement(By.xpath("//table/tbody/tr[1]/th//a")).getText();
			driver.findElement(By.xpath("//table/tbody/tr[4]/td["+lastColNum+"]//a")).click();
			
			//8) Click on Edit
			driver.findElement(By.xpath("//a[@title='Edit']")).click();
			
			//9) Enter Time Frame Start as '9'
			driver.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).clear();
			driver.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(timeFrameStart);
			
			//10) Enter Time Frame End as '18'
			driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).clear();
			driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label//following-sibling::input[contains(@class,'uiInputSmartNumber')]")).sendKeys(timeFrameEnd);
			
			//11) Click on Save
			driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
			
			//12) Verify the success message
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), workTypeName));
			successMessage=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			Assert.assertEquals(successMessage,"Work Type \""+workTypeName+"\" was saved.");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
