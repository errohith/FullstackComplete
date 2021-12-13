package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class CreateNewContactPage extends BaseClass {
	
	
	public CreateNewContactPage selectSalutation(String Salutation) {
		getDriver().findElement(By.xpath($("CreateNewContactPage.Salutation.xpath"))).click();
		getDriver().findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		return this;
	}
	public CreateNewContactPage enterFirstName(String FirstName) {
		getDriver().findElement(By.xpath($("CreateNewContactPage.FirstName.xpath"))).sendKeys(FirstName);
		return this;
	}
	public CreateNewContactPage enterLastName(String LastName) {
		getDriver().findElement(By.xpath($("CreateNewContactPage.LastName.xpath"))).sendKeys(LastName);
		return this;
	}
	public NewCaseCreationPage clickSave() {
		getDriver().findElement(By.xpath($("General.Save.xpath"))).click();
		return new NewCaseCreationPage();
	}

}
