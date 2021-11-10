Feature: Show username when logging in
  As a user of the VGP shop
  I want te be able to see my name when I log in
  So that I can verify that I correctly logged in

  Scenario: When logging in the username should be shown
    Given I'm on the VGP Shop homepage
    When I log in with valid credentials
    Then I should see my username appear on top of the page