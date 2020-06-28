#Feature: Create an order with instruction
#
#  As an API user
#  I want to be able to create an order with an instruction
#  So that I can transact on the Imburse platform
#
#
#  Background:
#    Given Picard has a valid accountId and tenantID
#    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
#    Then he receives a bearer token
#
#
#  Scenario: create an order with instruction via the /v1/order-management endpoint
#    Given an order with an instruction
#    When a 'post' API call is made to the 'Create Order' endpoint
#    Then the order is successfully created
#
