Feature: Steam feature

  Scenario: Test steam shop
    Given I launch application
    When I open action games page
    Then Action games page has opened
    When I choose top sellers tab on Action game page
      And I open maximal discount game page and save this data in 'gameData'
    Then Game data obtained in previous step corresponds to the displayed
    When I go to install steam page
    Then Installation page has opened
    When I install steam
    Then File appeared in resources folder