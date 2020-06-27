@WIP
Feature: Create an order with validation checks

  As an API user
  I want to be able to create an order with validation checks
  So that the order can be correctly processed


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token


  Scenario Outline: Negative order reference tests
    Given an order with an order reference <order reference>
    When a 'post' API call is made to the 'Create Order' endpoint
    Then a <response code number> response code is returned
    And the error response will show <error message>
    Examples:
      | Scenario                                       | order reference                                       | response code number | error message                   |
      | Order reference is mandatory                   | ""                                                    | 400                  | "ORDER_REF_IS_REQUIRED"         |
      | Order reference cannot be longer than 50 chars | "tqT39fIK8oHlTavsxe5lxFOqlvU51CYXOgsNjv4FQGtqDtr6o_Q" | 400                  | "ORDER_REF_LENGTH_OUT_OF_RANGE" |


  Scenario: Order reference can contain (.dot) -(dash) _(underscore)
    Given an order with an order reference "RaNdOmAlPhANuMeRiC._-"
    When a 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned


  Scenario: 50 character order reference
    Given an order with a 50 character order reference
    When a 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned

    Scenario: Order reference must be unique and cannot be reused
      Given an order with an order reference "DuplicateOrderRef"
      And a 'post' API call is made to the 'Create Order' endpoint
      And a 202 response code is returned
      When we have an order with a "duplicate" order reference
      And a 'post' API call is made to the 'Create Order' endpoint
      Then a 400 response code is returned
      And the error response will show "ORDER_ALREADY_EXISTS"




