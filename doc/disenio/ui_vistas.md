# UI — Vistas

Objetivo
- Documentar las pantallas (vistas) principales, sus elementos y comportamiento esperado.

Listado de vistas y descripción

1. Login
- Elementos:
  - Inputs: usuario/email, contraseña
  - Botones: Iniciar sesión, Recuperar contraseña
  - Enlaces: Registro (si aplica)
- Comportamiento:
  - Validación de campos obligatorios
  - Mostrar errores de autenticación (401)
  - Redirección a Dashboard al iniciar sesión

2. Dashboard / Home
- Elementos:
  - Tarjetas KPI: total categorías, jugadores activos, últimos registros
  - Acciones rápidas: botones para crear categoría/jugador
  - Resumen de actividad (últimas 5 acciones)
- Comportamiento:
  - Accesos directos a listados y búsquedas

3. Listado de Categorías
- Elementos:
  - Tabla o grid con columnas: nombre, descripción, #jugadores, acciones (ver, editar, eliminar)
  - Búsqueda por nombre, filtro activo/inactivo, paginación
  - Botón Crear categoría
- Comportamiento:
  - Ordenación por columnas
  - Paginación con tamaño configurable

4. Detalle de Categoría
- Elementos:
  - Ficha con datos de la categoría
  - Listado paginado de jugadores de la categoría
  - Botones: Editar, Eliminar, Añadir Jugador
- Comportamiento:
  - Navegación a detalle de jugador desde el listado

5. Listado de Jugadores
- Elementos:
  - Tabla con: nombre, apellidos, dorsal, posición, categoría, fecha alta, acciones
  - Filtros: categoría, posición, activo, búsqueda por nombre
  - Botón Crear jugador
- Comportamiento:
  - Selección múltiple para acciones en lote (activar/desactivar, borrar soft)

6. Detalle Jugador
- Elementos:
  - Ficha con datos personales y deportivos
  - Botones Editar, Eliminar, Volver
- Comportamiento:
  - Visualización clara de categoría asociada (enlace a la categoría)

7. Formulario Crear/Editar (modal o página)
- Elementos:
  - Campos: nombre, apellidos, fecha nacimiento (datepicker), dorsal, posición (select), categoría (select)
  - Validaciones inline y mensajes desplegables
  - Botones Guardar / Cancelar
- Comportamiento:
  - Validación antes de enviar
  - Indicación de campos obligatorios

8. Panel de Administración (opcional)
- Elementos:
  - Gestión de usuarios y roles
  - Auditoría y logs

Recomendaciones visuales
- Usar tablas responsivas: pasar a cards en móvil.
- Preferir iconografía clara con texto en botones críticos.
- Espaciamiento consistente y uso de tokens para tipografías/colores.

Mockups / Wireframes
- Crear wireframes de baja fidelidad para cada vista.
- Opcional: prototipo interactivo en Figma o similar.

Accesibilidad
- Labels visibles, placeholders auxiliares.
- Foco lógico en navegación con teclado.
- Mensajes de error narrables por lectores de pantalla.

Notas de implementación
- Separar vistas (pages) de componentes (reusables).
- Cada vista debe consumir los servicios API a través de un client centralizado.