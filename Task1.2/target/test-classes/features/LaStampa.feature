Feature: sito La Stampa
#feature: obiettivo del gruppo di test

  Scenario: navigare sul sito La Stampa
    Given L'utente naviga sul sito La Stampa
    And I open full screen
    #Then I Wait 5 Seconds
    And I click button
    #And I Wait 5 Seconds
    #Then I Wait 20 Seconds
    And I scroll to bottom
    And I Wait 2 Seconds
    And I scroll to top
    And I click cerca button
    Then I write Milano on research bar
    




