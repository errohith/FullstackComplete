package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.And.Ands;
import io.cucumber.java.en.When;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;

public class New_EditTaskPage extends BaseClass{
		
	@When("I Select Assigned To as {string}")
	public New_EditTaskPage selectAssignedTo(String assignedTo) {
		
		getDriver().findElement(By.xpath("//span[@class='pillText' and text()='"+ assignedTo +"']")).click();
		return this;
	}
	@And("I Select subject as {string}")
	public New_EditTaskPage selectSubject(String subject) {
		getDriver().findElement(By.xpath($("New_EditTaskPage.SubjectTextbox.xpath"))).click();
		getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+subject+"']")).click();
		return this;
	}
	@And("I select priority as {string}")
	public New_EditTaskPage selectPriority(String priority) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.PriorityDropDown.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@role='menuitemradio' and @title='"+priority+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("I select status as {string}")
	public New_EditTaskPage selectStatus(String status) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.StatusDropDown.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@role='menuitemradio' and @title='"+status+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("I select Name type as {string} and select name as {string}")
	public New_EditTaskPage selectName(String namedropdown, String name) {
		try {
			getDriver().findElement(By.xpath($("New_EditTaskPage.DeleteExistingName.xpath"))).click();
		} catch(Exception E) {
			System.out.println("No Name added to Delete.");
		}
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.NameSeachDropDown.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@title='"+namedropdown+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		getDriver().findElement(By.xpath($("New_EditTaskPage.NameSearchBox.xpath"))).click();
		el = getDriver().findElement(By.xpath("//div[text()='"+name+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("I select RelatedTo Dropdown as {string}")
	public New_EditTaskPage selectRelatedTo(String relatedTodropdown) {
		try {
			getDriver().findElement(By.xpath($("New_EditTaskPage.DeleteExistingRelatedTo.xpath"))).click();
		} catch(Exception E) {
			System.out.println("No Related-To added to Delete.");
		}	
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.RelatedToSeachDropDown.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//a[@title='"+relatedTodropdown+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Add New relation")
	public New_EditProductPage newRelation() {
		getDriver().findElement(By.xpath($("New_EditTaskPage.RelatedToNameSearchBox.xpath"))).click();
		getDriver().findElement(By.xpath($("New_EditTaskPage.NewProductLink.xpath"))).click();
		return new New_EditProductPage();
		
	}
	@Ands({@And("I select added product {string}")})
	public New_EditTaskPage selectProduct(String relatedToName) {
		WebElement el = getDriver().findElement(By.xpath("//div[text()='"+relatedToName+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("I select the existing {string} from dropdown")
	public New_EditTaskPage selectAccount(String accountName) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.RelatedToNameSearchBox.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//div[@title='"+accountName+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Click Save in Task Page")
	public ContentPage clickSave() {
		getDriver().findElement(By.xpath($("New_EditTaskPage.Save.xpath"))).click();
		return new ContentPage();
	}
	@And("Select Month as {string} and date as {string}")
	public New_EditTaskPage selectDueDate(String month, String date) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.SelectDateButton.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		while(!(getDriver().findElement(By.xpath($("New_EditTaskPage.CurrentVisibleMonth.xpath"))).getText().equalsIgnoreCase(month))) {
			getDriver().findElement(By.xpath($("New_EditTaskPage.NextMonthButton.xpath"))).click();
		}
		getDriver().findElement(By.xpath("//span[@class='slds-day' and text()='"+date+"']")).click();
		return this;
	}
	@And("Select the {string} in Assigned to field")
	public New_EditTaskPage selectAssignedToInFollowupEvent(String assignedTo) {
		getDriver().findElement(By.xpath($("New_EditTaskPage.DeleteExistingAssignedTo.xpath"))).click();
		getDriver().findElement(By.xpath($("New_EditTaskPage.AssignedToNameSearchBox.xpath"))).click();
		getDriver().findElement(By.xpath("//div[@title='"+assignedTo+"']")).click();
		return this;
	}
	@And("I Select the {string},{string},{string} in Start date and Time")
	public New_EditTaskPage selectStartDateAndTime(String month, String date, String time) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.StartDateSelectDateButton.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		while(!(getDriver().findElement(By.xpath($("New_EditTaskPage.CurrentVisibleMonth.xpath"))).getText().equalsIgnoreCase(month))) {
			getDriver().findElement(By.xpath($("New_EditTaskPage.NextMonthButton.xpath"))).click();
		}
		getDriver().findElement(By.xpath("//span[@class='slds-day' and text()='"+date+"']")).click();
		el = getDriver().findElement(By.xpath($("New_EditTaskPage.StartTimeButton.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+time+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("I Select the {string},{string},{string} in End date and Time")
	public New_EditTaskPage selecEndDateAndTime(String month, String date, String time) {
		WebElement el = getDriver().findElement(By.xpath($("New_EditTaskPage.EndDateSelectDateButton.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		while(!(getDriver().findElement(By.xpath($("New_EditTaskPage.CurrentVisibleMonth.xpath"))).getText().equalsIgnoreCase(month))) {
			getDriver().findElement(By.xpath($("New_EditTaskPage.NextMonthButton.xpath"))).click();
		}
		getDriver().findElement(By.xpath("//span[@class='slds-day' and text()='"+date+"']")).click();
		el = getDriver().findElement(By.xpath($("New_EditTaskPage.EndTimeButton.xpath")));
		getJSExecutor().executeScript("arguments[0].click();", el);
		el = getDriver().findElement(By.xpath("//span[@title='"+time+"']"));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}

}
