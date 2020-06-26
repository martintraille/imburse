@WIP
Feature: Create an order with validation checks

  As an API user
  I want to be able to create an order with validation checks
  So that the order can be correctly processed


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token


  Scenario Outline: create an order with an invalid order reference
    Given an order with an order reference <order reference>
    When a 'post' API call is made to the 'Create Order' endpoint
    Then a <response code number> response code is returned
    And the error response will show <error message>
    Examples:
      | Scenario           | order reference | response code number | error message           |
      | No order reference | ""              | 400                  | "ORDER_REF_IS_REQUIRED" |

  Scenario: Acceptable characters in an order reference
    Given an order with an order reference 'RaNdOmAlPhANuMeRiC._-'
    When a 'post' API call is made to the 'Create Order' endpoint
    Then a 202 response code is returned
    And a 'HTTP/1.1 202 Accepted' response message is returned




