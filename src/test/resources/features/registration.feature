@registration
Feature: Registration

Scenario: User is able to register
    Given User clicked on register button
    When User enters all valid personal info
    And User accepts privacy policy
    And User clicks on Continue registration button
    Then User is navigated to home page