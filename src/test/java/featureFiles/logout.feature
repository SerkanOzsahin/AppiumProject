Feature: Logout Functionality

  Scenario: User should be able to log out
    Given The user is logged in
    When The user navigates to the Settings page in the Hamburger Menu
    And The user clicks on the Sign Out button
    Then The user is redirected to the login page
