@ui @login
  Feature: Login Feature

    Background:
        Given I am on the login page

      @smoke
    Scenario: Successful login with valid credentials
        When I enter a valid username
        And I enter a valid password
        And I click the login button
        Then I should be redirected to the dashboard page

        @failed
    Scenario: Invalid username
        When I enter an invalid username
        And I enter a valid password
        And I click the login button
        Then I should see an error message indicating invalid credentials

      Scenario: Invalid password
        When I enter a valid username
        And I enter an invalid password
        And I click the login button
        Then I should see an error message indicating invalid credentials