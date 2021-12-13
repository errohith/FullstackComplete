package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class NewCaseCreationPage extends BaseClass {
	
	
	public NewCaseCreationPage clickSearchContact() {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath($("NewCaseCreationPage.SearchContact.xpath")))));
		WebElement el = getDriver().findElement(By.xpath($("NewCaseCreationPage.SearchContact.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public CreateNewContactPage clickNewContact() {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath($("NewCaseCreationPage.NewContact.xpath")))));
		WebElement el = getDriver().findElement(By.xpath($("NewCaseCreationPage.NewContact.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return new CreateNewContactPage();
	}
	public NewCaseCreationPage selectCaseOrigin(String CaseOrigin) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("NewCaseCreationPage.OriginDropdown.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("NewCaseCreationPage.OriginDropdown.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectStatus(String Status) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("NewCaseCreationPage.StatusDropdown.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("NewCaseCreationPage.StatusDropdown.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[contains(@title,'"+Status+"')]"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage selectPriority(String Priority) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("NewCaseCreationPage.PriorityDropdown.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("NewCaseCreationPage.PriorityDropdown.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@title='"+Priority+"']"));
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	public NewCaseCreationPage enterSubject(String Subject) {
		getDriver().findElement(By.xpath($("NewCaseCreationPage.Subject.xpath"))).sendKeys(Subject);
		return this;
	}
	public NewCaseCreationPage enterDescription(String Description) {
		getDriver().findElement(By.xpath($("NewCaseCreationPage.Description.xpath"))).sendKeys(Description);
		return this;
	}
	public CasesPage clickSave() {
		getDriver().findElement(By.xpath($("General.Save.xpath"))).click();
		return new CasesPage();
	}

}
