# Manual de usuario - API Escuela de Fútbol

Resumen
- Base path: /api (ej. http://localhost:8080/api)
- Autenticación: Bearer token JWT (si está implementado)
- Formato de intercambio: JSON

Autenticación
- Obtener token:
  - POST /api/auth/login
  - Body:
    ```json
    {
      "username": "usuario",
      "password": "secreto"
    }
    ```
  - Respuesta:
    ```json
    {
      "token": "eyJhbGciOi..."
    }
    ```

Endpoints principales (ejemplos)
- Categorías
  - GET /api/v1/categorias
    - Descripción: lista todas las categorías
    - Respuesta: 200 OK
    - Ejemplo body:
      ```json
      [
        { "id": 1, "nombre": "Infantil", "activo": true }
      ]
      ```
  - POST /api/v1/categorias
    - Descripción: crea una categoría (ROLE_ADMIN)
    - Body:
      ```json
      { "nombre": "Infantil", "descripcion": "..." }
      ```
    - Respuesta: 201 Created

- Jugadores
  - GET /api/v1/jugadores
    - Descripción: lista jugadores (con filtros opcionales ?categoria=1&activo=true)
  - GET /api/v1/jugadores/{id}
  - POST /api/v1/jugadores
    - Body:
      ```json
      {
        "nombre": "Pablo",
        "apellidos": "García",
        "fechaNacimiento": "2010-05-20",
        "dorsal": 9,
        "posicion": "Delantero",
        "categoriaId": 1
      }
      ```
    - Respuestas: 201 Created / 400 Bad Request (validación)

Códigos de estado comunes
- 200 OK — éxito lectura
- 201 Created — recurso creado
- 400 Bad Request — error de validación
- 401 Unauthorized — credenciales requeridas/invalidas
- 403 Forbidden — sin permiso
- 404 Not Found — recurso no encontrado
- 409 Conflict — conflicto (ej. duplicado)

Ejemplos con curl
- Listar categorías:
  ```
  curl -X GET http://localhost:8080/api/v1/categorias
  ```
- Crear jugador (con token):
  ```
  curl -X POST http://localhost:8080/api/v1/jugadores \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json" \
    -d '{"nombre":"Pablo","categoriaId":1}'
  ```

Consejos de uso
- Usar paginación en listados si se añade a la API (page, size)
- Registrar siempre el id de la respuesta al crear recursos