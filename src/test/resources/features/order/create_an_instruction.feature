Feature: Create an Instruction

  As a Imburse user
  I want to be able to create an instruction
  So that an order can be updated with an instruction

  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token

  Scenario: Create an Instruction on an existing order via the /v1​/order-management​/{orderRef}​/instruction endpoint
    Given an existing order is created with no instruction
    When a 'post' API call is made to the 'Create Instruction' endpoint
    Then the instruction has been created successfully

