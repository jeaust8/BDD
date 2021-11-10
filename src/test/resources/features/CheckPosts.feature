Feature: Check posts

  Scenario: I want to check if I can get posts through RestAssured
    Given I'm on the VGP json page
    When I perform a get from "posts"
    Then I should get status "OK"