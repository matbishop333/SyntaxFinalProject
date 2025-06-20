@api @tokencreation
  Feature: As a tester,I want to validate that the API for generating an authentication token
    functions correctly,So that a user can receive a token to perform subsequent actions,
    such as creating or modifying employee records

  @smoke
    Scenario: Validate API for generating an authentication token
        When I send a POST request to generate an authentication token with valid credentials
        Then the status code should be 200 or 201
        And the response contains the key "token"