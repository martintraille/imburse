Feature: Logging in to the Imburse Account Platform

  Scenario: Logging into the Imburse Account portal
  Given 'Picard' is on the Imburse Account login page
  When he submits his login credentials
  Then he is logged in successfully
