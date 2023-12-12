Feature: User should be able to go to My Info page and verify and update their Date of Birth field.
  Scenario: User successfully logs into the system, navigates to the my information page and update the DOB
    Given User is logged into the orangeHRM
    And User clicks on the MyInfo page
    And User updates the DOB
    And User presses button Save
    Then Updated DOB is displayed