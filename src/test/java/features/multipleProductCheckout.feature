Feature: Add product to cart and proceed to checkout

  @MultipleProductCheckout
  Scenario Outline: Add product to cart multiple times and proceed to checkout
    Given I am on the homepage
    When I search for <Name> and select actual name of category
    And I select the first product from the search results
    And I add the first product to the cart "3" times
    Then I proceed to checkout and see login & guest checkout options

    Examples:
      | Name |
      | pant |
      | bluz |
      | şort |