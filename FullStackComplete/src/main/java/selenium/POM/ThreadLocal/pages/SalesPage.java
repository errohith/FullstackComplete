package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;




public class SalesPage extends BaseClass {
	
	public SalesPage(String Browser) {
		this.Browser=Browser;
	}
	
	public SalesPage clickMore() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//span[text()='More']"))); 
		return this;
	}
	public CasesPage selectCaseFromDropDown() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		return new CasesPage(Browser);
	}
	public AccountsPage clickAccountsTab() {
		WebElement el = getDriver().findElement(By.xpath("//span[@class='slds-truncate' and text()='Accounts']"));
		getJSExecutor().executeScript("arguments[0].click();",el);
		return new AccountsPage(Browser);
	}

}
