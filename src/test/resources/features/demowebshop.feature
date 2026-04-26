@Regression
Feature: Demo Web Shop E-commerce Testing

  Background: User opens the website
    Given User is on the Demo Web Shop home page

  Scenario: Register, Login and Place Order for Computer
    When User navigates to registration page
    And User registers with new credentials
    Then User should see registration success message

    When User logs out
    And User logs in with registered credentials
    Then User should be logged in successfully

    When User navigates to Computers category
    And User selects Building Computers
    And User adds a computer to cart
    Then User should see item added to cart

    When User proceeds to checkout
    And User fills billing and shipping information
    And User places the order
    Then User should see order confirmation