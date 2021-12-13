package selenium.S0110;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;
import selenium.utility.Util;

public class S011074_NonProfitCertifications extends BaseClass {
	
	public List<String> certList,sortedList;

	@Test
	public void NonProfitCertCheck() {
		
		//3. Click on the sliding icon until "See System Status" is displayed
		while(!driver.findElement(By.xpath("//span[contains(@class,'uiOutputText') and text()='See System Status']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]")).click();
		}
		
		//4. Click on Get Started link
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(@class,'uiOutputText') and text()='See System Status']/ancestor::div[1]/following-sibling::div[@class='tileNavButton']/button")));
		
		//5. Navigate to SalesForce Trust new Window
		driver.switchTo().window(Util.getLastWindow(driver));
		
		wait.until(ExpectedConditions.titleContains("Salesforce Trust"));
		
		//6. Select Trust Compliance from the dropdown
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Show More']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//li[@id='Compliance']/a")));		
		wait.until(ExpectedConditions.titleContains("Certifications | Salesforce Compliance"));
		
		
		//7. Click on Show Filters
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Show filters')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Show filters')]")).click();
		
		//8. Select "Nonprofit" under INDUSTRIES
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='Nonprofit']")));
		driver.findElement(By.xpath("//label[@for='Nonprofit']")).click();
		
		//9. Clear Filter option should be displayed
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Clear filters')]")).isDisplayed());
		
		//10. Verify the 23 Ceriticates that are Nonprofit only should be displayed
		List<WebElement> certificates = driver.findElements(By.xpath("//h2[@class='mb2 lh-title']//span/span"));
		Assert.assertEquals(Integer.toString(certificates.size()), "23");
		
		//Close the new Window and switch to previous window
		driver.close();
		driver.switchTo().window(Util.getLastWindow(driver));
		
	}

}
