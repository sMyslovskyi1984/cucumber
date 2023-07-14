Feature: Check general sample list
  Background: open mobile application
    Given Start application

    Scenario: Start the application, click login button, check general sample list
    When Login
    Then Assert actual list with expected list