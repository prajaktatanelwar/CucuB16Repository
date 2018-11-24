Feature: Check facebook login
Scenario:Login to facebook with valid creadentials

Scenario Outline: validate fb login page
Given User is on facebook login page
When "<user>" is entered as username
And "<pwd>" is entered as password
Then login should be successfull
Examples:
|user|pwd|
|user1|pwd1|
|user2|pwd2|
|user3|pwd3|