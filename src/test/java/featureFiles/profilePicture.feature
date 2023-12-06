Feature: Profile Picture Management

  Scenario: Upload Profile Picture
    Given the user is logged into their account
    When the user uploads a profile picture
    Then the profile picture is successfully uploaded
    And the user deletes their profile picture
    Then the profile picture is successfully deleted
