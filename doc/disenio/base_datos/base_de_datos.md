# Diseño de Base de Datos

## Motor de base de datos

Durante el desarrollo se utiliza H2 Database en memoria.

Esto permite:
- Arranque rápido
- No necesidad de instalación externa
- Entorno aislado para pruebas

---

## Modelo de datos

### Entidad: Categoria

Atributos principales:
- id (CategoriaId)
- nombre (String)
- descripcion (String)

Relación:
- Una categoría puede tener múltiples jugadores

---

### Entidad: Jugador

Atributos principales:
- id (JugadorId)
- nombre (String)
- apellidos (String)
- edad (Integer)
- posicion (String)
- categoria (ManyToOne)

---

## Relación

Categoria (1) -------- (N) Jugador

Un jugador pertenece obligatoriamente a una categoría.

---

## Consideraciones técnicas

- Uso de JPA/Hibernate
- Generación automática de tablas
- Claves primarias autogeneradas
- Validación antes de persistencia
