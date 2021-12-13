package selenium.POM.ThreadLocal.testcases.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.LoginPage;


public class S0156_CreateCasewithoutmandatoryfields extends BaseClass{
	
	String LoginID,Password;
	
	//@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData() {
		
		fileName="S0156_CreateCaseNegative";
		sheetName="Sheet1";		
	}
	
	@Test(dataProvider="data")
	public void newCaseCreationNegative(String Salutation,
										String FirstName,
										String LastName,
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
