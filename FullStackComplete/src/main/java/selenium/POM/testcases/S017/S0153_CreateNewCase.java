package selenium.POM.testcases.S017;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.BaseClass.BaseClass;
import selenium.POM.pages.CasesPage;
import selenium.POM.pages.LoginPage;

public class S0153_CreateNewCase extends BaseClass{
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0153_CreateNewCase";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;
		
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
		
		new LoginPage(driver,wait,js,Browser)
		.enterUsername(LoginID)
		.enterPassword(Password)
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
		new CasesPage(driver, wait, js, Browser).writecaseIDbacktoExcel(sheetName);
	}
}
