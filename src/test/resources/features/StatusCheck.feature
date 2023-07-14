@emarket
Feature: eMarket test

  @db @orderStatus
  Scenario: Verify order status on db after UI changes
    Given User navigate to login page
    When Login as admin
    And Navigate to "admin/orders" module
    # TASK!!!!
      # On the way order id ye gore dinamik degisiyor is bu sebep 10. satirdaki degeri once UIanda al gore db oldugunu dogrula!!!
    Then Verify that "3" order status is "on the way" in database
    And Change "3" order id's status to "complete" on UI
    Then Verify that "3" order status is "complete" in database