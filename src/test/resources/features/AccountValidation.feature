Feature: Perform a login and check validation
@mail
  Scenario Outline: Log in should pass or not
    Given I'm at to the VGP shop-page
    When I login with "<username>" and "<password>"
    Then My Account will be "<validity>"

    Examples:
    |username                    |password            |validity  |
    |trainee6@polteq-testing.com |1AmAPolteqTrainee6  |invalid   |
    |tester@polteq-testing       |1!QazXsw2@          |invalid   |
    |tester@polteq-testing.com   |1!QazXsw2@          |valid     |