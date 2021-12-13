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

public class S011075_ServicesSortorder extends BaseClass {
	
	public List<String> certList,sortedList;

	@Test
	public void servicesSortingCheck() {
		
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
		
		//7. Navigate to Services tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Services']")));
		driver.findElement(By.xpath("//a[text()='Services']")).click();
		wait.until(ExpectedConditions.titleContains("Services | Salesforce Compliance"));
		List<WebElement> certificates = driver.findElements(By.xpath("//h2[@class='mb2 lh-title']//span/span"));
		
		//8. Verify the Services are displayed in alphabetical order
		certList = new LinkedList<String>();
		sortedList = new LinkedList<String>();
		for (WebElement certificate : certificates) {
			certList.add(certificate.getText());
		}
		sortedList.addAll(certList);
		Collections.sort(sortedList,String.CASE_INSENSITIVE_ORDER);
		
		//The order should be in the alphabetical order
		Assert.assertTrue(sortedList.equals(certList));
		
		//Close the new Window and switch to previous window
		driver.close();
		driver.switchTo().window(Util.getLastWindow(driver));
		
	}

}
