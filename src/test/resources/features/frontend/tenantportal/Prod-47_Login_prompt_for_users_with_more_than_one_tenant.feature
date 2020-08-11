Feature: Prod-47 - Login prompt for users with more than one tenant

  @PROD-47
  Scenario: Tenant list is displayed for users belonging to more than one tenant
    Given 'Worf' has an account with two tenants
    When he logs into the tenant portal
    Then he is presented with a list of the tenants he can access


  @PROD-47 @PROD-102 @INP
  Scenario: Tenant list is not displayed for users belonging to more than one tenant
    Given 'Paul' has an account with one tenant
    When he logs into the tenant portal using his tenant portal credentials
    Then he is automatically routed to the tenant landing page

