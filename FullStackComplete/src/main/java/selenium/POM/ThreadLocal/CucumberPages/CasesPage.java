package selenium.POM.ThreadLocal.CucumberPages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;
import selenium.utility.Util;

public class CasesPage extends BaseClass {
		

	public CasesPage findCaseID(String caseID) {
		getDriver().findElement(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[7]//a")).click();
		return this;
	}
	public NewCaseCreationPage clickEdit( ) {
		getDriver().findElement(By.xpath($("General.EditRecordButton.xpath"))).click();
		return new NewCaseCreationPage();
	}
	public CasesPage clickAndConfirmDelete() {
		getDriver().findElement(By.xpath($("General.DeleteRecordButton.xpath"))).click();
		getDriver().findElement(By.xpath($("General.DeleteRecordConfirmation.xpath"))).click();
		return this;
	}
	public CasesPage clickCasesTab() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("CasesPage.CasesTab.xpath"))));
		Thread.sleep(500);
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath($("CasesPage.CasesTab.xpath"))));
		return this;
	}
	public NewCaseCreationPage clickNewCase() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("CasesPage.NewCase.xpath"))));
		Thread.sleep(500);
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath($("CasesPage.NewCase.xpath"))));
		return new NewCaseCreationPage();
	}
	public void verifyNewCaseCreated() {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated((By.xpath($("General.ToastMessage.xpath"))), "Case"));
		String actualToastMsg = getDriver().findElement(By.xpath($("General.ToastMessage.xpath"))).getText();
		String caseID = getDriver().findElement(By.xpath("//p[@title='Case Number']/following-sibling::p//lightning-formatted-text")).getText();
		Assert.assertEquals(actualToastMsg,"Case \""+caseID+"\" was created.");
//		if(Browser.equalsIgnoreCase("Chrome")) {
//			caseID_Chrome.add(caseID);
//		} else {
//			caseID_Firefox.add(caseID);
//		}
	}
	public void verifyStatusIsChanged(String Status,String caseID) throws InterruptedException {
		//getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[4]//span[@class='slds-truncate' and text()='"+Status+"']")));
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[4]//span[@class='slds-truncate']"), Status));
		//Thread.sleep(1000);
		String actualStatus = getDriver().findElement(By.xpath("//th//a[text()='"+caseID+"']/ancestor::tr/td[4]//span[@class='slds-truncate']")).getText();
		Assert.assertEquals(actualStatus,Status);
	}
	public CasesPage verifyToastMessageforDelete(String caseID) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.ToastMessage.xpath")), caseID));
		String actualMsg = getDriver().findElement(By.xpath($("General.ToastMessage.xpath"))).getText();
		Assert.assertEquals(actualMsg, "Case \""+caseID+"\" was deleted. Undo");
		return this;
	}
	public void verifyCaseIDIsDeleted(String caseID) {
		getDriver().findElement(By.xpath($("General.Searchbox.xpath"))).sendKeys(caseID,Keys.ENTER);
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.SearchResultNoItemMessage.xpath")), "No items to display."));
		Assert.assertEquals(getDriver().findElement(By.xpath($("General.SearchResultNoItemMessage.xpath"))).getText(),"No items to display.");
	}
	public void verifyTheErrorMessage() {
		String errorText = getDriver().findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
		Assert.assertEquals(errorText,"These required fields must be completed: Case Origin, Status");
		
		errorText=getDriver().findElement(By.xpath("//label[text()='Status']//following-sibling::div[contains(@class,'help')]")).getText();
		Assert.assertEquals(errorText,"Complete this field.");
		
		errorText=getDriver().findElement(By.xpath("//span[text()='Case Origin']/ancestor::div[1]/following-sibling::ul/li[contains(@class,'help')]")).getText();
		Assert.assertEquals(errorText,"Complete this field.");
	}
//	public void writecaseIDbacktoExcel(String sheetName) {
//		System.out.println("WriteExcel : "+Browser);
//		System.out.println(caseID_Chrome);
//		System.out.println(caseID_Firefox);
//		new Util().writeExcel("S0154_EditCase", sheetName,"caseID",Browser);
//		new Util().writeExcel("S0155_DeleteCase", sheetName,"caseID",Browser);
//	}

}
