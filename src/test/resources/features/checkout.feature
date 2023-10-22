Feature: checkout

  Scenario: checkout process
    Given user open url from browser
    And user input the valid username
    And user input the valid password
    When user tap login
    Then user see the home page
    When user add wanted item to cart
    Then user see the number badge in cart icon
    When user click cart icon
    Then user redirected to your cart page
    When user click checkout button
    Then user redirected to checkout information page
    And user input firstname
    And user input lastname
    And user input zip code
    When user click continue button
    Then user redirected to checkout overview page
    When user click finish button
    Then user redirected to checkout complete page
