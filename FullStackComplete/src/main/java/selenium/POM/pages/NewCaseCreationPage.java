package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.BaseClass.BaseClass;

public class NewCaseCreationPage extends BaseClass {
	
	public NewCaseCreationPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,String Browser) {
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		this.Browser=Browser;
		System.out.println(Browser);
		System.out.println("This. : "+this.Browser);
	}
	
	public NewCaseCreationPage clickSearchContact() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Contacts']"))));
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		return this;
	}
	public CreateNewContactPage clickNewContact() {
		WebElement el = driver.findElement(By.xpath("//span[@title='New Contact']"));
		js.executeScript("arguments[0].click();", el);
		return new CreateNewContactPage(driver,wait,js,Browser);
	}
	public NewCaseCreationPage selectCaseOrigin(String CaseOrigin) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']")));
		WebElement el = driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']"));
		js.executeScript("arguments[0].click();", el);
		el = driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']"));
		js.executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectStatus(String Status) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Status']//following-sibling::div//input")));
		WebElement el = driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div//input"));
		js.executeScript("arguments[0].click();", el);
		el = driver.findElement(By.xpath("//span[contains(@title,'"+Status+"')]"));
		js.executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectPriority(String Priority) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Priority']/parent::span//following-sibling::div//a")));
		WebElement el = driver.findElement(By.xpath("//span[text()='Priority']/parent::span//following-sibling::div//a"));
		js.executeScript("arguments[0].click();", el);
		el = driver.findElement(By.xpath("//a[@title='"+Priority+"']"));
		js.executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage enterSubject(String Subject) {
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys(Subject);
		return this;
	}
	public NewCaseCreationPage enterDescription(String Description) {
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys(Description);
		return this;
	}
	public CasesPage clickSave() {
		driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		return new CasesPage(driver,wait,js,Browser);
	}

}
