@ui @employeecredentials
  Feature: As an admin, I want to be able to add employee credentials

    Background:
        Given the user is logged in with valid credentials

      @smoke
      Scenario: Admin adds a new employee and provides a username and password
        Given User navigates to the PIM
        And the user clicks on Add button
        And enters the employee's first name "John" and last name "Doe"
        And clicks on the create login details checkbox
        And enters a username and password
        And the user clicks on Save button
        Then the user will be taken to the employee personal details page
