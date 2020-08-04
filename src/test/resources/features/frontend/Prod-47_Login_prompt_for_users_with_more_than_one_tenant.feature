Feature: Prod-47 - Login prompt for users with more than one tenant

  @MARTIN
  Scenario: Users with two tenants
    Given 'Worf' has an account with two tenants
    When he logs into the tenant portal
    Then he is presented with a list of the tenants he can access

  @MARTIN
  Scenario: Users with a single tenant
    Given 'Paul' has an account with one tenant
    When he logs into the tenant portal
    Then he is automatically routed to the tenant landing page

