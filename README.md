# InvenTrack
Sistema de gestión de inventarios para pymes con sucursales. TB1 Arquitectura de Aplicaciones Web, Grupo 6.

## Estado del proyecto
Proyecto base listo para implementar las historias de usuario del negocio (venta, compra y recepción, traslado, inventario y alertas, kárdex y reportes).

La versión anterior, con los 61 endpoints y las HU iniciales, está guardada en la rama `inventrackv1`.

## Qué incluye la base
- Spring Boot 4.1.1, Java 25, Maven y PostgreSQL.
- Entidades y repositorios de las 17 tablas.
- Manejo global de errores y carga automática de la base (`DB_INIT=true`).
- CRUD de datos de apoyo: sucursal, usuario, categoría, marca, producto, proveedor, producto-proveedor, cliente y método de pago.
- Login: `POST /auth/login`.
- Script `db/inventrack.sql` con mínimo 10 registros por tabla y diagrama en `db/DIAGRAMA_BD.png`.
- `Dockerfile` para el despliegue en Render.

## Variables de entorno
`DB_URL`, `DB_USER`, `DB_PASSWORD`, `DB_INIT` (true solo en una base vacía) y `PORT`.

## Ejecutar
```
cd inventrack
./mvnw spring-boot:run
```
