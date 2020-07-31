Feature: Create an Order

  As a Imburse user
  I want to be able to create an order without instruction
  So that Instructions can be added later


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the 'v1' '/identity/hmac' endpoint
    Then he receives a bearer token

  Scenario: Create an order without instruction
    Given an 'order with no instruction'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then the order is successfully created

  Scenario: Create an order with an instruction
    Given an 'order with an instruction'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then the order is successfully created

  Scenario: Order reference can contain (.dot) -(dash) _(underscore)
    Given an 'order with an alphanumeric order reference of' 'RaNdOmAlPhANuMeRiC._-'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  Scenario: Order reference can be up to 50 characters
    Given an 'order with an order reference of 50 alphanumeric characters'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  Scenario: Order can contain up to 100 instructions only
    Given an 'order with total number of instructions' '100'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  @MART
  Scenario: NEGATIVE PATH - Order cannot have duplicate metadata keys
    Given an 'order with duplicate metadata keys'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

  @BUGFOUND
  Scenario: Order metadata key can be up to 100 characters
    Given an 'order with metadata key length of' '100'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned


  Scenario: NEGATIVE PATH - customer reference is mandatory
    Given an 'order with an order reference of' ""
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_REF_IS_REQUIRED"

  Scenario: NEGATIVE PATH - customer reference cannot be longer than 50 characters
    Given an 'order with an order reference of 51 characters:' 'tqT39fIK8oHlTavsxe5lxFOqlvU51CYXOgsNjv4FQGtqDtr6o_Q'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_REF_LENGTH_OUT_OF_RANGE"

  Scenario: NEGATIVE PATH - order reference must be unique and cannot be reused
    Given an 'order with an instruction'
    And a 'post' API call is made to the 'v1' 'Create Order' endpoint
    And the order is successfully created
    When an 'order has a duplicate order reference'
    And a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "ORDER_ALREADY_EXISTS"

  @BUGFOUND
  Scenario: NEGATIVE PATH - Order metadata value cannot be over 100 characters
    Given an 'order with metadata value length of' '101'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "SOME ERROR"

  @BUGFOUND
  Scenario: NEGATIVE PATH - Order cannot contain more than 100 instructions
    Given an 'order with total number of instructions' '101'
    When a 'post' API call is made to the 'v1' 'Create Order' endpoint
    Then a 400 response code is returned
    And the error response will show "SOME ERROR"



