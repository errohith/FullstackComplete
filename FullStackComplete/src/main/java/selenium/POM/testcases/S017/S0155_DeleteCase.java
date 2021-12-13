package selenium.POM.testcases.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.BaseClass.BaseClass;
import selenium.POM.pages.LoginPage;


public class S0155_DeleteCase extends BaseClass{
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0155_DeleteCase";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;
		
	}
 
	@Test(dependsOnMethods = {"selenium.POM.testcases.S017.S0153_CreateNewCase.newCaseCreation"}, dataProvider="data")
	public void deleteCase(String caseID) throws InterruptedException {
		
		System.out.println("Thread ID is : " + Thread.currentThread().getId());
		
			new LoginPage(driver,wait,js,Browser)
			.enterUsername(LoginID)
			.enterPassword(Password)
			.clickLoginButton()
			.clickToggleMenu()
			.clickViewAll()
			.clickSales()
			.clickMore()
			.selectCaseFromDropDown()
			.findCaseID(caseID)
			.clickAndConfirmDelete()
			.verifyToastMessageforDelete(caseID)
			.verifyCaseIDIsDeleted(caseID);
		
	}
}