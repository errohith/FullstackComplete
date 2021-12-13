package selenium.POM.ThreadLocal.CucumberPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class AccountsPage extends BaseClass {
	List<String> expectedList = new ArrayList<>();
	List<String> actualList = new ArrayList<>();
	int rowCount;
	
	@When("Click sorting button on Account column")
	public AccountsPage clickSort() {
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='countSortedByFilteredBy']")));
		rowCount = Integer.parseInt(getDriver().findElement(By.xpath($("AccountsPage.NoofRows.xpath"))).getText().substring(0, 2));
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			getJSExecutor().executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")));
			expectedList.add(getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")).getText().toLowerCase());
			if(i==rowCount) {
				rowCount = Integer.parseInt(getDriver().findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText().substring(0, 2));
			}
		} 
		Collections.sort(expectedList,String.CASE_INSENSITIVE_ORDER);
		//getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]//th[3]//a")).click();
		getJSExecutor().executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath($("AccountsPage.AccountNameColumn.xpath"))));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath($("AccountsPage.AccountNameColumn.xpath"))));
		//getDriver().findElement(By.xpath("//span[@title='Account Name']")).click();
		return this;
	}
	@When("Click New Button")
	public New_EditAccountPage clickNewButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("AccountsPage.NewButton.xpath"))));
		getDriver().findElement(By.xpath($("AccountsPage.NewButton.xpath"))).click();
		return new New_EditAccountPage();
	}
	@When("Enter Search Key as {string}")
	public AccountsPage entersearchkey(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("ContentPage.DisplayAsButton.xpath"))));
		getDriver().findElement(By.xpath($("ContentPage.DisplayAsButton.xpath"))).click();
		getDriver().findElement(By.xpath($("ContentPage.DisplayAsTableView.xpath"))).click();
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).clear();
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).sendKeys(accountName);
		Thread.sleep(500);
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).sendKeys(Keys.ENTER);
		return this;
	}
	@And("Click the {string} for Edit")
	public New_EditAccountPage clickEditForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("AccountsPage.FirstRecordAccountName.xpath")), accountName));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath($("AccountsPage.OptionsDropDown.xpath"))).click();
		getDriver().findElement(By.xpath($("General.EditRecordButton.xpath"))).click();
		return	new New_EditAccountPage();
	}
	@And("Click Delete the Account for {string}")
	public AccountsPage clickDeleteForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("AccountsPage.FirstRecordAccountName.xpath")), accountName));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath($("AccountsPage.OptionsDropDown.xpath"))).click();
		getDriver().findElement(By.xpath($("General.DeleteRecordButton.xpath"))).click();
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("General.DeleteRecordConfirmation.xpath"))));
		getDriver().findElement(By.xpath($("General.DeleteRecordConfirmation.xpath"))).click();
		return	this;
	}
	@Then("Verify Accont is created with Account Name {string}")
	public void verifyAccountCreated(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@title,'"+accountName+"')]"), accountName));
		String actualText = getDriver().findElement(By.xpath("//div[contains(@title,'"+accountName+"')]")).getText();
		Assert.assertEquals(actualText,"\""+accountName+"\"");
	}
	@Then("Verify Account {string} is Edited")
	public AccountsPage verifyAccountEdited(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.ToastMessage.xpath")), accountName));
		String actualText=getDriver().findElement(By.xpath($("General.ToastMessage.xpath"))).getText();
		Assert.assertEquals(actualText, "Account \""+accountName+"\" was saved.");
		return this;
	}
	@Then("Verify the Toast Message for the deleted account {string}")
	public AccountsPage verifyDeleteToastMessage(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.ToastMessage.xpath")), accountName));
		String actualText=getDriver().findElement(By.xpath($("General.ToastMessage.xpath"))).getText();
		Assert.assertEquals(actualText, "Account \""+accountName+"\" was deleted. Undo");
		return this;
	}
	@And("Verify Phone Number {string} is populated correctly")
	public void verifyPhoneNumber(String phoneNum) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("AccountsPage.FirstRecordPhoneNo.xpath")), phoneNum));
		String actualPhoneNum = getDriver().findElement(By.xpath($("AccountsPage.FirstRecordPhoneNo.xpath"))).getText();
		Assert.assertEquals(actualPhoneNum,phoneNum);
	}
	@And("Verify {string} is deleted")
	public void verifyAccountIsDeleted(String accountName) throws InterruptedException {
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).clear();
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).sendKeys(accountName);
		Thread.sleep(500);
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).sendKeys(Keys.ENTER);
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.SearchResultNoItemMessage.xpath")), "No items to display."));
		Assert.assertEquals(getDriver().findElement(By.xpath($("General.SearchResultNoItemMessage.xpath"))).getText(),"No items to display.");
	}
	@Then("Verify Sort Order")
	public void verifySortOrder() throws InterruptedException {
		System.out.println(rowCount);
		Thread.sleep(1000);
		for(int i=1;i<=rowCount;i++) {
			getJSExecutor().executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")));
			actualList.add(getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr["+i+"]/th//a")).getText().toLowerCase());
			if(i==rowCount) {
				rowCount = Integer.parseInt(getDriver().findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText().substring(0, 2));
			}
		}
		System.out.println(expectedList);
		System.out.println(actualList);
		Assert.assertEquals(actualList,expectedList);
	}
	

}
