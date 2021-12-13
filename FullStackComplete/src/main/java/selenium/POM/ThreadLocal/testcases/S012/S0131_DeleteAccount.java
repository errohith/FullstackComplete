package selenium.POM.ThreadLocal.testcases.S012;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.LoginPage;



public class S0131_DeleteAccount extends BaseClass {
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0131_DeleteAccount";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;	
	}
	
	@Test(dataProvider = "data")
	public void deleteAcount(String AccountName) throws InterruptedException {
		
		new LoginPage(Browser)
		.enterUsername(LoginID)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggleMenu()
		.clickViewAll()
		.enterSearchKey()
		.clickSales()
		.clickAccountsTab()
		.entersearchkey(AccountName)
		.clickDeleteForAccount(AccountName)
		.verifyDeleteToastMessage(AccountName)
		.verifyAccountIsDeleted(AccountName);
	}
	

}
