Feature: eBay UI Test
  @UISmoke
  Scenario: Add item to cart
    Given I navigate to "https://www.ebay.com"
    When I search for "book"
    And I select the first suggestion
    And I add the first item to the cart
    Then I should see one item in the cart
