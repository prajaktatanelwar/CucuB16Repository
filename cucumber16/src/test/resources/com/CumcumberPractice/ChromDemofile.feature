Feature: To check the demo form
As a user, I want to enter details in demo form
Scenario: Validate the demo site with details
Given User is on main page of demo site
When User enters following details
  | Labels                 | Values              | 
	| First Name             | Prajakta            |
	| Gender                 | FeMale              |
	|  Hobbies					     |Hockey						   |
	| Languages              | English		   		   |
	| Skill                  | Java		   		       |
	| Country                | India               |
	| Birthdate              | 14                  |
Then user should I able to submit form.