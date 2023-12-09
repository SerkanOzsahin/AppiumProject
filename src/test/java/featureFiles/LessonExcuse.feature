Feature: Excuse Reporting

  Scenario: Reporting an Excuse for Unable to Attend Class

    Given The user has a scheduled class
    When The user unable to attend the class
    Then The user should be able to notify teachers and authorities
