| Endpoint          | Método HTTP | Body (Request)                 | Código HTTP | Cuerpo de Respuesta | Posibles Errores / Validaciones |
|------------------|------------|-------------------------------|-------------|-------------------|--------------------------------|
| `/categorias`     | GET        | N/A                           | 200 OK      | `{"categorias": [ {"id": 1, "nombre": "Alevín", "jugadores": []}, {"id": 2, "nombre": "Infantil", "jugadores": []} ]}` | **404 Not Found** → No se encontraron categorías.<br>**500 Internal Server Error** → Ocurrió un error en el servidor. |
| `/categorias/{id}` | GET       | N/A    | 200 OK    | `{"id":1,"nombre":"Alevín","jugadores"[]}` |
| `/categorias`     | POST       | `{"nombre": "Cadete"}`       | 201 Created | `{"id": 3, "nombre": "Cadete", "jugadores": []}` | **400 Bad Request** → El campo "nombre" es obligatorio.<br>**409 Conflict** → Ya existe una categoría con ese nombre.<br>500 Internal Server Error → No se pudo crear la categoría. |
| `/categorias/{id}`| PUT        | `{"nombre": "Juvenil A"}`    | 200 OK      | `{"id": 1, "nombre": "Juvenil A", "jugadores": []}` | **400 Bad Request** → El nombre no puede estar vacío.<br>**404 Not Found** → No se encontró la categoría con id {id}.<br>**500 Internal Server Error** → Ocurrió un error al actualizar la categoría. |
| `/categorias/{id}`| DELETE     | N/A                           | 204 No Content | N/A               | 404 Not Found → No se encontró la categoría con id {id}.<br>**400 Bad Request** → No se puede eliminar una categoría que tenga jugadores activos.<br>**500 Internal Server Error**→ Ocurrió un error al eliminar la categoría. |





| Endpoint | Método HTTP | Rol | Body (Request) | Código HTTP | Cuerpo de Respuesta | Posibles Errores / Validaciones |
|---------|-------------|-----|----------------|------------|----------------------|----------------------------------|
| `/categorias` | GET | USER, ADMIN | N/A | **200 OK** | `{"categorias":[{"id":1,"nombre":"Alevín","jugadores":[]},{"id":2,"nombre":"Infantil","jugadores":[]}]}` | **404 Not Found** → No se encontraron categorías.<br>**500 Internal Server Error** → Error interno del servidor. |
| `/categorias/{id}` | GET | USER, ADMIN | N/A | **200 OK** | `{"id":1,"nombre":"Alevín","jugadores":[]}` | **404 Not Found** → No se encontró la categoría con id `{id}`.<br>**500 Internal Server Error** → Error interno del servidor. |
| `/categorias` | POST | ADMIN | `{"nombre":"Cadete"}` | **201 Created** | `{"id":3,"nombre":"Cadete","jugadores":[]}` | **400 Bad Request** → El campo `"nombre"` es obligatorio.<br>**409 Conflict** → Ya existe una categoría con ese nombre.<br>**500 Internal Server Error** → No se pudo crear la categoría. |
| `/categorias/{id}` | PUT | ADMIN | `{"nombre":"Juvenil A"}` | **200 OK** | `{"id":1,"nombre":"Juvenil A","jugadores":[]}` | **400 Bad Request** → El nombre no puede estar vacío.<br>**404 Not Found** → No se encontró la categoría con id `{id}`.<br>**500 Internal Server Error** → Error al actualizar la categoría. |
| `/categorias/{id}` | DELETE | ADMIN | N/A | **204 No Content** | N/A | **400 Bad Request** → No se puede eliminar una categoría que tenga jugadores activos.<br>**404 Not Found** → No se encontró la categoría con id `{id}`.<br>**500 Internal Server Error** → Error al eliminar la categoría. |
