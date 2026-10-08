# Catálogo de endpoints InvenTrack (EP01–EP61)

Catálogo base: Informe_TP_InvenTrack, sección 2.2.1. Rutas y parámetros en camelCase.

Las entradas **EP55, EP56, EP57 y EP60** están actualizadas para **HU-INV-004**, según los controladores, servicios y validaciones de la implementación entregada. Las demás entradas conservan la referencia del informe original del equipo.

Consulta los [parámetros, respuestas y ejemplos de HU04](#hu04-inventario-por-sucursal).

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
| **EP55** | Listar inventario por sucursal (HU04) | GET /inventario/listar | Ninguno | Query obligatoria: idSucursal (entero positivo) | 200 OK (lista o []), 400 Bad Request |
| **EP56** | Buscar inventario de un producto (HU04) | GET /inventario/buscar | Ninguno | Query obligatoria: idSucursal, idProducto (enteros positivos) | 200 OK, 400 Bad Request, 404 Not Found |
| **EP57** | Actualizar ubicación en almacén (HU04) | PUT /inventario/actualizar-ubicacion | Content-Type: application/json | Body: idInventario (entero positivo), ubicacion (con contenido, máximo 100 caracteres) | 200 OK, 400 Bad Request, 404 Not Found |
| **EP58** | Listar movimientos de inventario | GET /movimiento/listar | Authorization: Bearer | Query: idSucursal, desde, hasta | 200 OK |
| **EP59** | Consultar kárdex de un producto | GET /movimiento/kardex | Authorization: Bearer | Query: idProducto, idSucursal | 200 OK, 404 Not Found |
| **EP60** | Reporte de productos con disponible <= mínimo (HU04) | GET /reporte/stock-bajo | Ninguno | Query obligatoria: idSucursal (entero) | 200 OK (lista o []), 400 Bad Request |
| **EP61** | Reporte de ventas por periodo | GET /reporte/ventas | Authorization: Bearer | Query: desde, hasta, idSucursal | 200 OK, 400 Bad Request |

## HU04 Inventario por sucursal

Historia: **HU-INV-004 — Consultar el inventario por sucursal y detectar los productos por reponer**.
Rol: Administrador. Responsable: Freddy Mauricio Galindo Rivadeneyra (`u202016286`).

Referencia: [HU04](HU04_Compras_InvenTrack.docx) y [SQL del proyecto](../db/inventrack.sql).
URL local por defecto: `http://localhost:8080` (el puerto se puede configurar con `PORT`).
Las cuatro rutas devuelven JSON. En la implementación entregada se consultan sin el header `Authorization`.

### EP55 — Listar el inventario de una sucursal

```http
GET /inventario/listar?idSucursal=1
```

| Parámetro query | Tipo | Regla |
| --- | --- | --- |
| `idSucursal` | Entero | Obligatorio, mayor que cero. |

- **200 OK:** lista de registros de inventario de la sucursal. Cada registro contiene `id`, `sucursal`, `producto`, `cantidadDisponible`, `ubicacion` y `actualizacion`. `sucursal` y `producto` son objetos; el producto incluye `stockMinimo`.
- **200 OK con `[]`:** la sucursal consultada no tiene registros de inventario.
- **400 Bad Request:** falta el parámetro, no es un entero o es menor o igual a cero.

Con los datos iniciales del SQL, la sucursal 1 tiene **7 registros** de inventario.

### EP56 — Buscar un producto en una sucursal

```http
GET /inventario/buscar?idSucursal=1&idProducto=1
```

| Parámetro query | Tipo | Regla |
| --- | --- | --- |
| `idSucursal` | Entero | Obligatorio, mayor que cero. |
| `idProducto` | Entero | Obligatorio, mayor que cero. |

- **200 OK:** un registro de inventario, con los mismos campos descritos en EP55.
- **400 Bad Request:** falta un parámetro, no es un entero o es menor o igual a cero.
- **404 Not Found:** el producto no tiene inventario en la sucursal consultada. Body:

```json
{
  "mensaje": "No hay inventario para ese producto"
}
```

Con los datos iniciales del SQL, el producto 1 en la sucursal 1 tiene `cantidadDisponible: 8`.
La búsqueda `idSucursal=1&idProducto=14` corresponde al caso de respuesta 404.

### EP60 — Consultar productos con stock bajo

```http
GET /reporte/stock-bajo?idSucursal=1
```

| Parámetro query | Tipo | Regla |
| --- | --- | --- |
| `idSucursal` | Entero | Obligatorio. |

Se incluyen los productos cuyo **`cantidadDisponible <= stockMinimo`**, incluyendo el caso en que ambas cantidades son iguales.

- **200 OK:** lista con los campos `idProducto`, `producto` (nombre), `disponible` y `minimo`.
- **200 OK con `[]`:** no hay productos con stock bajo para la sucursal consultada. Con los datos iniciales, `idSucursal=99` devuelve una lista vacía.
- **400 Bad Request:** falta `idSucursal` o no es un entero.

Ejemplo de respuesta para la sucursal 1 con los datos iniciales del SQL:

```json
[
  {
    "idProducto": 3,
    "producto": "Taladro Truper 1/2\"",
    "disponible": 1,
    "minimo": 5
  },
  {
    "idProducto": 6,
    "producto": "Parlante Philips Bluetooth",
    "disponible": 5,
    "minimo": 8
  },
  {
    "idProducto": 4,
    "producto": "Aceite Primor 1L",
    "disponible": 20,
    "minimo": 40
  },
  {
    "idProducto": 8,
    "producto": "Fideos Don Vittorio 500g",
    "disponible": 40,
    "minimo": 60
  }
]
```

### EP57 — Actualizar la ubicación física

```http
PUT /inventario/actualizar-ubicacion
Content-Type: application/json
```

Body:

```json
{
  "idInventario": 1,
  "ubicacion": "Pasillo Z"
}
```

| Campo JSON | Tipo | Regla |
| --- | --- | --- |
| `idInventario` | Entero | Obligatorio, mayor que cero. |
| `ubicacion` | Cadena | Obligatoria, con contenido y como máximo 100 caracteres. |

- **200 OK:** el registro de inventario actualizado. Cambian `ubicacion` y `actualizacion`; se conserva el producto, la sucursal y la cantidad disponible. Se eliminan los espacios al inicio y al final de la ubicación.
- **400 Bad Request:** JSON inválido, identificador ausente o no positivo, ubicación vacía o de más de 100 caracteres.
- **404 Not Found:** no existe el identificador de inventario. Body:

```json
{
  "mensaje": "Inventario no encontrado"
}
```

Los errores manejados por `GlobalExceptionHandler` usan un objeto JSON con el campo `mensaje`.
