
Feature: Obtain Bearer Token

  As an user of the imburse platform
  I want to be able to be authenticated
  So that I can use the platform as an authenticated user

  Scenario: Should be able to get bearer token from '/v1/identity/hmac' endpoint
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the '/v1/identity/hmac' endpoint
    Then he receives a bearer token

