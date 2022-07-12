Feature: Add to Cart

  Scenario: Add to Cart test

    Given I add 4 random items to cart
    When I view my cart
    Then I find total 4 items listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item
    Then I find total 3 items listed in my cart
