package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;

public class New_EditProductPage extends BaseClass {
	
	@And("I add a New Product as {string}")
	public New_EditProductPage addProductName(String productName) {
		getDriver().findElement(By.xpath($("New_EditProductPage.ProductName.xpath"))).sendKeys(productName);
		return this;
	}
	@And("Click Save in Product Page")
	public New_EditTaskPage clickSave() {
		getDriver().findElement(By.xpath($("New_EditProductPage.Save.xpath"))).click();
		return new New_EditTaskPage();
	}

}
