Feature: Flujo de mascota en PetStore

  Background:
    * configure ssl = true
    * url urlBase
    * def utilidades = call read('classpath:petstore/utils/generador.js')

  Scenario Outline: Flujo completo de PetShop
    * def idMascota = utilidades.generarIdMascota()

    * def mascotaNueva =
      """
      {
    "id": #(idMascota),
    "category": {
    "id": 1,
    "name": "Perros"
    },
    "name": "<nombreInicial>",
    "photoUrls": [
    "https://example.com/mascota.jpg"
    ],
    "tags": [
    {
    "id": 1,
    "name": "prueba"
    }
    ],
    "status": "<estadoInicial>"
    }
    """

    Given path 'pet'
    And request mascotaNueva
    When method post
    Then status 200
    And match response.id == idMascota
    And match response.name == '<nombreInicial>'
    And match response.status == '<estadoInicial>'

    Given path 'pet', idMascota
    When method get
    Then status 200
    And match response.id == idMascota
    And match response.name == '<nombreInicial>'
    And match response.status == '<estadoInicial>'

    * def mascotaActualizada =
      """
      {
    "id": #(idMascota),
    "category": {
    "id": 1,
    "name": "Perros"
    },
    "name": "<nombreActualizado>",
    "photoUrls": [
    "https://example.com/mascota.jpg"
    ],
    "tags": [
    {
    "id": 1,
    "name": "prueba"
    }
    ],
    "status": "<estadoFinal>"
    }
    """

    Given path 'pet'
    And request mascotaActualizada
    When method put
    Then status 200
    And match response.id == idMascota
    And match response.name == '<nombreActualizado>'
    And match response.status == '<estadoFinal>'

    Given path 'pet', 'findByStatus'
    And param status = '<estadoFinal>'
    When method get
    Then status 200
    And match response == '#[]'
    * def mascotasFiltradas = karate.filter(response, function(x){ return x.id == idMascota })
    And match mascotasFiltradas == '#[1]'
    And match mascotasFiltradas[0].id == idMascota
    And match mascotasFiltradas[0].name == '<nombreActualizado>'
    And match mascotasFiltradas[0].status == '<estadoFinal>'

    Examples:
      | read('classpath:petstore/data/mascotas.json') |