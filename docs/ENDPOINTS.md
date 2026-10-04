# Catalogo de endpoints InvenTrack (EP01-EP61)

Fuente: Informe_TP_InvenTrack, seccion 2.2.1. Rutas y nombres de parametros en camelCase.

| ID | Nombre / Propósito | Método / Ruta | Headers Requeridos | Parámetros / Body | Códigos de Respuesta |
| :---- | :---- | :---- | :---- | :---- | :---- |
| **EP01** | Iniciar sesión y obtener token | POST /auth/login | Content-Type: application/json | Body: correo, contrasena | 200 OK, 401 Unauthorized |
| **EP02** | Registrar usuario | POST /usuario/registrar | Content-Type: application/json, Authorization: Bearer | Body: idSucursal, nombre, correo, contrasena, rol | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP03** | Actualizar usuario | PUT /usuario/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idUsuario, idSucursal, nombre, correo, contrasena, rol | 200 OK, 400 Bad Request, 404 Not Found |
| **EP04** | Listar usuarios | GET /usuario/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP05** | Buscar usuario por ID | GET /usuario/buscar-por-id | Authorization: Bearer | Query: idUsuario | 200 OK, 404 Not Found |
| **EP06** | Dar de baja usuario | DELETE /usuario/eliminar | Authorization: Bearer | Query: idUsuario | 200 OK, 404 Not Found |
| **EP07** | Registrar sucursal | POST /sucursal/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, direccion, telefono | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP08** | Actualizar sucursal | PUT /sucursal/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idSucursal, nombre, direccion, telefono | 200 OK, 400 Bad Request, 404 Not Found |
| **EP09** | Listar sucursales | GET /sucursal/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP10** | Buscar sucursal por ID | GET /sucursal/buscar-por-id | Authorization: Bearer | Query: idSucursal | 200 OK, 404 Not Found |
| **EP11** | Dar de baja sucursal | DELETE /sucursal/eliminar | Authorization: Bearer | Query: idSucursal | 200 OK, 404 Not Found |
| **EP12** | Registrar categoría | POST /categoria/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, descripcion | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP13** | Actualizar categoría | PUT /categoria/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idCategorias, nombre, descripcion | 200 OK, 400 Bad Request, 404 Not Found |
| **EP14** | Listar categorías | GET /categoria/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP15** | Buscar categoría por ID | GET /categoria/buscar-por-id | Authorization: Bearer | Query: idCategorias | 200 OK, 404 Not Found |
| **EP16** | Dar de baja categoría | DELETE /categoria/eliminar | Authorization: Bearer | Query: idCategorias | 200 OK, 404 Not Found |
| **EP17** | Registrar marca | POST /marca/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, descripcion | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP18** | Actualizar marca | PUT /marca/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idMarca, nombre, descripcion | 200 OK, 400 Bad Request, 404 Not Found |
| **EP19** | Listar marcas | GET /marca/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP20** | Buscar marca por ID | GET /marca/buscar-por-id | Authorization: Bearer | Query: idMarca | 200 OK, 404 Not Found |
| **EP21** | Dar de baja marca | DELETE /marca/eliminar | Authorization: Bearer | Query: idMarca | 200 OK, 404 Not Found |
| **EP22** | Registrar producto | POST /producto/registrar | Content-Type: application/json, Authorization: Bearer | Body: idCategorias, idMarca, codigo, nombre, descripcion, precioVenta, precioCosto, stockMinimo | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP23** | Actualizar producto | PUT /producto/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idProducto, idCategorias, idMarca, codigo, nombre, descripcion, precioVenta, precioCosto, stockMinimo | 200 OK, 400 Bad Request, 404 Not Found |
| **EP24** | Listar productos | GET /producto/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP25** | Buscar producto por ID | GET /producto/buscar-por-id | Authorization: Bearer | Query: idProducto | 200 OK, 404 Not Found |
| **EP26** | Dar de baja producto | DELETE /producto/eliminar | Authorization: Bearer | Query: idProducto | 200 OK, 404 Not Found |
| **EP27** | Registrar cliente | POST /cliente/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, documento, telefono, correo, direccion | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP28** | Actualizar cliente | PUT /cliente/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idCliente, nombre, documento, telefono, correo, direccion | 200 OK, 400 Bad Request, 404 Not Found |
| **EP29** | Listar clientes | GET /cliente/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP30** | Buscar cliente por ID | GET /cliente/buscar-por-id | Authorization: Bearer | Query: idCliente | 200 OK, 404 Not Found |
| **EP31** | Dar de baja cliente | DELETE /cliente/eliminar | Authorization: Bearer | Query: idCliente | 200 OK, 404 Not Found |
| **EP32** | Registrar método de pago | POST /metodo-pago/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, descripcion | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP33** | Actualizar método de pago | PUT /metodo-pago/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idMetodoPago, nombre, descripcion | 200 OK, 400 Bad Request, 404 Not Found |
| **EP34** | Listar métodos de pago | GET /metodo-pago/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP35** | Buscar método de pago por ID | GET /metodo-pago/buscar-por-id | Authorization: Bearer | Query: idMetodoPago | 200 OK, 404 Not Found |
| **EP36** | Dar de baja método de pago | DELETE /metodo-pago/eliminar | Authorization: Bearer | Query: idMetodoPago | 200 OK, 404 Not Found |
| **EP37** | Registrar venta con su detalle | POST /venta/registrar | Content-Type: application/json, Authorization: Bearer | Body: idCliente, idSucursal, idMetodoPago, detalle[] | 201 Created, 400 Bad Request |
| **EP38** | Buscar venta por ID | GET /venta/buscar-por-id | Authorization: Bearer | Query: idVenta | 200 OK, 404 Not Found |
| **EP39** | Listar ventas | GET /venta/listar | Authorization: Bearer | Query: idSucursal, desde, hasta | 200 OK |
| **EP40** | Anular venta y reponer stock | PUT /venta/anular | Authorization: Bearer | Query: idVenta | 200 OK, 403 Forbidden, 404 Not Found |
| **EP41** | Registrar proveedor | POST /proveedor/registrar | Content-Type: application/json, Authorization: Bearer | Body: nombre, rfcNit, telefono, correo, direccion | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP42** | Actualizar proveedor | PUT /proveedor/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idProveedor, nombre, rfcNit, telefono, correo, direccion | 200 OK, 400 Bad Request, 404 Not Found |
| **EP43** | Listar proveedores | GET /proveedor/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP44** | Buscar proveedor por ID | GET /proveedor/buscar-por-id | Authorization: Bearer | Query: idProveedor | 200 OK, 404 Not Found |
| **EP45** | Dar de baja proveedor | DELETE /proveedor/eliminar | Authorization: Bearer | Query: idProveedor | 200 OK, 404 Not Found |
| **EP46** | Registrar producto de proveedor | POST /producto-proveedor/registrar | Content-Type: application/json, Authorization: Bearer | Body: idProducto, idProveedor, codigoProveedor, precioCompra | 201 Created, 400 Bad Request, 403 Forbidden |
| **EP47** | Actualizar producto de proveedor | PUT /producto-proveedor/actualizar | Content-Type: application/json, Authorization: Bearer | Body: idProductoProveedor, idProducto, idProveedor, codigoProveedor, precioCompra | 200 OK, 400 Bad Request, 404 Not Found |
| **EP48** | Listar productos de proveedores | GET /producto-proveedor/listar | Authorization: Bearer | Ninguno | 200 OK, 401 Unauthorized |
| **EP49** | Buscar producto de proveedor por ID | GET /producto-proveedor/buscar-por-id | Authorization: Bearer | Query: idProductoProveedor | 200 OK, 404 Not Found |
| **EP50** | Dar de baja producto de proveedor | DELETE /producto-proveedor/eliminar | Authorization: Bearer | Query: idProductoProveedor | 200 OK, 404 Not Found |
| **EP51** | Registrar orden de compra con su detalle | POST /orden-compra/registrar | Content-Type: application/json, Authorization: Bearer | Body: idProveedor, idSucursal, observacion, detalle[] | 201 Created, 400 Bad Request |
| **EP52** | Buscar orden de compra por ID | GET /orden-compra/buscar-por-id | Authorization: Bearer | Query: idCompra | 200 OK, 404 Not Found |
| **EP53** | Listar órdenes de compra | GET /orden-compra/listar | Authorization: Bearer | Query: idSucursal, estado | 200 OK |
| **EP54** | Confirmar recepción de la orden | PUT /orden-compra/recibir | Authorization: Bearer | Query: idCompra | 200 OK, 404 Not Found, 409 Conflict |
| **EP55** | Listar inventario por sucursal | GET /inventario/listar | Authorization: Bearer | Query: idSucursal | 200 OK |
| **EP56** | Buscar inventario de un producto | GET /inventario/buscar | Authorization: Bearer | Query: idSucursal, idProducto | 200 OK, 404 Not Found |
| **EP57** | Actualizar ubicación en almacén | PUT /inventario/actualizar-ubicacion | Content-Type: application/json, Authorization: Bearer | Body: idInventario, ubicacion | 200 OK, 404 Not Found |
| **EP58** | Listar movimientos de inventario | GET /movimiento/listar | Authorization: Bearer | Query: idSucursal, desde, hasta | 200 OK |
| **EP59** | Consultar kárdex de un producto | GET /movimiento/kardex | Authorization: Bearer | Query: idProducto, idSucursal | 200 OK, 404 Not Found |
| **EP60** | Reporte de productos bajo el stock mínimo | GET /reporte/stock-bajo | Authorization: Bearer | Query: idSucursal | 200 OK |
| **EP61** | Reporte de ventas por periodo | GET /reporte/ventas | Authorization: Bearer | Query: desde, hasta, idSucursal | 200 OK, 400 Bad Request |
