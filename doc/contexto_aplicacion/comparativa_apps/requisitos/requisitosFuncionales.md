# Requisitos Funcionales

## RF-01 Gestión de jugadores
El sistema debe permitir:
- Crear jugadores
- Listar jugadores
- Consultar jugador por ID
- Modificar jugadores
- Eliminar jugadores

## RF-02 Gestión de categorías
El sistema debe permitir:
- Crear categorías
- Listar categorías
- Consultar categoría por ID
- Modificar categorías
- Eliminar categorías

## RF-03 Relación entre entidades
Cada jugador debe pertenecer a una categoría.

## RF-04 Generación de PDF
El sistema debe permitir generar un PDF con el listado de jugadores.

## RF-05 API REST
El sistema debe exponer endpoints REST documentados con OpenAPI.

## RF-06 Internacionalización
El sistema debe soportar al menos dos idiomas mediante parámetro `lang`.

## RF-07 Gestión de errores
El sistema debe manejar errores mediante un controlador global.
