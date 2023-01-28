Feature: As a user, I want to look for home page

  Scenario: verify search results for product
    Given I open home page
    When I search product
    Then I found search results