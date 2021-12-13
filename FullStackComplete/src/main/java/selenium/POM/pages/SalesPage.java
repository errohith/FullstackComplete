package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class SalesPage extends BaseClass {
	
	public SalesPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		System.out.println(Browser);
	}
	
	//for CASE Test Case
	public SalesPage clickMore() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='More']"))); 
		return this;
	}
	public CasesPage selectCaseFromDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		return new CasesPage(driver,wait,js,Browser);
	}
	public AccountsPage clickAccountsTab() {
		WebElement el = driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Accounts']"));
		js.executeScript("arguments[0].click();",el);
		return new AccountsPage(driver, wait, js, Browser);
	}
	
	
}
