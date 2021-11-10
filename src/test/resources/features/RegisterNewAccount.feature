Feature: Create new account

  Scenario: Should show account after successful creation
    Given I'm on the VGP Shop homepage
    When I create a new account with username "joostva12", mailaddress "joostva12@gmail.com" and with password "polteqisgeweldig12."
    Then I should see my new username "joostva12" appear on top of the page