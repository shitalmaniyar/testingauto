Feature: Count of items
Scenario: verify search item count match with expected count
#When I lauched browser
And search for procduct from searchbox and hit enter 
Then page navigates on product detail page
And I fetch perticular category count from checkbox  
And I click on  perticular category checkbox
Then verify fetched count matched with title count