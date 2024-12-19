Feature: Product - Store

  @ValidLogin
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<username>" y clave "<password>"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego <quantity> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | username               | password    | quantity |
      | rvilchezb1@upao.edu.pe | Contra1234. | 3        |

  @InvalidLogin
  Scenario: Usuario con credenciales inválidas
    Given estoy en la página de la tienda
    And me logueo con mi usuario "invalid_user" y clave "wrong_password"

  @NonExistentCategory
  Scenario: Categoría inexistente
    Given estoy en la página de la tienda
    And me logueo con mi usuario "rvilchezb1@upao.edu.pe" y clave "Contra1234."
    When navego a la categoria "Vehiculos" y subcategoria "Men"
