Feature: Check wheel picker sample option
  Background: open mobile application
    Given Start application

  Scenario: Start the application, click login button, wheel picker sample option
    When Login
    And Open Wheel Picker Sample Screen
    Then Check Wheel Picker option