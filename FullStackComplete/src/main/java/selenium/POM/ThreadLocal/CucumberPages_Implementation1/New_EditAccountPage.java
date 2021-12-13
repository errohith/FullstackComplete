package selenium.POM.ThreadLocal.CucumberPages_Implementation1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class New_EditAccountPage extends CucumberBaseClass {
	
	@And("Enter Account Name as {string}")
	public New_EditAccountPage enterAccountName(String accountName) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
		getDriver().findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
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
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Type']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Type']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+type+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select Industry as {string}")
	public New_EditAccountPage selectIndutry(String industry) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Industry']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Industry']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+industry+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Enter Billing Address as {string}")
	public New_EditAccountPage enterBillingAddress(String billAddress) {
		getDriver().findElement(By.xpath("//label[text()='Billing Street']/parent::lightning-textarea//textarea[@name='street']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Billing Street']/parent::lightning-textarea//textarea[@name='street']")).sendKeys(billAddress.split(",")[0]);
		getDriver().findElement(By.xpath("//label[text()='Billing City']/parent::lightning-input//input[@name='city']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Billing City']/parent::lightning-input//input[@name='city']")).sendKeys(billAddress.split(",")[1]);
		getDriver().findElement(By.xpath("//label[text()='Billing State/Province']/parent::lightning-input//input[@name='province']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Billing State/Province']/parent::lightning-input//input[@name='province']")).sendKeys(billAddress.split(",")[2]);
		getDriver().findElement(By.xpath("//label[text()='Billing Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Billing Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']")).sendKeys(billAddress.split(",")[3]);
		getDriver().findElement(By.xpath("//label[text()='Billing Country']/parent::lightning-input//input[@name='country']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Billing Country']/parent::lightning-input//input[@name='country']")).sendKeys(billAddress.split(",")[4]);	
		return this;
	}
	@And("Enter Shipping Address as {string}")
	public New_EditAccountPage enterShippingAddress(String shipAddress) {
		getDriver().findElement(By.xpath("//label[text()='Shipping Street']/parent::lightning-textarea//textarea[@name='street']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Shipping Street']/parent::lightning-textarea//textarea[@name='street']")).sendKeys(shipAddress.split(",")[0]);
		getDriver().findElement(By.xpath("//label[text()='Shipping City']/parent::lightning-input//input[@name='city']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Shipping City']/parent::lightning-input//input[@name='city']")).sendKeys(shipAddress.split(",")[1]);
		getDriver().findElement(By.xpath("//label[text()='Shipping State/Province']/parent::lightning-input//input[@name='province']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Shipping State/Province']/parent::lightning-input//input[@name='province']")).sendKeys(shipAddress.split(",")[2]);
		getDriver().findElement(By.xpath("//label[text()='Shipping Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Shipping Zip/Postal Code']/parent::lightning-input//input[@name='postalCode']")).sendKeys(shipAddress.split(",")[3]);
		getDriver().findElement(By.xpath("//label[text()='Shipping Country']/parent::lightning-input//input[@name='country']")).clear();
		getDriver().findElement(By.xpath("//label[text()='Shipping Country']/parent::lightning-input//input[@name='country']")).sendKeys(shipAddress.split(",")[4]);	
		return this;
	}
	@And("Select Priority as {string}")
	public New_EditAccountPage selectPriority(String priority) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Customer Priority']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Customer Priority']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+priority+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select SLA as {string}")
	public New_EditAccountPage selectSLA(String SLA) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='SLA']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='SLA']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+SLA+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Select Active as {string}")
	public New_EditAccountPage selectActive(String active) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Active']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Active']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+active+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Enter Phone Number as {string}")
	public New_EditAccountPage enterPhoneNumber(String phoneNum) {
		getDriver().findElement(By.xpath("//input[@name='Phone']")).clear();
		getDriver().findElement(By.xpath("//input[@name='Phone']")).sendKeys(phoneNum);
		return this;
	}
	@And("Select Oppurtunity as {string}")
	public New_EditAccountPage selectOpportunity(String opportunity) {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Upsell Opportunity']/parent::lightning-combobox//input")));
		WebElement el = getDriver().findElement(By.xpath("//label[text()='Upsell Opportunity']/parent::lightning-combobox//input"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+opportunity+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Click Save")
	public AccountsPage clickSave() {
		getDriver().findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return new AccountsPage();
	}
}
