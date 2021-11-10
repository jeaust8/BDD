Feature: Log in with parameters

  Scenario: When logging in the username should be shown
    Given I'm on the VGP Shop homepage
    When I login as "tester@polteq-testing.com" with password "1!QazXsw2@"
    Then I should see my username "TesterAtPolteqTesting" appear on top of the page