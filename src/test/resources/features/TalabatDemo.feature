Feature: TalabatDemo

  Scenario Outline: As a user I want to login with my talabat account
    Given a user on country page
    And choose Jordan as a country
    And clicks on login button
    And fill the email field with an existing email address <username>
    And fill the password field with a valid password <password>
    When the user clicks on login button
    Then the user should redirected to home page
    And the side menu should displays the user's display name <displayname>
    Examples:
      |username|password|displayname|
      |kebewam763@mytrumail.com|123456|Majdi Suleiman|