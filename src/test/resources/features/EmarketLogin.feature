@emarket
Feature: eMarket test

  Scenario: Login
    Given User navigate to login page
    When Login as admin
    Then Navigate to "admin/orders" module

