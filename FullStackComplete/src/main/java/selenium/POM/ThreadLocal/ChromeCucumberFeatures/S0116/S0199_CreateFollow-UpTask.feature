Feature: Task Feature for Chrome

@Functional @Smoke @SIT @UAT
Scenario Outline: Create Follow-Up Task For an Existing Task

Given Enter Username as "<username>"
And Enter Password as "<password>"
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Click Content Tab
And Click ViewAll under Todays Task

When Enter Search Key as "<subject>"
And Click the "<subject>" for "Followup Task"
And Select the "<assignedTo>" in Assigned to field
And I Select subject as "<newsubject>"
And I select Name type as "<namedropdown>" and select name as "<name>"
And I select RelatedTo Dropdown as "<relatedtodropdown>" 
And I select the existing "<product>" from dropdown
And I select priority as "<priority>"
And I select status as "<status>"
And Click Save in Task Page

Then Verify "<newsubject>" is displaying in ToastMessage



Examples:
|username              |password       |subject|newsubject|assignedTo    |namedropdown|name                  |relatedtodropdown|product    |priority|status     |
|fullstack@testleaf.com|SelBootcamp$123|Email  |Call      |Derrick Dsouza|Contacts    |Velmurugan Subramanian|Products         |testproduct|High    |In Progress|


