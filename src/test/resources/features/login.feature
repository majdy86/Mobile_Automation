@login
Feature: Login

  @Positive @Smoke
  Scenario Outline: login with valid executor
    Given the user navigate to Login Page
    And fill the username field with a valid executor email <username>
    And fill the password field with a valid executor password <password>
    When the user clicks on sign in button
    Then the user should be redirected to projects list page
    Examples:
    |username|password|
    |majdi.executor.amal.pm@gmail.com|123456|

  @Positive
  Scenario Outline: login with valid executor using capital characters for the email
    Given the user navigate to Login Page
    And fill the username field with a valid executor email <username>
    And fill the password field with a valid executor password <password>
    When the user clicks on sign in button
    Then the user should be redirected to projects list page
    Examples:
      |username|password|
      |MAJDI.EXECUTOR.AMAL.PM@GMAIL.COM|123456|

  @Positive @Smoke
  Scenario Outline: login with valid project manager
    Given the user navigate to Login Page
    And fill the username field with a valid project manager email <username>
    And fill the password field with a valid project manager password <password>
    When the user clicks on sign in button
    Then the user should be redirected to projects list page
    Examples:
      |username|password|
      |amalureedmanager@gmail.com|123456|

  @Positive
  Scenario Outline: login with valid project manager using capital characters for the email
    Given the user navigate to Login Page
    And fill the username field with a valid project manager email <username>
    And fill the password field with a valid project manager password <password>
    When the user clicks on sign in button
    Then the user should be redirected to projects list page
    Examples:
      |username|password|
      |AMALUREEDMANAGER@GMAIL.COM|123456|

  @Negative
  Scenario Outline: login with a valid executor's email and invalid password, i should get an error
    Given the user navigate to Login Page
    And fill the username field with a valid executor email <username>
    And fill the password field with a invalid executor password <password>
    When the user clicks on sign in button
    Then the following error message should displays "These credentials do not match our records."
    Examples:
      |username|password|
      |majdi.executor.amal.pm@gmail.com|222222222|

  @Negative
  Scenario Outline: login with a valid project manager's email and invalid password, i should get an error
    Given the user navigate to Login Page
    And fill the username field with a valid project manager email <username>
    And fill the password field with a invalid project manager password <password>
    When the user clicks on sign in button
    Then the following error message should displays "These credentials do not match our records."
    Examples:
      |username|password|
      |amalureedmanager@gmail.com|222222222|

  @Negative
  Scenario Outline: as a user i should not be able to login with an empty username or password
    Given the user navigate to Login Page
    And fill the username field with a valid executor email <username>
    When the user clicks on sign in button
    Then the user should get a message that password is required
    Examples:
      |username|
      |majdi.executor.amal.pm@gmail.com|

  @Negative
  Scenario: as a user i should not be able to login with empty username and password
    Given the user navigate to Login Page
    When the user clicks on sign in button
    Then the user should get a message that username is required






