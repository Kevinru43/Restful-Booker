Feature: Funcionalidad Restfull Booking para validar Api Rest

  @prueba
  Scenario Outline: [Happy] - Creación de Token para realizar consultar Booking
    When que el consulta el servicio ingresando el user <user> y password <pass>
    Then el recibe el token con estado 200
    Examples:
      | user  | pass        |
      | admin | password123 |

  @test
  Scenario Outline: [UnHappy] - Error al crear el token para realizar consultas booking
    When que el consulta el servicio ingresando el user <user> y password <pass>
    Then el obtiene un mensaje de error <message>
    Examples:
      | user  | pass        | message         |
      | admin | password456 | Bad credentials |
      | amin  | password123 | Bad credentials |

  @validate
  Scenario Outline: [Happy] -  Creación de usuario en booking
    When el crea el usuario ingresando sus datos: <firstname>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    Then el valida que se proceso correctamente
    And el valida sus datos: <firstname>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |

  @update
  Scenario Outline: [Happy] -  Actualizar usuario en booking
    Given que el consulta el servicio ingresando el user <user> y password <pass>
    And el crea el usuario ingresando sus datos: <firstname>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    When el actualiza sus datos ingresando: <firstnameupdate>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    Then el valida que se proceso correctamente
    And el valida sus datos actualizados: <firstnameupdate>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    Examples:
      | user  | pass        | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | firstnameupdate |
      | admin | password123 | James     | Lopez    | 112        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | Mauro           |

  @delete
  Scenario Outline: [Happy] - Eliminar usuario en booking
    Given que el consulta el servicio ingresando el user <user> y password <pass>
    And el crea el usuario ingresando sus datos: <firstname>, <lastname>, <totalprice>, <depositpaid>, <checkin>, <checkout> y <additionalneeds>
    When el ejecuta el proceso de eliminación
    Then el valida que se elimino de manera exitosa
    Examples:
      | user  | pass        | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | admin | password123 | Kevin     | Lopez    | 112        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |

  @check
  Scenario: [Happy] - Obtener check ping
    Given que el usuario consulta el servicio de ping
    When el ejecuta la consulta
    Then el valida que se creo correctamente el ping