Feature: login

  Scenario: User login with valid credential
    Given user open browser
    And user open url
    And user input username
    And user input password
    When user click login button
    Then user redirected to homepage

    Scenario: User login with invalid credential
      Given user open browser
      And user open url
      And user input username
      And user input invalid password
      When user click login button
      Then user see error message