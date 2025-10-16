Orders & Users Microservice — Prueba Técnica

Este repositorio contiene un microservicio Spring Boot (Java 17) desarrollado como parte de una prueba técnica. Implementa operaciones básicas sobre Usuarios y Órdenes, manejo simple de estados y un esquema de errores con código y mensaje. La persistencia se hace con H2 en archivo para facilitar la ejecución local.

Objetivo de la prueba

Modelar entidades User y Order.

Exponer operaciones de lectura/actualización simples.

Validar estados de orden de forma controlada.

Estandarizar errores con OrdersException (code, message) y AppError.

Alcance y supuestos

Estados permitidos: PENDIENTE, APROBADO, CANCELADA (string normalizado).

No incluye autenticación ni autorización (enfoque en dominio y manejo de errores).

Base de datos H2 file pensada para desarrollo/local.

Stack

Java 17, Spring Boot

Spring Web, Spring Data JPA

H2 (modo archivo)

Lombok

(Opcional) MapStruct para mapeo DTO
