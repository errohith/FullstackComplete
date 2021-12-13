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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.testNG.Base.BaseClass;

public class S01964_DeleteWorkType extends BaseClass{

	int lastColNum;
	String Message;
	String workTypeName;
	
	//@Test(invocationCount = 3,dependsOnMethods = {"selenium.testNG.WorkType.S01962_EditWorkTypeNegative.EditWorkTypeNegative","selenium.testNG.WorkType.S01963_EditWorkType.EditWorkType"})
	@Test(invocationCount = 3, dependsOnGroups = {"Regression"},groups = {"smoke","Functional"})
	public void DeleteWorkType() {
	
			
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
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
