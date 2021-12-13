package selenium.POM.ThreadLocal.testcases.S012;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.LoginPage;



public class S0129_CreateNewAcount extends BaseClass {
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0129_CreateNewAccount";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;	
	}
	
	@Test(dataProvider = "data")
	public void newAccountCreate(String accountName, String ownership) throws InterruptedException {
		
		new LoginPage(Browser)
		.enterUsername(LoginID)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggleMenu()
		.clickViewAll()
		.enterSearchKey()
		.clickSales()
		.clickAccountsTab()
		.clickNewButton()
		.enterAccountName(accountName)
		.selectOwnership(ownership)
		.clickSave()
		.verifyAccountCreated(accountName);
	}
	

}
