Feature: Task Feature for Chrome

@Functional
Scenario Outline: Create New Task

Given Enter Username as "<username>"
And Enter Password as "<password>"
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Click Content Tab
And Click ViewAll under Todays Task
And Click New Task in Contents Page

When I Select Assigned To as "<assignedTo>"
And I Select subject as "<subject>"
And I select priority as "<priority>"
And I select status as "<status>"
And I select Name type as "<namedropdown>" and select name as "<name>"
And I select RelatedTo Dropdown as "<relatedtodropdown>"
And Add New relation
And I add a New Product as "<productname>"
And Click Save in Product Page
And Click Save in Task Page

Then Verify "<subject>" is displaying in ToastMessage





Examples:
|username              |password       |assignedTo    |subject|priority|status     |namedropdown|name       |relatedtodropdown|productname|
|fullstack@testleaf.com|SelBootcamp$123|Derrick Dsouza|Email  |High    |In Progress|Contacts    |Sayoni Dave|Products         |testproduct|


