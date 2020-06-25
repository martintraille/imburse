Feature: Create an order with validation checks

  As an API user
  I want to be able to create an order with validation checks
  So that the order can be correctly processed


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token


  Scenario Outline: create an order with an invalid order reference

    Given an order with an invalid <order reference>
    When a 'post' API call is made to the 'Create Order' endpoint
    Then the response will show <error message>
    Examples:
      | Scenario           | order reference | error message |
      | No order reference | ""              | "wdflwfkmwef"   |
