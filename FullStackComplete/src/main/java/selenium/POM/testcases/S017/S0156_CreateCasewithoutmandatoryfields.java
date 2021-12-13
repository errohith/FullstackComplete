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


public class S0156_CreateCasewithoutmandatoryfields extends BaseClass{
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0156_CreateCaseNegative";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;
		
	}
	
	@Test(dataProvider="data")
	public void newCaseCreationNegative(String Salutation,
										String FirstName,
										String LastName,
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
			.selectStatus(Status)
			.enterSubject(Subject)
			.enterDescription(Description)
			.clickSave()
			.verifyTheErrorMessage();
		
	}
}
