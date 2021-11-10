Feature: Receive confirmation when adding to cart
  As a user of the web-shop
  I want to see a conformation when I add products to my shopping cart
  So that I know I added the right product

  @smoke
  Scenario: Add item to shopping cart
    Given I'm on the VGP Shop homepage
    When I go to the shop
    And I go to the Hoodie with logo detail page
    And I add the Hoodie with logo to the cart
    Then I should get a conformation that the product is added to the shopping cart
    But I should not be taken directly to my shopping cart

    