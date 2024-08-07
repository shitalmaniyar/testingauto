Feature: header section items

Scenario: verify header section items displyed
#When I launch url2
Then I get list of header menu items 
	
Scenario: verify empty cart 
#When I launch url
And click on cart menu icon 
Then empty cart icon opens a cart link with message

Scenario: verify Wishlist Is opening login page
#When I launched url
And I click on wishlist icon
Then login is asked on wishlist redirectional link   

