Feature: As a user, I want to check cart details

  @cart-added
  Scenario: verify product added to cart
    Given user open home page
    When user login to application
    When user search product by name "4K TV"
    Then I found search results
    And user click on product
    And user click on add to cart
    #Then user verify product added message
    And user click on cart button
    Then user verify product added to cart

  @cart-remove
  Scenario: verify product deleted from the cart
    Given user open home page
    When user login to application
    And User click on cart link
    And user remove products from cart
    Then user verify products removed from cart
