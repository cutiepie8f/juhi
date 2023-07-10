Feature: Test Myntra website scenario
Scenario: Validate the order placed is successful 
Given User Open the chrome and start the application
When User searches the item "mobile case" in the search box
And  User Sort the product in low to high price
And  User Select the mobile case
And  User click on add to bag button and click on place order button
And I enter the valid mobile number and valid OTP
