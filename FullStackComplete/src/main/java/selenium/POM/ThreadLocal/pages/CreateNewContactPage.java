package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class CreateNewContactPage extends BaseClass {
	
	public CreateNewContactPage(String Browser) {
		this.Browser=Browser;
	}
	
	public CreateNewContactPage selectSalutation(String Salutation) {
		getDriver().findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a[@class='select']")).click();
		getDriver().findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		return this;
	}
	public CreateNewContactPage enterFirstName(String FirstName) {
		getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		return this;
	}
	public CreateNewContactPage enterLastName(String LastName) {
		getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		return this;
	}
	public NewCaseCreationPage clickSave() {
		getDriver().findElement(By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
		return new NewCaseCreationPage(Browser);
	}

}
