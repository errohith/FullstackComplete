package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class NewCaseCreationPage extends BaseClass {
	
	public NewCaseCreationPage(String Browser) {
		this.Browser=Browser;
	}
	
	public NewCaseCreationPage clickSearchContact() {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//input[@title='Search Contacts']"))));
		WebElement el = getDriver().findElement(By.xpath("//input[@title='Search Contacts']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public CreateNewContactPage clickNewContact() {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@title='New Contact']"))));
		WebElement el = getDriver().findElement(By.xpath("//span[@title='New Contact']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return new CreateNewContactPage(Browser);
	}
	public NewCaseCreationPage selectCaseOrigin(String CaseOrigin) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']")));
		WebElement el = getDriver().findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectStatus(String Status) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Status']//following-sibling::div//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Status']//following-sibling::div//input"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[contains(@title,'"+Status+"')]"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectPriority(String Priority) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Priority']/parent::span//following-sibling::div//a")));
		WebElement el = getDriver().findElement(By.xpath("//span[text()='Priority']/parent::span//following-sibling::div//a"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@title='"+Priority+"']"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage enterSubject(String Subject) {
		getDriver().findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys(Subject);
		return this;
	}
	public NewCaseCreationPage enterDescription(String Description) {
		getDriver().findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys(Description);
		return this;
	}
	public CasesPage clickSave() {
		getDriver().findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		return new CasesPage(Browser);
	}

}
