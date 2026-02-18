# 🔐 Seguridad – Spring Security

## 1. Objetivo de la Seguridad en la Aplicación

La aplicación de gestión de la academia de fútbol maneja información sensible como:

- Datos personales de usuarios.
- Información de jugadores.
- Gestión de categorías.
- Administración del sistema.

Por este motivo, es necesario implementar mecanismos de **autenticación y autorización** que garanticen:

- Que solo usuarios registrados puedan acceder al sistema.
- Que cada usuario acceda únicamente a los recursos permitidos según su rol.
- Que las contraseñas se almacenen de forma segura.
- Que los endpoints REST estén protegidos frente a accesos no autorizados.

Para ello se ha utilizado **Spring Security**, integrado en el framework **Spring Boot**.

---

## 2. Modelo de Autenticación

La autenticación se realiza mediante:

- **Correo electrónico**
- **Contraseña cifrada**

Los usuarios están almacenados en base de datos y se cargan mediante la interfaz `UserDetailsService`.

Las contraseñas se almacenan cifradas utilizando el algoritmo **BCrypt**, garantizando que no se guarden en texto plano.

---

## 3. Modelo de Autorización

Se ha implementado un sistema de control de acceso basado en **roles y permisos**.

### 👤 Rol USER

Puede:

- Gestionar jugadores.
- Consultar información de categorías.

### 👑 Rol ADMIN

Puede:

- Gestionar jugadores.
- Gestionar categorías.
- Gestionar usuarios del sistema.

---

## 4. Modelo de Permisos

Para permitir un control más granular, se han definido permisos específicos:

### Permisos de Usuario

- USER_CREATE
- USER_READ
- USER_UPDATE
- USER_DELETE

### Permisos de Administrador

- ADMIN_CREATE
- ADMIN_READ
- ADMIN_UPDATE
- ADMIN_DELETE

Cada rol contiene un conjunto de permisos, lo que permite escalar el sistema fácilmente si en el futuro se añaden nuevos perfiles como entrenadores o coordinadores.

---

## 5. Arquitectura de Seguridad

La arquitectura implementada sigue el flujo estándar de Spring Security:

1. El usuario intenta acceder a un endpoint protegido.
2. La petición es interceptada por la cadena de filtros de seguridad.
3. Se genera un objeto `Authentication`.
4. El `AuthenticationManager` valida las credenciales.
5. Se cargan los datos del usuario desde la base de datos.
6. Se verifica la contraseña mediante `PasswordEncoder` (BCrypt).
7. Si la autenticación es correcta, el usuario queda autenticado en el `SecurityContext`.
8. Se verifica la autorización según el rol o permiso requerido.
9. Se permite o deniega el acceso.

Si la autenticación falla → **HTTP 401 (Unauthorized)**  
Si no tiene permisos suficientes → **HTTP 403 (Forbidden)**

---

## 6. Persistencia de Usuarios

Los usuarios se almacenan en la tabla:

### Tabla: `USUARIOS`

Campos:

- `id`
- `firstname`
- `lastname`
- `email`
- `password` (cifrada con BCrypt)
- `role`

### Usuarios iniciales de prueba

| Email        | Rol   |
|-------------|--------|
| user@a.com  | USER   |
| admin@a.com | ADMIN  |

---

## 7. Configuración de Seguridad

Se han configurado los siguientes componentes:

- `UserDetailsService`
- `PasswordEncoder` (BCrypt)
- `AuthenticationManager`
- `SecurityFilterChain`

### Política de acceso configurada

- `/jugadores/**` → USER y ADMIN
- `/categorias/**` → ADMIN
- `/usuarios/**` → ADMIN
- Resto de endpoints → Requieren autenticación

La aplicación permite autenticación mediante:

- **FormLogin** (formulario web)
- **HTTP Basic** (para consumo de servicios REST)

---

## 8. Protección de Contraseñas

Las contraseñas se almacenan utilizando el algoritmo **BCrypt**.

Ventajas:

- No se almacenan contraseñas en texto plano.
- Incluye salt automático.
- Resistente frente a ataques de fuerza bruta.
- Cumple estándares actuales de seguridad.

---

## 9. Entorno de Desarrollo

Para facilitar el desarrollo y las pruebas, la configuración de seguridad puede adaptarse mediante perfiles de Spring, permitiendo:

- Activar o desactivar restricciones.
- Usar usuarios de prueba.
- Simplificar la construcción inicial del sistema.

---

# Requisitos No Funcionales Relacionados con Seguridad

- **NF-01:** El sistema deberá implementar autenticación mediante correo electrónico y contraseña.
- **NF-02:** El sistema deberá implementar autorización basada en roles (USER y ADMIN).
- **NF-03:** Las contraseñas deberán almacenarse cifradas mediante BCrypt.
- **NF-04:** El acceso a los endpoints REST deberá estar protegido.

---

# Control de Acceso a Endpoints REST

| Endpoint        | Método | Rol requerido |
|---------------|--------|---------------|
| `/jugadores`  | GET    | USER, ADMIN   |
| `/jugadores`  | POST   | USER, ADMIN   |
| `/categorias` | POST   | ADMIN         |
| `/usuarios`   | GET    | ADMIN         |

---

# Plan de Pruebas de Seguridad

Pruebas realizadas:

- Acceso sin autenticación → Respuesta 401.
- Usuario con rol USER intentando acceder a `/categorias` → Respuesta 403.
- Usuario ADMIN accediendo a `/categorias` → Acceso permitido.
- Login con contraseña incorrecta → Error de autenticación.
