Feature: Links On click 
Scenario: Verify links on home page
Given I launch url on publish environment
And I fetch current curl 
And I click on logo
Then I validate Navigation for links on publish envirnoment
