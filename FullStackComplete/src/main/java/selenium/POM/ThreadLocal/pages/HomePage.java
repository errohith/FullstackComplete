package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class HomePage extends BaseClass {
	
	public HomePage(String Browser) {
		this.Browser=Browser;
	}
	
	public HomePage clickToggleMenu() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
		
	}
	public HomePage clickViewAll() {
		getJSExecutor().executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath("//button[text()='View All']")));
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	public HomePage enterSearchKey() {
		getDriver().findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		return this;
	}
	public SalesPage clickSales() {
		getDriver().findElement(By.xpath("//div[@class='slds-truncate']//p[contains(text(),'Manage your sales')]")).click();
		return new SalesPage(Browser);
	}
	

}
