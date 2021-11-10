Feature: Re-use steps

  Scenario: It should be possible to log in when re-using steps
    Given I'm on the VGP shop logged in as "USER" with password "PASSWORD"
    Then I see my user name "MyUsername" appear on top of the page