#language:es
@TestShop
Característica: Prueba funcional automatizada E2E del flujo de compra en SauceDemo
  Como QE Automatizador
  Quiero validar de extremo a extremo el flujo de compra en la web https://www.saucedemo.com/
  Para asegurar que el proceso de autenticación, selección de productos, carrito, checkout y confirmación de compra funcione correctamente

  Antecedentes:
    Dado que el usuario ingresa a la aplicación SauceDemo

  Escenario: Compra exitosa de dos productos con datos desde JSON
    Cuando carga los datos de compra desde el archivo "shop-data.json"
    Y inicia sesión con los datos cargados
    Y agrega los productos cargados al carrito
    Y visualiza el carrito de compras
    Entonces debería visualizar 2 productos en el carrito
    Cuando completa el formulario de compra con los datos cargados
    Entonces debería visualizar en el checkout los productos agregados
    Cuando finaliza la compra
    Entonces debería visualizar el mensaje de confirmación "Thank you for your order"