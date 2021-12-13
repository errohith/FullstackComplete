Feature: Account Feature for Chrome

@SIT
Scenario Outline: Delete Account Functionality

Given Enter Username as <username>
And Enter Password as <password>
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Enter Search Key
And Click Sales
And Click Accounts Tab

When Enter Search Key as <accountname>
And Click Delete the Account for <accountname>
Then Verify the Toast Message for the deleted account <accountname>
And Verify <accountname> is deleted

Examples:
|username                |password         |accountname    |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"David William"|
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Frank Jones"  |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Chris Kong"   |