Feature: ICA values into xlxs file

#https://www.ica.se/erbjudanden/ica-kvantum-backebol-1037001/
  @searchnewphone
  Scenario: Retrive all the products details
    When user get all the details
    And user search the product
    Then verify the serach page
    And store the phone and price details in xlxs file
