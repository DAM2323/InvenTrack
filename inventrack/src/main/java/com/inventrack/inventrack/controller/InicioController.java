package com.inventrack.inventrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    private static final String PAGINA = """
        <!DOCTYPE html>
        <html lang="es">
        <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>InvenTrack API</title>
        <style>
          body { font-family: Arial, sans-serif; max-width: 860px; margin: 32px auto; padding: 0 16px; color: #1f2933; }
          h1 { margin-bottom: 4px; }
          h2 { margin-top: 28px; border-bottom: 2px solid #e4e7eb; padding-bottom: 4px; }
          p.sub { color: #52606d; margin-top: 0; }
          ul { line-height: 1.9; padding-left: 20px; }
          code { background: #f0f4f8; padding: 1px 5px; border-radius: 4px; }
          a { color: #0b69c7; }
        </style>
        </head>
        <body>
        <h1>InvenTrack API</h1>
        <p class="sub">Sistema de gestión de inventarios para pymes con sucursales – Grupo 6. Servicio en línea.</p>

        <h2>Catálogo</h2>
        <ul>
          <li><a href="/categoria/listar">/categoria/listar</a></li>
          <li><a href="/categoria/buscar-por-id?idCategorias=1">/categoria/buscar-por-id?idCategorias=1</a></li>
          <li><a href="/marca/listar">/marca/listar</a></li>
          <li><a href="/marca/buscar-por-id?idMarca=1">/marca/buscar-por-id?idMarca=1</a></li>
          <li><a href="/producto/listar">/producto/listar</a></li>
          <li><a href="/producto/buscar-por-id?idProducto=1">/producto/buscar-por-id?idProducto=1</a></li>
        </ul>

        <h2>Ventas</h2>
        <ul>
          <li><a href="/cliente/listar">/cliente/listar</a></li>
          <li><a href="/cliente/buscar-por-id?idCliente=1">/cliente/buscar-por-id?idCliente=1</a></li>
          <li><a href="/metodo-pago/listar">/metodo-pago/listar</a></li>
          <li><a href="/metodo-pago/buscar-por-id?idMetodoPago=1">/metodo-pago/buscar-por-id?idMetodoPago=1</a></li>
          <li><a href="/venta/listar?idSucursal=1">/venta/listar?idSucursal=1</a></li>
          <li><a href="/venta/buscar-por-id?idVenta=1">/venta/buscar-por-id?idVenta=1</a></li>
        </ul>

        <h2>Compras</h2>
        <ul>
          <li><a href="/proveedor/listar">/proveedor/listar</a></li>
          <li><a href="/proveedor/buscar-por-id?idProveedor=1">/proveedor/buscar-por-id?idProveedor=1</a></li>
          <li><a href="/producto-proveedor/listar">/producto-proveedor/listar</a></li>
          <li><a href="/producto-proveedor/buscar-por-id?idProductoProveedor=1">/producto-proveedor/buscar-por-id?idProductoProveedor=1</a></li>
          <li><a href="/orden-compra/listar?idSucursal=1">/orden-compra/listar?idSucursal=1</a></li>
          <li><a href="/orden-compra/listar?idSucursal=1&amp;estado=Pendiente">/orden-compra/listar?idSucursal=1&amp;estado=Pendiente</a></li>
          <li><a href="/orden-compra/buscar-por-id?idCompra=1">/orden-compra/buscar-por-id?idCompra=1</a></li>
        </ul>

        <h2>Inventario y reportes</h2>
        <ul>
          <li><a href="/inventario/listar?idSucursal=1">/inventario/listar?idSucursal=1</a></li>
          <li><a href="/inventario/buscar?idSucursal=1&amp;idProducto=1">/inventario/buscar?idSucursal=1&amp;idProducto=1</a></li>
          <li><a href="/movimiento/listar?idSucursal=1&amp;desde=2026-09-01&amp;hasta=2026-09-30">/movimiento/listar?idSucursal=1&amp;desde=2026-09-01&amp;hasta=2026-09-30</a></li>
          <li><a href="/movimiento/kardex?idProducto=1&amp;idSucursal=1">/movimiento/kardex?idProducto=1&amp;idSucursal=1</a></li>
          <li><a href="/reporte/stock-bajo?idSucursal=1">/reporte/stock-bajo?idSucursal=1</a></li>
          <li><a href="/reporte/ventas?desde=2026-09-01&amp;hasta=2026-09-30">/reporte/ventas?desde=2026-09-01&amp;hasta=2026-09-30</a></li>
        </ul>
        </body>
        </html>
        """;

    @GetMapping(value = "/", produces = "text/html;charset=UTF-8")
    public String inicio() {
        return PAGINA;
    }
}
