Feature: Add Multiple Items To Shopping Cart

  Scenario: Add Multiple Items To Shopping Cart (with parameters)
    Given I'm on the VGP Shop homepage
    When I go to the "SHOP" page
    And I go to the "Hoodie with zipper" detail page
    And I increase the quantity to 4
    And I add the product to the cart
    Then I should get a conformation that the product is added to the shopping cart
    And the conformation shows quantity is 4