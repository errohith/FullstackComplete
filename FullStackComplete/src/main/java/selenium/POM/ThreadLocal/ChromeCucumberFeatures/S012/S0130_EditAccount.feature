Feature: Account Feature for Chrome

@Smoke
Scenario Outline: Edit Account Functionality

Given Enter Username as <username>
And Enter Password as <password>
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Enter Search Key
And Click Sales
And Click Accounts Tab

When Enter Search Key as <accountname>
And Click the <accountname> for Edit
And Select Type as <type>
And Select Industry as <industry>
And Enter Billing Address as <billingaddress>
And Enter Shipping Address as <shippingaddress>
And Select Priority as <priority>
And Select SLA as <sla>
And Select Active as <active>
And Enter Phone Number as <phonenumber>
And Select Oppurtunity as <oppurtunity>
And Click Save

Then Verify Account <accountname> is Edited
And Verify Phone Number <phonenumber> is populated correctly

Examples:
|username                |password         |accountname      |type                |industry      |billingaddress                                       |shippingaddress                                       |priority  |sla       |active  |phonenumber  |oppurtunity  |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"David William"  |"Technology Partner"|"Engineering" |"Test Billing Street,Chengalpet,TamilNadu,600073,IND"|"Test Shipping Street,Chengalpet,TamilNadu,600073,IND"|"Medium"  |"Platinum"|"No"    |"66953201"   |"Maybe"      |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Frank Jones"    |"Customer - Channel"|"Electronics" |"Test Billing Street,Chennai,TamilNadu,66584,IND"    |"Test Shipping Street,Chennai,TamilNadu,66584,IND"    |"Low"     |"Silver"  |"No"    |"22953021"   |"No"         |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Chris Kong"     |"Customer - Direct" |"Construction"|"Test Billing Street,Madurai,TamilNadu,68541,IND"    |"Test Shipping Street,Madurai,TamilNadu,68541,IND"    |"High"    |"Gold"    |"Yes"   |"55452012"   |"Yes"        |
