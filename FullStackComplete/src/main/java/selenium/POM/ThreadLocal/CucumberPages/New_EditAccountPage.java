package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class New_EditAccountPage extends BaseClass {
	
	@And("Enter Account Name as {string}")
	public New_EditAccountPage enterAccountName(String accountName) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath($("New_EditAccountPage.AccountName.xpath"))));
		getDriver().findElement(By.xpath($("New_EditAccountPage.AccountName.xpath"))).sendKeys(accountName);
		return this;
	}
	@And("Select Ownership as {string}")
	public New_EditAccountPage selectOwnership(String Ownership) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Ownership']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Ownership']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+Ownership+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select Type as {string}")
	public New_EditAccountPage selectType(String type) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.Ownership.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.Ownership.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+type+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select Industry as {string}")
	public New_EditAccountPage selectIndutry(String industry) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.Industry.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.Industry.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+industry+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Enter Billing Address as {string}")
	public New_EditAccountPage enterBillingAddress(String billAddress) {
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Street.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Street.xpath"))).sendKeys(billAddress.split(",")[0]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.City.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.City.xpath"))).sendKeys(billAddress.split(",")[1]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Province.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Province.xpath"))).sendKeys(billAddress.split(",")[2]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.PostalCode.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.PostalCode.xpath"))).sendKeys(billAddress.split(",")[3]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Country.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.BillingAddress.Country.xpath"))).sendKeys(billAddress.split(",")[4]);	
		return this;
	}
	@And("Enter Shipping Address as {string}")
	public New_EditAccountPage enterShippingAddress(String shipAddress) {
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Street.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Street.xpath"))).sendKeys(shipAddress.split(",")[0]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.City.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.City.xpath"))).sendKeys(shipAddress.split(",")[1]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Province.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Province.xpath"))).sendKeys(shipAddress.split(",")[2]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.PostalCode.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.PostalCode.xpath"))).sendKeys(shipAddress.split(",")[3]);
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Country.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.ShippingAddress.Country.xpath"))).sendKeys(shipAddress.split(",")[4]);	
		return this;
	}
	@And("Select Priority as {string}")
	public New_EditAccountPage selectPriority(String priority) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.Priority.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.Priority.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+priority+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select SLA as {string}")
	public New_EditAccountPage selectSLA(String SLA) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.SLA.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.SLA.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+SLA+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select Active as {string}")
	public New_EditAccountPage selectActive(String active) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.Active.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.Active.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+active+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Enter Phone Number as {string}")
	public New_EditAccountPage enterPhoneNumber(String phoneNum) {
		getDriver().findElement(By.xpath($("New_EditAccountPage.PhoneNo.xpath"))).clear();
		getDriver().findElement(By.xpath($("New_EditAccountPage.PhoneNo.xpath"))).sendKeys(phoneNum);
		return this;
	}
	@And("Select Oppurtunity as {string}")
	public New_EditAccountPage selectOpportunity(String opportunity) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("New_EditAccountPage.Oppurtunity.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("New_EditAccountPage.Oppurtunity.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+opportunity+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Click Save")
	public AccountsPage clickSave() {
		getDriver().findElement(By.xpath($("General.Save.xpath"))).click();
		return new AccountsPage();
	}
}
