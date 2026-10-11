Feature: Search and Place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched with shortname "<productShortname>" and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then user proceeds to checkout and validate the "<productShortname>" items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | productShortname |
      | Tom              |
      | Beet             |