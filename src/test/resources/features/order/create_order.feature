Feature: Create an Order

  As a Imburse user
  I want to be able to create an order without instruction
  So that Instructions can be added later


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token

  Scenario: HAPPY PATH - create an order without instruction
    Given an 'order with no instruction'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then the order is successfully created

  Scenario: HAPPY PATH - create an order with an instruction
    Given an 'order with an instruction'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then the order is successfully created

  Scenario: HAPPY PATH - order reference can contain (.dot) -(dash) _(underscore)
    Given an 'order with an alphanumeric order reference of' 'RaNdOmAlPhANuMeRiC._-'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  Scenario: HAPPY PATH - order reference can be up to 50 characters
    Given an 'order with an order reference of 50 alphanumeric characters'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  Scenario: HAPPY PATH - Order can contain up to 100 instructions only
    Given an 'order containing 100 instructions'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  Scenario: NEGATIVE PATH - customer reference is mandatory
    Given an 'order with an order reference of' ""
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_REF_IS_REQUIRED"

  Scenario: NEGATIVE PATH - customer reference cannot be longer than 50 characters
    Given an 'order with an order reference of 51 characters:' 'tqT39fIK8oHlTavsxe5lxFOqlvU51CYXOgsNjv4FQGtqDtr6o_Q'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_REF_LENGTH_OUT_OF_RANGE"

  Scenario: NEGATIVE PATH - order reference must be unique and cannot be reused
    Given an 'order with an instruction'
    And a refactored 'post' API call is made to the 'Create Order' endpoint
    And the order is successfully created
    When an 'order has a duplicate order reference'
    And a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_ALREADY_EXISTS"

  @BUGFOUND
  Scenario: NEGATIVE PATH - Order metadata value cannot be over 100 characters
    Given an 'order with metadata value of 101 characters'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "SOME ERROR"

  @BUGFOUND
  Scenario: NEGATIVE PATH - Order cannot contain more than 101 instructions
    Given an 'order containing 101 instructions'
    When a refactored 'post' API call is made to the 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "SOME ERROR"
