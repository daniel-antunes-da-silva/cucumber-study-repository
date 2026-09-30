Feature: Search and Place the order for Products

  Scenario: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched with Shortname "Tom" and extrated actual name of product
    Then user searched for same shortname in offers page to check if product exist
