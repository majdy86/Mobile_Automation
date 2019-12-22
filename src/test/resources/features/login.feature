@login
Feature: Login Api

  Scenario Outline: login with valid executor
    Given the user navigate to Login Page
    And fill the username field with a valid executor email <username>
    And fill the password field with a valid executor password <password>
    When the user clicks on sign in button
    Then the user should be redirected to projects list page
    Examples:
    |username|password|
    |majdi.executor.amal.pm@gmail.com|123456|
