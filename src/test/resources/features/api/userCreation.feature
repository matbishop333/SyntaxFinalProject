@api @usercreation
  Feature: As a tester,I want to validate that the API for creating a new user account functions
    correctly,So that users can register successfully, and appropriate error messages are
    displayed when inputs are invalid

  @smoke
  Scenario: Successfully create a new user
    When I send a POST request to create a new user with name, email, and password
    Then the response status code should be 201 or 200
