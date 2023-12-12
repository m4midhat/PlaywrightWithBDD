Feature: User log out
  Scenario: Logged in user is being log out
    Given User is already logged into Orange HRM
    And User clicks on profile drop down button
    And User clicks on logout link
    Then User is redirected to login page
