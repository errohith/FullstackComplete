package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class CreateNewContactPage extends BaseClass {
	
	public CreateNewContactPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		System.out.println(Browser);
		System.out.println("This. : "+this.Browser);
	}
	
	public CreateNewContactPage selectSalutation(String Salutation) {
		driver.findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		return this;
	}
	public CreateNewContactPage enterFirstName(String FirstName) {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		return this;
	}
	public CreateNewContactPage enterLastName(String LastName) {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		return this;
	}
	public NewCaseCreationPage clickSave() {
		driver.findElement(By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
		return new NewCaseCreationPage(driver,wait,js,Browser);
	}

}
