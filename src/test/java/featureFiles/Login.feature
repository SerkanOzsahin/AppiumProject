Feature: Successful Login

  Scenario: Successful Login to the Campus application
    Given the user opens the Campus application
    When the user logs in with the username and password
    Then the user should successfully log into their account
