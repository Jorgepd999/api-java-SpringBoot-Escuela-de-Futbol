# Elementos destacables del desarrollo

Características implementadas (resumen)
- Seguridad:
  - Spring Security con JWT (o configuración definida en el proyecto)
  - Roles y protección de endpoints
- Validaciones:
  - Bean Validation (javax.validation) en DTOs y entidades
  - Validaciones personalizadas (si existen clases custom)
- Caché:
  - Uso de caché para consultas frecuentes (ej. listado de categorías)
- Internacionalización:
  - Soporte multilenguaje en mensajes de validación y errores
- Versionado de API:
  - Versionado interno (prefijo /api/v1) o manejo en headers
- Documentación automatizada:
  - Swagger/OpenAPI para documentación de endpoints
- Pruebas:
  - Unitarias e integración con Testcontainers

Decisiones de diseño relevantes
- Soft delete vs hard delete: se ha optado por `activo` (soft delete) para conservar histórico.
- Uso de DTOs entre controladores y entidades para separación de capas.
- Cache local vs distribuida: inicialmente cache local; considerar Redis si se escala.