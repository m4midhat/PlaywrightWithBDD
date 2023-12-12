Feature: Orange HRM Login
  Scenario: Successful log in verification on OrangeHRM
    Given User opens the required browser "firefox"
    And User navigates to the Orange HRM website
    And User provides the correct credentials "Admin" and "admin123"
    And User clicks the login button
    Then User should be able to view the dashboard