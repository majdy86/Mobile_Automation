Feature: Signup

  Scenario: As a PM, I want to sign-up to TMS
    Given the user navigate to home page
    And click on Signup
    When the user select PM as a user type
    And click on Next
    And Fill the valid registration info
      | email           | autoUI@gmail.com  |
      | password        | 123456            |
      | confirmPassword | 123456            |
      | firstName       | Auto              |
      | lastName        | Auto              |
      | timeZone        | (UTC+03:00) Amman |






