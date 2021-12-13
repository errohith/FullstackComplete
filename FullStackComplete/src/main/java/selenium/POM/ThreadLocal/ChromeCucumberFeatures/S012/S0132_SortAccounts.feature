Feature: Account Feature for Chrome

@UAT
Scenario Outline: Sort Accounts Functionality

Given Enter Username as <username>
And Enter Password as <password>
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Enter Search Key
And Click Sales
And Click Accounts Tab

When Click sorting button on Account column
Then Verify Sort Order

Examples:
|username                |password         |
|"fullstack@testleaf.com"|"SelBootcamp$123"|