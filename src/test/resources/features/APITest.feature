Feature: Verify Coindesk API

  @APISmoke
  Scenario: Validate BPI data and descriptions
    Given I send a GET request to the endpoint
    Then the status code should be 200
    And the response should contain BPIs "USD", "GBP", and "EUR"
    And "GBP" description should be "British Pound Sterling"
