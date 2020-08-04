
Feature: Create an Instruction

  As a Imburse user
  I want to be able to create an instruction
  So that an order can be updated with an instruction

  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the 'v1' '/identity/hmac' endpoint
    Then he receives a bearer token

  Scenario: HAPPY PATH - Create an Instruction on an existing order
    Given an 'order with no instruction'
    And a 'post' API call is made to the 'v1' 'Create Order' endpoint
    And the order is successfully created
    And an 'Instruction is created'
    When a 'post' API call is made to the 'v1' 'Create Instruction' endpoint
    Then the instruction has been created successfully

# TO IMPLEMENTa
#    Scenario: Instruction reference is mandatory
#      Given an 'existing order with no instruction'
#      And an 'instruction is created with an instruction reference of' ""
#      When a refactored 'post' API call is made to the 'Create Instruction' endpoint
#      Then a 400 response code is returned
#      And the error response will show "SOME ERROR"

