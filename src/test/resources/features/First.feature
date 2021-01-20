Feature: Login Feature

Background:
    Given User is on the Initial page
    Then User verifies the title of the page
    And User hovers over the account section and clicks on it
    Then Two options Register and Logi should get displayed to the user
    When User clicks on the login option
    Then User should landed on the login page
    
@initial
 Scenario: To verify Login functionality
 	Given User is already on the login page
 	When User clicks on login button without any credentials
 	Then A Warning Message should get displayed
 	When user enters the valid username and password 
 	And User clicks on login button
 	Then User lands on the home page
 	