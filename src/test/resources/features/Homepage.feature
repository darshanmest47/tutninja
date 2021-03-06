Feature: Home page features and Scenarios

Background:
    Given User is already logged into the application
    Given User is already present on the home page
 
# 27-01-2021 @Darshanmesta
@add
Scenario: To verify the Add to cart functionality

		When User hovers over the Desktops tab and clicks on it
		Then A list should get displayed containing options pc and mac
		When User clicks on Show All Desktops option
		Then Desktops page should get displayed to the User
		And User must be able to see HP LP3065 laptop
		When User clicks on addto cart button of HP Laptop
		Then HP laptop page should get displayed
		And  User must be able to change the qty and enter qty as ex:2
		When User clicks on Add to cart button
		Then User must be able to see a success message
		And User must be able to see the qty entered by him in the cart with respecive amount
		When User clicks on logout button then user should be logged out successfully

# 27-01-2021	@Darshanmesta	
@remove		
Scenario: To Remove items from cart
  		
  		Then User clicks on the cart button
  		And User clicks on Remove Button if any item is available
  		Then User Verifies if item is removed correctly
  		When User clicks on logout button then user should be logged out successfully
		
		
		
		