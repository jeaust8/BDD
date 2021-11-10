Feature: Should fill in form

  Scenario: Should fill in form using datatable
    Given I'm on the contact page
    When I fill in the form with data from tables
    |Stay in park |Name | Emailaddress                | Subject   | Message                                     | Contact             |
    |Ja           |Joost| joostvanaartsen@gmail.com   | Klacht    | Ik heb last van het geluid van de vogels    | Klantenservice      |
    |Nee          |Henk | henkvanaartsen@gmail.com    | Doei      | Ik heb last van mensen                      | Klantenservice      |
    Then I should see a conformation message