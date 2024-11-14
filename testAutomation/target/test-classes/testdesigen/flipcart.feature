Feature: store in file search result

@searchnewphone
Scenario: Search functionality
  When user enter the product name "iphone"
  And user search the product
  Then verify the serach page
  And store the phone and price details in xlxs file

