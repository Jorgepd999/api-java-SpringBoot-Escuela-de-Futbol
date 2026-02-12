# Plan de Pruebas

Objetivo
- Garantizar la calidad funcional y no funcional de la API: correctitud, seguridad, rendimiento básico y regresión.

Tipos de pruebas
1. Unitarias
   - Herramientas: JUnit5, Mockito
   - Alcance: servicios, validadores, utilidades
   - Cobertura objetivo: ≥ 70% líneas en servicios críticos

2. Integración
   - Herramientas: Spring Boot Test, Testcontainers (Postgres), MockMvc / WebTestClient
   - Alcance: integración de controladores, repositorios JPA, configuración de seguridad
   - Escenarios:
     - CRUD completo Jugador/Categoria con BD real en contenedor
     - Validaciones y respuestas de error (400, 404, 409)
     - Autenticación/autorización: endpoints protegidos

3. End-to-End / API tests
   - Herramientas: Postman collections / Newman o REST-assured
   - Alcance: flows completos (crear categoría → crear jugador → obtener jugadores por categoría)

4. Pruebas de rendimiento (opcional)
   - Herramientas: k6 / Gatling
   - Objetivo: medir tiempo de respuesta y throughput en escenarios clave (GET listados, POST creación)
   - Criterios de aceptación: p95 < 500ms en entorno de preproducción para consultas simples (depende infra)

5. Pruebas de seguridad (básicas)
   - Verificar endpoints expuestos sin autenticación
   - Revisar control de roles (ej. ROLE_ADMIN para operaciones destructivas)
   - Herramientas: OWASP ZAP (escaneo básico)

Casos de prueba prioritarios (ejemplos)
- Crear categoría válida → 201
- Crear categoría con nombre duplicado → 409
- Crear jugador sin categoría → 400
- Obtener jugador existente → 200 con body correcto
- Borrar categoría con jugadores asociados → 409 o restricción según diseño
- Acceso a endpoint protegido sin token → 401

Datos de prueba
- Usar base de datos en Testcontainers con scripts de datos (src/test/resources/data.sql)
- Añadir factories/test builders para crear entidades en tests

Integración continua
- Ejecutar suite de tests en cada push/PR (GitHub Actions)
- Pasos sugeridos:
  - Setup JDK
  - Cache de Maven
  - Start Testcontainers (se ejecuta desde los tests)
  - Ejecutar mvn -DskipTests=false test
  - Publicar cobertura (JaCoCo) y fallos bloqueantes

Criterios de aceptación
- Todas las pruebas unitarias e integración pasan
- No existir regresiones en endpoints críticos
- Cobertura mínima acordada alcanzada