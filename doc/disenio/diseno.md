# Diseño (visión general)

Propósito
- Definir la visión y las decisiones de alto nivel para la interfaz cliente que consumirá la API de la Escuela de Fútbol.
- Alinear requisitos funcionales con criterios de usabilidad, accesibilidad y reutilización de componentes.

Alcance
- Aplicación cliente web (SPA) que consume la API REST (/api/v1/*).
- Soporta usuarios con roles (por ejemplo, ROLE_USER, ROLE_ADMIN).
- Responsive (móvil / tablet / desktop).

Principios de diseño
- Consistencia: patrones visuales y de interacción uniformes en toda la app.
- Claridad: mostrar la información esencial primero, evitar sobrecarga.
- Robustez: manejo claro de errores y estado (loading, success, error).
- Accesibilidad: compatibilidad con teclado, etiquetas ARIA y contraste.
- Reutilización: componentes atómicos para reducir duplicación.

Arquitectura cliente (sugerida)
- SPA (React / Vue / Angular)
- Estructura modular: pages / components / services / store / i18n / styles
- Comunicación con la API:
  - Servicio HTTP único (axios / fetch wrapper) que gestiona:
    - Base URL y versión (/api/v1)
    - Interceptores para autenticación (Bearer token), refresh token y manejo global de errores
- Estado:
  - Local para formularios y vistas específicas
  - Global para sesiones, usuario y configuración (Redux / Pinia / NgRx o contexto)

Internacionalización
- Todos los textos desde archivos i18n (es, en).
- Mensajes de validación basados en claves para facilitar traducción.

Temas y tokens
- Definir tokens (colores, fuentes, espaciado) para facilitar temas y modo oscuro.

Entrega mínima viable (MVP)
- Login / Logout
- Listado, detalle, creación/edición de Categorías
- Listado, detalle, creación/edición de Jugadores
- Paginación y filtros básicos
- Feedback de operaciones (toasts/snackbars)

Notas
- Este documento es la guía de alto nivel; ver archivos específicos (UI, UX, IxD, Diagrama, Reutilización) para detalles y patrones.