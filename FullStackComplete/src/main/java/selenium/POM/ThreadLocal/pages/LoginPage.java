package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class LoginPage extends BaseClass {
	
	public LoginPage(String Browser) {
		this.Browser=Browser;
	}
	public LoginPage enterUsername(String LoginID) {
		getWait().until(ExpectedConditions.titleContains("Login"));
		getDriver().findElement(By.id("username")).sendKeys(LoginID);		
		return this;
	}
	public LoginPage enterPassword(String Password) throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.id("password")).sendKeys(Password);
		return this;	
	}
	public HomePage clickLoginButton() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		Thread.sleep(1000);
		getDriver().findElement(By.id("Login")).click();
		return new HomePage(Browser);
	}
	
}
