Feature: As a user, I want to look for home page

  Scenario: Verify title is correct
    Given I open home page
    Then I see title as "Amazon.in : 4K TV"

  Scenario: verify search results for product
    Given I open home page
    When I search product