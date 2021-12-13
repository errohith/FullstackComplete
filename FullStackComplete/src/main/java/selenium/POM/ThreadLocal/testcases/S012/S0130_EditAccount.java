package selenium.POM.ThreadLocal.testcases.S012;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.pages.LoginPage;



public class S0130_EditAccount extends BaseClass {
	
	String LoginID,Password;
	
	@Parameters({"LoginID","Password"})
	@BeforeClass(alwaysRun = true)
	public void getData(String LoginID,
						String Password) {
		
		fileName="S0130_EditAccount";
		sheetName="Sheet1";
		this.LoginID=LoginID;
		this.Password=Password;	
	}
	
	@Test(dataProvider = "data")
	public void editAcount(String AccountName,
						   String Type,
						   String Industry,
						   String BillingAddress,
						   String ShippingAddress,
						   String Priority,
						   String SLA,
						   String Active,
						   String PhoneNumber,
						   String Oppurtunity) throws InterruptedException {
		
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
		.clickEditForAccount(AccountName)
		.selectType(Type)
		.selectIndutry(Industry)
		.enterBillingAddress(BillingAddress)
		.enterShippingAddress(ShippingAddress)
		.selectPriority(Priority)
		.selectSLA(SLA)
		.selectActive(Active)
		.enterPhoneNumber(PhoneNumber)
		.selectOpportunity(Oppurtunity)
		.clickSave()
		.verifyAccountEdited(AccountName)
		.verifyPhoneNumber(PhoneNumber);
	}
	

}
