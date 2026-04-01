Feature: Consultar mascota por estado

  Scenario:
    * def idMascota = __arg.idMascota
    * def estado = __arg.estado
    * def nombre = __arg.nombre

    Given path 'pet', 'findByStatus'
    And param status = estado
    When method get
    Then status 200

    * def filtradas = karate.filter(response, function(x){ return x.id == idMascota })

    And match filtradas == '#[1]'
    And match filtradas[0].id == idMascota
    And match filtradas[0].name == nombre
    And match filtradas[0].status == estado