Feature: logout

  Scenario: user logout from website
    Given user open url via browser
    And user input valid username
    And user input valid password
    When user click login
    Then user redirected to homepage and menu
    When user click menu button
    And user click logout button
    Then user back to login page