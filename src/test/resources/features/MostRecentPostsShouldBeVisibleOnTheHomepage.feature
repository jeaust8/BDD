Feature: The most recent posts should be visible on the homepage

  Scenario: The expected posts are visible
    Given I'm on the VGP Shop homepage
    Then the most recent posts should be visible
    |Title                        |
    |Nieuw in ons assortiment     |
    |Openingstijden herfstvakantie|
    |Welkom bezoekers!            |