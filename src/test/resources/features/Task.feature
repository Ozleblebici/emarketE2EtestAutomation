@emarket
Feature: eMarket test

  #   VERIFICATION with DB
  @dbOrderEmailVerify @db
  Scenario: Verify email address for given order id with DB
    Given User navigate to login page
    When Login as admin
    And Navigate to "admin/orders" module
# TODO Change order status via UI dropdown element
  # Then verify new status in DB related table!!


  # TODO 2 Navigate USER menu and DELETE given user
  # Then verify the user deleted on DB table!!


    # TODO 3 Navigate USER Profile and change the password (cover negative scenarios as well)
  # Then verify the user new password via db records!