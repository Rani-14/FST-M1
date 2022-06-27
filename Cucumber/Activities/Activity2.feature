@activity2

Feature: "Login Test"

  @FunctionalTest
  Scenario: "Testing Login"
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And Close the browser window