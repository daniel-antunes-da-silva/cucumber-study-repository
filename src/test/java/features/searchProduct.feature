Feature: Search and Place the order for Products

  Scenario: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched with shortname "Tom" and extracted actual name of product
    And user searched for shortname "Tom" in offers page to check if product exist
    Then the product name at the offer page is the same in the landing page
