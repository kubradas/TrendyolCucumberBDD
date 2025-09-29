Feature: Sort products

@SortProducts
Scenario Outline: Search and sort products
  Given I am on the homepage
  When I search for "pant" and select actual name of category
  And I sort products by "<SortType>"
  Then products should be displayed in "<SortType>" order

  Examples:
    | SortType               |
    | Önerilen               |
    | En düşük fiyat         |
    | En yüksek fiyat        |
    | En çok satan           |
    | En favoriler           |
    | En yeniler             |
    | En çok değerlendirilen |