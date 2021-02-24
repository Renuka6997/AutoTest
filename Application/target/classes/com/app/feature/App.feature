Feature: Automation practice Application

Scenario: Check the user is able to add and purchase the product from the cart
Given User is able to access the url of the application
When User clicks on sign in button
Then User should be able to create an account by entering firstname and lastname
| Riya | B |
Then User should be able to register by adding address
And User should be able to add the product to the cart
Then User should be able to purchase the product