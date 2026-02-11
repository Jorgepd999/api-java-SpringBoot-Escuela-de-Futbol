# Diseño de la Base de Datos

Resumen
- Entidades principales: `Jugador`, `Categoria`
- Relación: 1 Categoria : N Jugadores
- Persistencia: JPA / Hibernate (esquema generado a partir de las entidades)
- Motor de BD recomendado: PostgreSQL (puede usarse H2 para desarrollo)

Modelo lógico (tablas principales)
- categoria
  - id (BIGSERIAL) PK
  - nombre (VARCHAR, UNIQUE, NOT NULL)
  - descripcion (TEXT, NULL)
  - fecha_creacion (TIMESTAMP, NOT NULL, DEFAULT now())
  - activo (BOOLEAN, NOT NULL, DEFAULT true)

- jugador
  - id (BIGSERIAL) PK
  - nombre (VARCHAR, NOT NULL)
  - apellidos (VARCHAR, NULL)
  - fecha_nacimiento (DATE, NULL)
  - dorsal (INT, NULL)
  - posicion (VARCHAR, NULL)
  - categoria_id (BIGINT) FK -> categoria(id)
  - fecha_alta (TIMESTAMP, NOT NULL, DEFAULT now())
  - activo (BOOLEAN, NOT NULL, DEFAULT true)

Restricciones y relaciones
- FK jugador.categoria_id -> categoria.id (ON DELETE RESTRICT)
- Índices:
  - UNIQUE(categoria.nombre)
  - índice sobre jugador(categoria_id)
  - índice compuesto sugerido: jugador(activo, categoria_id) si consultas frecuentes por categoría y estado

DDL de ejemplo (PostgreSQL)
```sql
CREATE TABLE categoria (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL UNIQUE,
  descripcion TEXT,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT now(),
  activo BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE jugador (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellidos VARCHAR(150),
  fecha_nacimiento DATE,
  dorsal INT,
  posicion VARCHAR(50),
  categoria_id BIGINT REFERENCES categoria(id) ON DELETE RESTRICT,
  fecha_alta TIMESTAMP NOT NULL DEFAULT now(),
  activo BOOLEAN NOT NULL DEFAULT true
);

CREATE INDEX idx_jugador_categoria ON jugador(categoria_id);
CREATE INDEX idx_jugador_activo_categoria ON jugador(activo, categoria_id);
```

Normalización y comentarios
- El diseño es 3NF: atributos atómicos, claves claras.
- Si se requiere historial de cambios, considerar tabla audit (o usar Hibernate Envers).

Migraciones
- Recomiendo usar Flyway o Liquibase.
- Estructura sugerida:
  - db/migrations/V1__create_tables.sql
  - db/migrations/V2__add_indices.sql

Mapeo JPA (sugerido)
- Categoria: @Entity, @Table("categoria"), OneToMany(mappedBy="categoria")
- Jugador: @Entity, @Table("jugador"), @ManyToOne @JoinColumn("categoria_id")

Consideraciones de diseño
- Manejar soft-delete con `activo` para conservar historial.
- Validaciones a nivel BD (NOT NULL, UNIQUE) y a nivel aplicación (bean validation).
- Internacionalización: almacenar textos fijos en la aplicación (no en BD) o añadir tablas i18n si hace falta.