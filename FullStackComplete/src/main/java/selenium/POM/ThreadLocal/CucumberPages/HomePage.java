package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;
import selenium.POM.ThreadLocal.BaseClass.CucumberBaseClass;



public class HomePage extends BaseClass {
	
	@And("Click ToggleMenu")
	public HomePage clickToggleMenu() throws InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("HomePage.ToggleMenu.xpath"))));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath($("HomePage.ToggleMenu.xpath"))).click();
		return this;
		
	}
	@And("Click ViewAll Button")
	public HomePage clickViewAll() {
		getJSExecutor().executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath($("HomePage.ViewAllButton.xpath"))));
		getDriver().findElement(By.xpath($("HomePage.ViewAllButton.xpath"))).click();
		return this;
	}
	@And("Enter Search Key")
	public HomePage enterSearchKey() {
		getDriver().findElement(By.xpath($("HomePage.SearchButton.xpath"))).sendKeys("Sales");
		return this;
	}
	@And("Click Sales")
	public SalesPage clickSales() {
		getDriver().findElement(By.xpath($("HomePage.SalesLink.xpath"))).click();
		return new SalesPage();
	}
	
	@And("Click Content Tab")
	public ContentPage clickContent() {
		getDriver().findElement(By.xpath($("HomePage.ContentLink.xpath"))).click();
		return new ContentPage();
	}
	

}
