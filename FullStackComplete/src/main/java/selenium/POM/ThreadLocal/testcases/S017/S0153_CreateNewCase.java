package selenium.POM.ThreadLocal.testcases.S017;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.CasesPage;
import selenium.POM.ThreadLocal.pages.LoginPage;



public class S0153_CreateNewCase extends BaseClass{
	
	String LoginID,Password;
	
	//@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData() {
		
		fileName="S0153_CreateNewCase";
		sheetName="Sheet1";
		
	}

	@Test(dataProvider = "data")
	public void newCaseCreation(String Salutation,
								String FirstName, 
								String LastName, 
								String CaseOrigin, 
								String Status, 
								String Subject, 
								String Description) throws InterruptedException {
		System.out.println("Thread ID is : " + Thread.currentThread().getId());
		
		new LoginPage(Browser)
		.enterUsername(prop.getProperty("LoginID"))
		.enterPassword(prop.getProperty("Password"))
		.clickLoginButton()
		.clickToggleMenu()
		.clickViewAll()
		.enterSearchKey()
		.clickSales()
		.clickMore()
		.selectCaseFromDropDown()
		.clickCasesTab()
		.clickNewCase()
		.clickSearchContact()
		.clickNewContact()
		.selectSalutation(Salutation)
		.enterFirstName(FirstName)
		.enterLastName(LastName)
		.clickSave()
		.selectCaseOrigin(CaseOrigin)
		.selectStatus(Status)
		.enterSubject(Subject)
		.enterDescription(Description)
		.clickSave()
		.verifyNewCaseCreated();
	}
	
	@AfterClass
	public void writeCaseIDToExcel() {
//		System.out.println("Äfter Class Invoked to write in Excel...");
		new CasesPage(Browser).writecaseIDbacktoExcel(sheetName);
	}
}
