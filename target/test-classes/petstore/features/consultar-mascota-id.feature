Feature: Consultar mascota por ID

  Scenario:
    * def idMascota = __arg.idMascota
    * def nombre = __arg.nombre
    * def estado = __arg.estado

    Given path 'pet', idMascota
    When method get
    Then status 200

    And match response.id == idMascota
    And match response.name == nombre
    And match response.status == estado