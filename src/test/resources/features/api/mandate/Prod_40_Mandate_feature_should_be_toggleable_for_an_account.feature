Feature: Prod-70 Mandate feature should be toggleable for an account

  As a imburse admin
  I want to be able to toggle the mandate service to be available for an account
  so that I can control what accounts can use it from a licensing perspective

  Scenario: Mandate enabled for all POST mandate REST endpoints
    Given 'Admin' has an account that has the mandate feature enabled
    When a POST API call is made to the 'v2' '/mandates' endpoint
    Then a 201 response code is returned


  Scenario: Mandate enabled for all GET Mandate REST endpoints
    Given 'Admin' has an account that has the mandate feature enabled
    When a GET API call is made to the 'v2' '/mandates' endpoint
    Then a 201 response code is returned

  @WORK
    Scenario: Mandate not enabled for all POST Mandate REST endpoints
    Given 'User' has an account that does not have the mandate feature enabled
      When a POST API call is made to the 'v2' '/mandates' endpoint
    Then I should not be able to access the mandates
    And a 405 response code is returned
    And the error response will show "SERVICE_UNAVAILABLE"

  Scenario: Mandate not enabled for all GET Mandate REST endpoints
    Given 'User' has an account that does not have the mandate feature enabled
    When a GET API call is made to the 'v2' '/mandates' endpoint
    Then I should not be able to access the mandates
    And a 405 response code is returned
    And the error response will show "SERVICE_UNAVAILABLE"

    Scenario: Portal user with mandate feature enabled on account
    Given an account that has the mandate feature enabled
    When I access the tenant
    Then I should be able to see the mandate navigation links

  Scenario: Portal user with mandate feature not enabled on account
      Given an account that does not have the mandate feature enabled
      When I access the tenant
      Then I should not be able to see the mandate navigation links
