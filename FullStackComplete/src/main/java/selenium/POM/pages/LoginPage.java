package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		System.out.println(Browser);
		System.out.println("This. : "+this.Browser);
	}
	public LoginPage enterUsername(String LoginID) {
		wait.until(ExpectedConditions.titleContains("Login"));
		driver.findElement(By.id("username")).sendKeys(LoginID);		
		return this;
	}
	public LoginPage enterPassword(String Password) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(Password);
		return this;	
	}
	public HomePage clickLoginButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		Thread.sleep(1000);
		driver.findElement(By.id("Login")).click();
		return new HomePage(driver,wait,js,Browser);
	}
	
}
