package com.inventrack.inventrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    private static final String PAGINA = """
        <!DOCTYPE html>
        <html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
        <title>InvenTrack API</title>
        <style>
         body{font-family:Arial,sans-serif;max-width:860px;margin:32px auto;padding:0 16px;color:#1f2933}
         h1{margin-bottom:4px} h2{margin-top:28px;border-bottom:2px solid #e4e7eb;padding-bottom:4px}
         p.sub{color:#52606d;margin-top:0} ul{line-height:1.9;padding-left:20px} a{color:#0b69c7}
         code{background:#f0f4f8;padding:1px 5px;border-radius:4px}
         details{margin:6px 0 0 20px} summary{cursor:pointer;color:#52606d;font-size:14px;padding:2px 0}
         .ep{margin:10px 0;padding:8px 10px;background:#fafbfc;border:1px solid #e4e7eb;border-radius:6px}
         .m{display:inline-block;min-width:58px;text-align:center;font-weight:bold;font-size:12px;color:#fff;border-radius:4px;padding:2px 6px}
         .POST{background:#2f9e44} .PUT{background:#e08a00} .DELETE{background:#d6336c} .GET{background:#1c7ed6}
         pre{background:#1f2933;color:#e6edf3;padding:10px;border-radius:6px;font-size:12.5px;overflow:auto;margin:8px 0 4px}
         button.cp{font-size:12px;margin-left:6px;padding:2px 8px;cursor:pointer;border:1px solid #cbd2d9;background:#fff;border-radius:4px}
         p.et{margin:12px 0 0;font-weight:bold;font-size:14px} .av{font-size:12px;color:#8a5a00;margin:6px 0 0}
        </style></head><body>
        <h1>InvenTrack API</h1>
        <p class="sub">Sistema de gestión de inventarios para pymes con sucursales – Grupo 6. Servicio en línea.</p>
        <h2>Usuarios y sucursales</h2><ul><li><a href="/usuario/listar">/usuario/listar</a></li><li><a href="/usuario/buscar-por-id?idUsuario=1">/usuario/buscar-por-id?idUsuario=1</a></li><li><a href="/sucursal/listar">/sucursal/listar</a></li><li><a href="/sucursal/buscar-por-id?idSucursal=1">/sucursal/buscar-por-id?idSucursal=1</a></li></ul><details><summary>Más (registrar, actualizar, baja)</summary><div class="ep" data-u="/auth/login"><span class="m POST">POST</span> <code>/auth/login</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;correo&quot;: &quot;admin@inventrack.pe&quot;,
          &quot;contrasena&quot;: &quot;ClaveSegura2026*&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/usuario/registrar"><span class="m POST">POST</span> <code>/usuario/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idSucursal&quot;: 1,
          &quot;nombre&quot;: &quot;Usuario {U}&quot;,
          &quot;correo&quot;: &quot;prueba{U}@inventrack.pe&quot;,
          &quot;contrasena&quot;: &quot;Abc12345&quot;,
          &quot;rol&quot;: &quot;Almacen&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/usuario/actualizar"><span class="m PUT">PUT</span> <code>/usuario/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;idUsuario&quot;: 6,
          &quot;idSucursal&quot;: 1,
          &quot;nombre&quot;: &quot;Usuario {U} editado&quot;,
          &quot;correo&quot;: &quot;prueba{U}@inventrack.pe&quot;,
          &quot;rol&quot;: &quot;Vendedor&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/usuario/eliminar?idUsuario=6"><span class="m DELETE">DELETE</span> <code>/usuario/eliminar?idUsuario=6</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/sucursal/registrar"><span class="m POST">POST</span> <code>/sucursal/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Sucursal {U}&quot;,
          &quot;direccion&quot;: &quot;Av. Prueba 100&quot;,
          &quot;telefono&quot;: &quot;01-5550000&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/sucursal/actualizar"><span class="m PUT">PUT</span> <code>/sucursal/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 4,
          &quot;nombre&quot;: &quot;Sucursal {U} editada&quot;,
          &quot;direccion&quot;: &quot;Av. Prueba 200&quot;,
          &quot;telefono&quot;: &quot;01-5550001&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/sucursal/eliminar?idSucursal=4"><span class="m DELETE">DELETE</span> <code>/sucursal/eliminar?idSucursal=4</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div></details><h2>Catálogo</h2><ul><li><a href="/categoria/listar">/categoria/listar</a></li><li><a href="/categoria/buscar-por-id?idCategorias=1">/categoria/buscar-por-id?idCategorias=1</a></li><li><a href="/marca/listar">/marca/listar</a></li><li><a href="/marca/buscar-por-id?idMarca=1">/marca/buscar-por-id?idMarca=1</a></li><li><a href="/producto/listar">/producto/listar</a></li><li><a href="/producto/buscar-por-id?idProducto=1">/producto/buscar-por-id?idProducto=1</a></li></ul><details><summary>Más (registrar, actualizar, baja)</summary><div class="ep" data-u="/categoria/registrar"><span class="m POST">POST</span> <code>/categoria/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Categoría {U}&quot;,
          &quot;descripcion&quot;: &quot;Solo para pruebas&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/categoria/actualizar"><span class="m PUT">PUT</span> <code>/categoria/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 6,
          &quot;nombre&quot;: &quot;Categoría {U} editada&quot;,
          &quot;descripcion&quot;: &quot;Editada&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/categoria/eliminar?idCategorias=6"><span class="m DELETE">DELETE</span> <code>/categoria/eliminar?idCategorias=6</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/marca/registrar"><span class="m POST">POST</span> <code>/marca/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Marca {U}&quot;,
          &quot;descripcion&quot;: &quot;Solo para pruebas&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/marca/actualizar"><span class="m PUT">PUT</span> <code>/marca/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 6,
          &quot;nombre&quot;: &quot;Marca {U} editada&quot;,
          &quot;descripcion&quot;: &quot;Editada&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/marca/eliminar?idMarca=6"><span class="m DELETE">DELETE</span> <code>/marca/eliminar?idMarca=6</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/producto/registrar"><span class="m POST">POST</span> <code>/producto/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;codigo&quot;: &quot;DEMO-{U}&quot;,
          &quot;nombre&quot;: &quot;Producto {U}&quot;,
          &quot;descripcion&quot;: &quot;Registrado desde Postman&quot;,
          &quot;precioVenta&quot;: 25.5,
          &quot;precioCosto&quot;: 15.0,
          &quot;stockMinimo&quot;: 10,
          &quot;categoria&quot;: {
            &quot;id&quot;: 1
          },
          &quot;marca&quot;: {
            &quot;id&quot;: 1
          }
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/producto/actualizar"><span class="m PUT">PUT</span> <code>/producto/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 11,
          &quot;codigo&quot;: &quot;DEMO-{U}&quot;,
          &quot;nombre&quot;: &quot;Producto {U} editado&quot;,
          &quot;descripcion&quot;: &quot;Editado&quot;,
          &quot;precioVenta&quot;: 30.0,
          &quot;precioCosto&quot;: 15.0,
          &quot;stockMinimo&quot;: 10,
          &quot;categoria&quot;: {
            &quot;id&quot;: 1
          },
          &quot;marca&quot;: {
            &quot;id&quot;: 1
          }
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/producto/eliminar?idProducto=11"><span class="m DELETE">DELETE</span> <code>/producto/eliminar?idProducto=11</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div></details><h2>Ventas</h2><ul><li><a href="/cliente/listar">/cliente/listar</a></li><li><a href="/cliente/buscar-por-id?idCliente=1">/cliente/buscar-por-id?idCliente=1</a></li><li><a href="/metodo-pago/listar">/metodo-pago/listar</a></li><li><a href="/metodo-pago/buscar-por-id?idMetodoPago=1">/metodo-pago/buscar-por-id?idMetodoPago=1</a></li><li><a href="/venta/listar?idSucursal=1">/venta/listar?idSucursal=1</a></li><li><a href="/venta/buscar-por-id?idVenta=1">/venta/buscar-por-id?idVenta=1</a></li></ul><details><summary>Más (registrar, actualizar, baja)</summary><div class="ep" data-u="/cliente/registrar"><span class="m POST">POST</span> <code>/cliente/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Cliente {U}&quot;,
          &quot;documento&quot;: &quot;{U}&quot;,
          &quot;telefono&quot;: &quot;999000111&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/cliente/actualizar"><span class="m PUT">PUT</span> <code>/cliente/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 6,
          &quot;nombre&quot;: &quot;Cliente {U} editado&quot;,
          &quot;documento&quot;: &quot;{U}&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/cliente/eliminar?idCliente=6"><span class="m DELETE">DELETE</span> <code>/cliente/eliminar?idCliente=6</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/metodo-pago/registrar"><span class="m POST">POST</span> <code>/metodo-pago/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Plin {U}&quot;,
          &quot;descripcion&quot;: &quot;Pago con Plin&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/metodo-pago/actualizar"><span class="m PUT">PUT</span> <code>/metodo-pago/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;id&quot;: 5,
          &quot;nombre&quot;: &quot;Plin {U} editado&quot;,
          &quot;descripcion&quot;: &quot;Editado&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/metodo-pago/eliminar?idMetodoPago=5"><span class="m DELETE">DELETE</span> <code>/metodo-pago/eliminar?idMetodoPago=5</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/venta/registrar"><span class="m POST">POST</span> <code>/venta/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idCliente&quot;: 1,
          &quot;idSucursal&quot;: 1,
          &quot;idMetodoPago&quot;: 1,
          &quot;idUsuario&quot;: 2,
          &quot;observacion&quot;: &quot;Venta de mostrador&quot;,
          &quot;detalle&quot;: [
            {
              &quot;idProducto&quot;: 1,
              &quot;cantidad&quot;: 2,
              &quot;precioUnitario&quot;: 50,
              &quot;descuento&quot;: 10
            }
          ]
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/venta/anular?idVenta=6"><span class="m PUT">PUT</span> <code>/venta/anular?idVenta=6</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Usa el idVenta que te devolvió registrar la venta.</div></div></details><h2>Compras</h2><ul><li><a href="/proveedor/listar">/proveedor/listar</a></li><li><a href="/proveedor/buscar-por-id?idProveedor=1">/proveedor/buscar-por-id?idProveedor=1</a></li><li><a href="/producto-proveedor/listar">/producto-proveedor/listar</a></li><li><a href="/producto-proveedor/buscar-por-id?idProductoProveedor=1">/producto-proveedor/buscar-por-id?idProductoProveedor=1</a></li><li><a href="/orden-compra/listar?idSucursal=1">/orden-compra/listar?idSucursal=1</a></li><li><a href="/orden-compra/listar?idSucursal=1&amp;estado=Pendiente">/orden-compra/listar?idSucursal=1&amp;estado=Pendiente</a></li><li><a href="/orden-compra/buscar-por-id?idCompra=1">/orden-compra/buscar-por-id?idCompra=1</a></li></ul><details><summary>Más (registrar, actualizar, baja)</summary><div class="ep" data-u="/proveedor/registrar"><span class="m POST">POST</span> <code>/proveedor/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;nombre&quot;: &quot;Proveedor {U} SAC&quot;,
          &quot;rfcNit&quot;: &quot;20{U}&quot;,
          &quot;telefono&quot;: &quot;999888777&quot;,
          &quot;correo&quot;: &quot;ventas@prueba.pe&quot;,
          &quot;direccion&quot;: &quot;Av. Lima 123&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/proveedor/actualizar"><span class="m PUT">PUT</span> <code>/proveedor/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div><pre data-t="{
          &quot;idProveedor&quot;: 4,
          &quot;nombre&quot;: &quot;Proveedor {U} editado&quot;,
          &quot;rfcNit&quot;: &quot;20{U}&quot;,
          &quot;telefono&quot;: &quot;999888777&quot;,
          &quot;correo&quot;: &quot;ventas@prueba.pe&quot;,
          &quot;direccion&quot;: &quot;Av. Lima 123&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/proveedor/eliminar?idProveedor=4"><span class="m DELETE">DELETE</span> <code>/proveedor/eliminar?idProveedor=4</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/producto-proveedor/registrar"><span class="m POST">POST</span> <code>/producto-proveedor/registrar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">En idProducto pon el id del producto NUEVO que registraste en Catálogo (un par producto/proveedor no se puede repetir).</div><pre data-t="{
          &quot;idProducto&quot;: 11,
          &quot;idProveedor&quot;: 1,
          &quot;codigoProveedor&quot;: &quot;PP-{U}&quot;,
          &quot;precioCompra&quot;: 6.5
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/producto-proveedor/actualizar"><span class="m PUT">PUT</span> <code>/producto-proveedor/actualizar</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia idProductoProveedor por el id que te devolvió el registrar, e idProducto por el producto nuevo.</div><pre data-t="{
          &quot;idProductoProveedor&quot;: 9,
          &quot;idProducto&quot;: 11,
          &quot;idProveedor&quot;: 1,
          &quot;codigoProveedor&quot;: &quot;PP-{U}&quot;,
          &quot;precioCompra&quot;: 7.0
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/producto-proveedor/eliminar?idProductoProveedor=9"><span class="m DELETE">DELETE</span> <code>/producto-proveedor/eliminar?idProductoProveedor=9</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Cambia el id por el que te devolvió el registrar.</div></div><div class="ep" data-u="/orden-compra/registrar"><span class="m POST">POST</span> <code>/orden-compra/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idProveedor&quot;: 1,
          &quot;idSucursal&quot;: 1,
          &quot;idUsuario&quot;: 1,
          &quot;observacion&quot;: &quot;Reposición de demostración&quot;,
          &quot;detalle&quot;: [
            {
              &quot;idProducto&quot;: 1,
              &quot;cantidad&quot;: 5,
              &quot;precioUnitario&quot;: 950
            }
          ]
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><div class="ep" data-u="/orden-compra/recibir?idCompra=5"><span class="m PUT">PUT</span> <code>/orden-compra/recibir?idCompra=5</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Usa el idCompra que te devolvió registrar la orden.</div></div></details><h2>Inventario y reportes</h2><ul><li><a href="/inventario/listar?idSucursal=1">/inventario/listar?idSucursal=1</a></li><li><a href="/inventario/buscar?idSucursal=1&amp;idProducto=1">/inventario/buscar?idSucursal=1&amp;idProducto=1</a></li><li><a href="/movimiento/listar?idSucursal=1&amp;desde=2026-09-01&amp;hasta=2026-09-30">/movimiento/listar?idSucursal=1&amp;desde=2026-09-01&amp;hasta=2026-09-30</a></li><li><a href="/movimiento/kardex?idProducto=1&amp;idSucursal=1">/movimiento/kardex?idProducto=1&amp;idSucursal=1</a></li><li><a href="/reporte/stock-bajo?idSucursal=1">/reporte/stock-bajo?idSucursal=1</a></li><li><a href="/reporte/ventas?desde=2026-09-01&amp;hasta=2026-09-30">/reporte/ventas?desde=2026-09-01&amp;hasta=2026-09-30</a></li></ul><details><summary>Más (registrar, actualizar, baja)</summary><div class="ep" data-u="/inventario/actualizar-ubicacion"><span class="m PUT">PUT</span> <code>/inventario/actualizar-ubicacion</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idInventario&quot;: 1,
          &quot;ubicacion&quot;: &quot;Pasillo Z&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div></details><h2>Casos de error</h2><details><summary>Ver casos de error</summary><p class="et">Venta con stock insuficiente → 400</p><div class="ep" data-u="/venta/registrar"><span class="m POST">POST</span> <code>/venta/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idCliente&quot;: 1,
          &quot;idSucursal&quot;: 1,
          &quot;idMetodoPago&quot;: 1,
          &quot;idUsuario&quot;: 2,
          &quot;detalle&quot;: [
            {
              &quot;idProducto&quot;: 1,
              &quot;cantidad&quot;: 99999
            }
          ]
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><p class="et">Recibir una orden ya recibida → 409</p><div class="ep" data-u="/orden-compra/recibir?idCompra=1"><span class="m PUT">PUT</span> <code>/orden-compra/recibir?idCompra=1</code> <button class="cp" data-u="1">Copiar URL</button><div class="av">Usa el idCompra que te devolvió registrar la orden.</div></div><p class="et">Registrar usuario con correo repetido → 400</p><div class="ep" data-u="/usuario/registrar"><span class="m POST">POST</span> <code>/usuario/registrar</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;idSucursal&quot;: 1,
          &quot;nombre&quot;: &quot;Repetido&quot;,
          &quot;correo&quot;: &quot;admin@inventrack.pe&quot;,
          &quot;contrasena&quot;: &quot;Abc12345&quot;,
          &quot;rol&quot;: &quot;Almacen&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><p class="et">Login con clave incorrecta → 401</p><div class="ep" data-u="/auth/login"><span class="m POST">POST</span> <code>/auth/login</code> <button class="cp" data-u="1">Copiar URL</button><pre data-t="{
          &quot;correo&quot;: &quot;admin@inventrack.pe&quot;,
          &quot;contrasena&quot;: &quot;incorrecta&quot;
        }"></pre><button class="cp" data-b="1">Copiar body</button></div><p class="et">Buscar un id que no existe → 404</p><div class="ep" data-u="/proveedor/buscar-por-id?idProveedor=999999"><span class="m GET">GET</span> <code>/proveedor/buscar-por-id?idProveedor=999999</code> <button class="cp" data-u="1">Copiar URL</button></div></details>
        <script>
        function uniq(){return String(Date.now()%10000000);}
        function fill(t){var n=uniq();return t.replace(/\\{U\\}/g,n);}
        document.querySelectorAll('pre[data-t]').forEach(function(p){p.textContent=fill(p.getAttribute('data-t'));});
        document.addEventListener('click',function(ev){var b=ev.target.closest('button.cp');if(!b)return;
         var ep=b.closest('.ep');var t;
         if(b.hasAttribute('data-u')){t=location.origin+ep.getAttribute('data-u');}
         else{var pre=ep.querySelector('pre');t=fill(pre.getAttribute('data-t'));pre.textContent=t;}
         var o=b.textContent;
         (navigator.clipboard?navigator.clipboard.writeText(t):Promise.reject()).catch(function(){var a=document.createElement('textarea');a.value=t;document.body.appendChild(a);a.select();document.execCommand('copy');a.remove();});
         b.textContent='¡Copiado!';setTimeout(function(){b.textContent=o},1200);});
        </script></body></html>
        """;

    @GetMapping(value = "/", produces = "text/html;charset=UTF-8")
    public String inicio() {
        return PAGINA;
    }
}
