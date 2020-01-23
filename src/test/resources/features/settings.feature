@settings
Feature: Settings

  @Positive @Smoke
  Scenario Outline: As an executor i want to change my first name
    Given the user navigate to Settings Page <username> <password>
    And clicks on general info from the settings list
    When the user change the first name
    And clicks on save button
    And refresh the current page
    Then the first name should be changed
    Examples:
      |username|password|
      |majdi.executor.amal.pm@gmail.com|123456|