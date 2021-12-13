package selenium.POM.ThreadLocal.pages;

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

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class AccountsPage extends BaseClass {
	List<String> expectedList = new ArrayList<>();
	List<String> actualList = new ArrayList<>();
	int rowCount;
	public AccountsPage(String Browser) {
		this.Browser=Browser;
	}
	public AccountsPage clickSort() {
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='countSortedByFilteredBy']")));
		rowCount = Integer.parseInt(getDriver().findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText().substring(0, 2));
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
		getJSExecutor().executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath("//span[@title='Account Name']")));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//span[@title='Account Name']")));
		//getDriver().findElement(By.xpath("//span[@title='Account Name']")).click();
		return this;
	}
	public New_EditAccountPage clickNewButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']/parent::a")));
		getDriver().findElement(By.xpath("//div[@title='New']/parent::a")).click();
		return new New_EditAccountPage(Browser);
	}
	public AccountsPage entersearchkey(String accountName) {
		getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search this list')]")).sendKeys(accountName);
		getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search this list')]")).sendKeys(Keys.ENTER);
		return this;
	}
	public New_EditAccountPage clickEditForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), accountName));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[6]//a")).click();
		getDriver().findElement(By.xpath("//a[@title='Edit']")).click();
		return	new New_EditAccountPage(Browser);
	}
	public AccountsPage clickDeleteForAccount(String accountName) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), accountName));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[6]//a")).click();
		getDriver().findElement(By.xpath("//a[@title='Delete']")).click();
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete']")));
		getDriver().findElement(By.xpath("//button[@title='Delete']")).click();
		return	this;
	}
	public void verifyAccountCreated(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@title,'"+accountName+"')]"), accountName));
		String actualText = getDriver().findElement(By.xpath("//div[contains(@title,'"+accountName+"')]")).getText();
		Assert.assertEquals(actualText,"\""+accountName+"\"");
	}
	public AccountsPage verifyAccountEdited(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), accountName));
		String actualText=getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		Assert.assertEquals(actualText, "Account \""+accountName+"\" was saved.");
		return this;
	}
	public AccountsPage verifyDeleteToastMessage(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), accountName));
		String actualText=getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		Assert.assertEquals(actualText, "Account \""+accountName+"\" was deleted. Undo");
		return this;
	}
	public void verifyPhoneNumber(String phoneNum) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/td[4]//span[contains(@class,'forceOutputPhone')]"), phoneNum));
		String actualPhoneNum = getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/td[4]//span[contains(@class,'forceOutputPhone')]")).getText();
		Assert.assertEquals(actualPhoneNum,phoneNum);
	}
	public void verifyAccountIsDeleted(String accountName) {
		getDriver().findElement(By.xpath("//input[contains(@placeholder,\"Search this list\")]")).sendKeys(accountName);
		getDriver().findElement(By.xpath("//input[contains(@placeholder,\"Search this list\")]")).sendKeys(Keys.ENTER);
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p/*[contains(@class,'rich-text-editor')]/span"), "No items to display."));
		Assert.assertEquals(getDriver().findElement(By.xpath("//p/*[contains(@class,'rich-text-editor')]/span")).getText(),"No items to display.");
	}
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
