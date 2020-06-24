Feature: Create an order without instruction

  As a Imburse user
  I want to be able to create an order without instruction
  So that Instructions can be added later


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token

Scenario: create an order without instruction
  Given an order without an instruction
  When a 'post' API call is made to the 'Create Order' endpoint
  Then the order is successfully created



