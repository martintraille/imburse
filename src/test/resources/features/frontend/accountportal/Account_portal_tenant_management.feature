Feature: Account Portal Tenant Management

@INP
  Scenario: Create a Tenant
    Given 'Picard' has logged into the account portal
    And there are no active tenants on his account
    When he creates a Tenant with valid details
    Then that tenant is created successfully