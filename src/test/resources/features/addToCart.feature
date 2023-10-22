Feature: add to cart

  Scenario: add item to cart
    Given user open browser and url
    And user input a valid username
    And user input a valid password
    When user login
    Then user redirected to home page
    When user add desired item to cart
    Then user see number badge in cart icon
