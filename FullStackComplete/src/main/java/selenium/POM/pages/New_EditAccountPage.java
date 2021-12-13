package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class New_EditAccountPage extends BaseClass {
	
	public New_EditAccountPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		
	}
	public New_EditAccountPage enterAccountName(String accountName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
		return this;
	}
	public New_EditAccountPage selectOwnership(String Ownership) {
		driver.findElement(By.xpath("//label[text()='Ownership']/parent::lightning-combobox//input")).click();
		driver.findElement(By.xpath("//span[@title='"+Ownership+"']")).click();
		return this;
	}
	public AccountsPage clickSave() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return new AccountsPage(driver, wait, js, Browser);
	}

}
