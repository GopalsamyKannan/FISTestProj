Feature: Verify Coindesk API

  @APISmoke
  Scenario: Validate BPI data and descriptions
    Given I send a GET request to "/v1/bpi/currentprice.json"
    Then I should get a 200 status code
    And the response should contain BPIs "USD", "GBP", and "EUR"
    And "GBP" description should be "British Pound Sterling"
