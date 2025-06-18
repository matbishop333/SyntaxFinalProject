@ui @addemployee
Feature: Add Employee

  Background:
    Given the user is logged in with valid credentials

  @regression
  Scenario: Admin adds a new employee without providing a unique id
    Given User navigates to the PIM
    And the user clicks on Add button
    And enters the employee's first name "John" and last name "Doe"
    And the user clicks on Save button
    Then the user will be taken to the employee personal details page

    @uniquid
    Scenario: Admin adds a new employee with a unique id
    Given User navigates to the PIM
    And the user clicks on Add button
    And enters the employee's first name "Daryl" and last name "Adams"
    And enters a unique employee id "53421363"
    And the user clicks on Save button
    And the user will be taken to the employee personal details page and sees the employee id "53421363"
    Then the employee with ID "53421363" should be present in the database