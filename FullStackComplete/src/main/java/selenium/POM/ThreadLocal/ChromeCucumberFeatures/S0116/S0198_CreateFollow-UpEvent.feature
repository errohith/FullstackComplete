Feature: Task Feature for Chrome

@Functional @Smoke @SIT @UAT
Scenario Outline: Create Follow-Up Event For an Existing Task

Given Enter Username as "<username>"
And Enter Password as "<password>"
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Click Content Tab
And Click ViewAll under Todays Task

When Enter Search Key as "<subject>"
And Click the "<subject>" for "Followup Event"
And Select the "<assignedTo>" in Assigned to field
And I Select subject as "<newsubject>"
And I select Name type as "<namedropdown>" and select name as "<name>"
And I select RelatedTo Dropdown as "<relatedtodropdown>" 
And I select the existing "<product>" from dropdown
And I Select the "<startdate_month>","<startdate_day>","<startdate_time>" in Start date and Time
And I Select the "<enddate_month>","<enddate_day>","<enddate_time>" in End date and Time
And Click Save in Task Page

Then Verify "<newsubject>" is displaying in EventToastMessage



Examples:
|username              |password       |subject|newsubject|assignedTo    |namedropdown|name                  |startdate_month   |startdate_day|startdate_time|enddate_month   |enddate_day|enddate_time|relatedtodropdown|product    |
|fullstack@testleaf.com|SelBootcamp$123|Email  |Meeting   |Derrick Dsouza|Contacts    |Velmurugan Subramanian|December          |10           |8:30 AM       |December        |18         |5:00 PM     |Products         |testproduct|


