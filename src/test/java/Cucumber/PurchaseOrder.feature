Feature: Purchase the order from ecommerce website

  Background:
  Given I landed on ecommerce page

   @Submitorder
  Scenario Outline: Positive Test For Submitting Order
    Given logged in with username <email> and password <password>
    When I add product <productname> to cart
    And Checkout<productname> and submit order
    Then "THANKYOU FOR THE ORDER." message displayed on confirmationpage

    Examples:
      | email                      | password | productname |
      | rahul.k.rawat786@gmail.com | 123456   | ZARA COAT 3 |