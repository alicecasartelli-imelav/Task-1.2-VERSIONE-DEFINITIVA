Feature: sito La Stampa
#feature: obiettivo del gruppo di test

  Scenario: navigare sul sito La Stampa
    Given L'utente naviga sul sito La Stampa
    And I open full screen
    And I click button
    And I scroll to bottom
    And I Wait 2 Seconds
    And I scroll to top
    And I click cerca button
    Then I write Milano on research bar





