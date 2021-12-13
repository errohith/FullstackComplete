package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import selenium.POM.BaseClass.BaseClass;

public class AccountsPage extends BaseClass {
	
	public AccountsPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
	}
	public New_EditAccountPage clickNewButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']/parent::a")));
		driver.findElement(By.xpath("//div[@title='New']/parent::a")).click();
		return new New_EditAccountPage(driver, wait, js, Browser);
	}
	public void verifyAccountCreated(String accountName) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@title,'"+accountName+"')]"), accountName));
		String actualText = driver.findElement(By.xpath("//div[contains(@title,'"+accountName+"')]")).getText();
		Assert.assertEquals(actualText,"\""+accountName+"\"");
	}

}
