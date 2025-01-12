Feature: eBay UI Test
  @UISmoke
  Scenario: Add item to cart
    Given I open the eBay homepage
    When I search for "book"
    And I select the first suggestion
    And I add the first item to the cart
    Then I should see one item in the cart
