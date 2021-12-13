package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		System.out.println(Browser);
		System.out.println("This. : "+this.Browser);
	}
	
	public HomePage clickToggleMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
		
	}
	public HomePage clickViewAll() {
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	public HomePage enterSearchKey() {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		return this;
	}
	public SalesPage clickSales() {
		driver.findElement(By.xpath("//div[@class='slds-truncate']//p[contains(text(),'Manage your sales')]")).click();
		return new SalesPage(driver,wait,js,Browser);
	}
	

}
