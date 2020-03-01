Feature: Regsiter user for demo site
Scenario: User should be able to register to demo site
Given User should be on Demo home page
When User enters following details
  | Labels                 | Values              | 
	| First Name             | Prajakta            |
  | Last Name	             |Tanelwar             | 
  | Adress                 |Wagholi			         |
  | email	                 |test@test.com        |
  | Phone                  |123456789            |
	        
Then User should be able to register demo site