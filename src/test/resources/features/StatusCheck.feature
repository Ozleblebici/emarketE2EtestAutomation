@emarket
Feature: eMarket test

  @db @orderStatus
  Scenario: Verify order status on db after UI changes
    Given User navigate to login page
    When Login as admin
    And Navigate to "admin/orders" module
    # TODO TASK!!!!
      # The dynamic changes depending on the order id on the way, that's why get the value in the 10th line from the UI first, then verify that it is a db!!!
    Then Verify that "3" order status is "on the way" in database
    And Change "3" order id's status to "complete" on UI
    Then Verify that "3" order status is "complete" in database
    #ROLLBACK STEP!!
    And Change "3" order id's status to "on the way" on UI
    Then Verify that "3" order status is "on the way" in database