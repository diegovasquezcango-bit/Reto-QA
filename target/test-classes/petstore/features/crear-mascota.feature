Feature: Crear mascota

  Scenario:
    * def mascota = __arg.mascota

    Given path 'pet'
    And request mascota
    When method post
    Then status 200

    And match response.id == mascota.id
    And match response.name == mascota.name
    And match response.status == mascota.status

    * def resultado = response