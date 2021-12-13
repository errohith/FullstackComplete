package selenium.POM.ThreadLocal.testcases.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.LoginPage;




public class S0154_EditCase extends BaseClass{
	String LoginID,Password;
	
	//@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData() {
		
		fileName="S0154_EditCase";
		sheetName="Sheet1";
		
	}
	
	@Test(dependsOnMethods = {"selenium.POM.ThreadLocal.testcases.S017.S0153_CreateNewCase.newCaseCreation"},dataProvider = "data")
	public void editCase(String caseID,String CaseOrigin,
						 String Status,
						 String Priority) throws InterruptedException {
		
		System.out.println("Thread ID is : " + Thread.currentThread().getId());
		if(!(caseID==null)) {
			new LoginPage(Browser)
			.enterUsername(prop.getProperty("LoginID"))
			.enterPassword(prop.getProperty("Password"))
			.clickLoginButton()
			.clickToggleMenu()
			.clickViewAll()
			.clickSales()
			.clickMore()
			.selectCaseFromDropDown()
			.findCaseID(caseID)
			.clickEdit()
			.selectCaseOrigin(CaseOrigin)
			.selectStatus(Status)
			.selectPriority(Priority)
			.clickSave()
			.verifyStatusIsChanged(Status,caseID);
		}				
	}
}
