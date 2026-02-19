# Seguridad

## Estado actual

La aplicación no implementa actualmente mecanismos de autenticación ni autorización.

Todos los endpoints están accesibles sin restricción.

---

## Propuesta de implementación con Spring Security

Se propone incorporar:

- spring-boot-starter-security
- Autenticación Basic o JWT
- Definición de roles:
  - ADMIN
  - ENTRENADOR

---

## Modelo de autorización propuesto

- GET → Acceso para ADMIN y ENTRENADOR
- POST, PUT, DELETE → Solo ADMIN

---

## Protección de la API

Se recomienda:

- Protección de endpoints REST
- Protección de vistas Thymeleaf
- Gestión de sesiones segura
- Configuración de CSRF

---

## Futuras mejoras

- Integración con OAuth2
- Persistencia de usuarios en base de datos
- Control de auditoría
