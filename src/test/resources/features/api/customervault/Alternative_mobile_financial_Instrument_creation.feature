Feature: Prod-36 - Mobile phone as a financial instrument


  Background:
    Given Picard has a valid accountId and tenantID
    When he attempts to authenticate via the 'v1' '/identity/hmac' endpoint
    Then he receives a bearer token

  @PROD-36
  Scenario: PROD-36 Alternative:Mobile financial instrument creation for UK mobile
    Given a country code of '44' and a valid national mobile phone number of '07738620344'
    When a Post API call is made to the 'v1' 'Create financial instrument mobile' endpoint
    Then a 201 response code is returned
    And the response should contain the financial instrument id '0bce880a-6f5b-88c0-e3ff-8668d526d51c'

  @PROD-36
  Scenario: PROD-36 Alternative:Mobile financial instrument creation for Portugal mobile
    Given a country code of '351' and a valid national mobile phone number of '915236722'
    When a Post API call is made to the 'v1' 'Create financial instrument mobile' endpoint
    Then a 201 response code is returned
    And the response should contain the financial instrument id 'f8e02d4d-ce82-a3d9-0f2f-425076d16e99'