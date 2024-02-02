@emarket
Feature: eMarket test

#  UI BASE VERIFICCATION
  @UIorderVerify
  Scenario: Verify email address for given order id with user input
    Given User navigate to login page
    When Login as admin
    And Navigate to "admin/orders" module
    Then Verify that "1" order email is "facetoface@gmail.com", order price is "404" usd


#    DB ile VERIFICATION
   @dbOrderEmailVerify @db
  Scenario: Verify email address for given order id with DB
    Given User navigate to login page
    When Login as admin
    And Navigate to "admin/orders" module
    Then Verify "1" order email with database record
    Then Verify "2" order email with database record
    Then Verify "3" order email with database record
    Then Verify "4" order email with database record
    Then Verify "5" order email with database record
