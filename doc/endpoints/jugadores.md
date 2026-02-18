| Endpoint          | Método HTTP | Body (Request)                      | Código HTTP | Cuerpo de Respuesta | Posibles Errores / Validaciones |
|------------------|------------|------------------------------------|-------------|-------------------|--------------------------------|
| `/jugadores`     | GET        | N/A                                | 200 OK      | `{"jugadores": [ {"id": 1, "nombre": "Cristiano","apellido,:"Ronaldo", "edad": 37,"piernaHabil":"derecha"}, {"id": 2, "nombre": "Lionel","apellido":"Messi", "edad": 36,"piernaHabil":"izquierda"} ]}` | **404 Not Found** → No se encontraron jugadores.<br>**500 Internal Server Error** → Ocurrió un error en el servidor. |
| `/jugadores/{id}`| GET        | N/A                                | 200 OK      | `{id": 1, "nombre": "Cristiano","apellido,:"Ronaldo", "edad": 37,"piernaHabil":"derecha"}` | **404 Not Found** → No se encontró el jugador con id {id}.<br>**500 Internal Server Error** → Ocurrió un error en el servidor. 
| `/jugadores`     | POST       | `{"nombre": "Kylian", "apellido": "Mbappe", "edad": 25}` | 201 Created | `{"id": 3, "nombre": "Kylian", "apellido": "Mbappe","edad": 25,"piernaHabil":"derecha"}` | **400 Bad Request** → El nombre y la edad son obligatorios.<br>**400 Bad Request** → La edad debe ser un número positivo.<br>**500 Internal Server Error** → No se pudo crear el jugador. |
|
| `/jugadores/{id}`| PUT        | `{"nombre": "Jorge","apellido":"Alonso", "edad": 12,"piernaHabil": derecha}` | 200 OK      | `{"id": 1, nombre": "Jorge","apellido":"Alonso", "edad": 12,"piernaHabil": derecha}` | **400 Bad Request** → Debe incluir al menos un campo válido ('nombre' o 'edad').<br>**404 Not Found** → No se encontró el jugador con id {id}.<br>**500 Internal Server Error** → Ocurrió un error al actualizar el jugador. |
| `/jugadores/{id}`| DELETE     | N/A                                | 204 No Content | N/A               | **404 Not Found** → No se encontró el jugador con id {id}.<br>**500 Internal Server Error** → Ocurrió un error al eliminar el jugador. |






| Endpoint        | Método | Rol         | Descripción       |
| --------------- | ------ | ----------- | ----------------- |
| /jugadores      | GET    | USER, ADMIN | Listar jugadores  |
| /jugadores/{id} | GET    | USER, ADMIN | Obtener jugador   |
| /jugadores      | POST   | ADMIN       | Crear jugador     |
| /jugadores/{id} | PUT    | ADMIN       | Modificar jugador |
| /jugadores/{id} | DELETE | ADMIN       | Eliminar jugador  |
