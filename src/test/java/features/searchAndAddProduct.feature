Feature: Search and add the first product to the cart

  @SearchAndAddProduct
  Scenario Outline: Search for a category and add the first product to the cart
    Given I am on the homepage
    When I search for <Name> and select actual name of category
    And I select the first product from the search results
    And I add the first product to the cart
    Then I should see the product in the cart
    Examples:
      | Name |
      | pant |
      | çan  |
      | göm  |