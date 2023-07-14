Feature: Check vertical swipe sample option
  Background: open mobile application
    Given Start application

  Scenario: Start the application, click login button, check vertical swipe sample option
    When Login
    And Open Vertical Swipe Sample Screen
    Then Check vertical swiping option