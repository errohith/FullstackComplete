package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class LoginPage extends BaseClass {
	
	@Given("Enter Username as {string}")
	public LoginPage enterUsername(String LoginID) {
		getWait().until(ExpectedConditions.titleContains("Login"));
		getDriver().findElement(By.id($("LoginPage.Username.id"))).sendKeys(LoginID);		
		return this;
	}
	@And("Enter Password as {string}")
	public LoginPage enterPassword(String Password) throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(By.id($("LoginPage.Password.id"))).sendKeys(Password);
		return this;	
	}
	@And("Click Login Button")
	public HomePage clickLoginButton() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		Thread.sleep(1000);
		getDriver().findElement(By.id($("LoginPage.LoginButton.id"))).click();
		return new HomePage();
	}
	
}
