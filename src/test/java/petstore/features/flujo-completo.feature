Feature: Flujo completo PetStore

  Background:
    * configure ssl = true
    * url urlBase
    * def utilidades = call read('classpath:petstore/utils/generador.js')

  Scenario Outline: Flujo completo

    * def idMascota = utilidades.generarIdMascota()

    * def mascotaNueva =
      """
      {
    "id": #(idMascota),
    "category": #(categoria),
    "name": "<nombreInicial>",
    "photoUrls": #(photoUrls),
    "tags": #(tags),
    "status": "<estadoInicial>"
    }
    """

    # Crear
    * def crear = call read('classpath:petstore/features/crear-mascota.feature') { mascota: #(mascotaNueva) }

    # Consultar por ID
    * call read('classpath:petstore/features/consultar-mascota-id.feature')
    """
    {
    idMascota: #(idMascota),
    nombre: "<nombreInicial>",
    estado: "<estadoInicial>"
    }
    """

    * def mascotaActualizada =
      """
      {
    "id": #(idMascota),
    "category": #(categoria),
    "name": "<nombreActualizado>",
    "photoUrls": #(photoUrls),
    "tags": #(tags),
    "status": "<estadoFinal>"
    }
    """

    # Actualizar
    * def actualizar = call read('classpath:petstore/features/actualizar-mascota.feature') { mascota: #(mascotaActualizada) }

    # Consultar por estado
    * call read('classpath:petstore/features/consultar-mascota-estado.feature')
    """
    {
    idMascota: #(idMascota),
    nombre: "<nombreActualizado>",
    estado: "<estadoFinal>"
    }
    """

    Examples:
      | read('classpath:petstore/data/mascotas.json') |