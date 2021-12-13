package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;




public class SalesPage extends BaseClass {
	
	
	public SalesPage clickMore() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("SalesPage.MoreLink.xpath"))));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath($("SalesPage.MoreLink.xpath")))); 
		return this;
	}
	public CasesPage selectCaseFromDropDown() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("SalesPage.SelectCase.xpath"))));
		getJSExecutor().executeScript("arguments[0].click();",getDriver().findElement(By.xpath($("SalesPage.SelectCase.xpath"))));
		return new CasesPage();
	}
	@And("Click Accounts Tab")
	public AccountsPage clickAccountsTab() {
		WebElement el = getDriver().findElement(By.xpath($("SalePage.AccountTab.xpath")));
		getJSExecutor().executeScript("arguments[0].click();",el);
		return new AccountsPage();
	}

}
