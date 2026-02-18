# IxD — Interacción (Interaction Design)

Propósito
- Definir microinteracciones, animaciones y comportamiento interactivo que aporten claridad y placer de uso sin distraer.

Microinteracciones recomendadas
- Formularios:
  - Validación en tiempo real con micro-feedback (icono + texto).
  - Animación sutil al aparecer errores (shake o fade).
- Creación/Eliminación:
  - Animación al insertar un nuevo elemento (fade + highlight).
  - Para eliminación: modal con animación y posibilidad de “Deshacer” vía snackbar.
- Carga y estado:
  - Skeletons en listados en lugar de spinners globales.
  - Indicador inline en botones (spinner pequeño dentro del botón).

Transiciones
- Transiciones cortas (150–250ms) para navegación entre vistas para mantener sensación de respuesta.
- Evitar transiciones largas que retrasen la interacción.

Acciones primarias y secundarias
- Asegurar contraste y jerarquía visual entre acción primaria (Guardar/Crear) y secundarias (Cancelar).
- Disposición consistente (primaria a la derecha en formularios modales/páginas).

Feedback y confirmaciones
- Uso de snackbars para notificaciones temporales (éxito, aviso, error).
- Banners persistentes para información crítica (mantenimiento, permisos).

Estados del control
- Deshabilitar botones cuando la acción no es válida o mientras se procesa.
- Indicadores claros para inputs deshabilitados y estados de solo lectura.

Mecanismos de ayuda
- Tooltips con atajos o explicaciones de campos complejos.
- Inline help para campos que requieren formato o reglas específicas.

Accesibilidad en interacción
- Todas las interacciones deben ser navegables por teclado.
- Focus visible y orden del tab correcto.
- Animaciones respetuosas (prefers-reduced-motion).

Patrones de recuperabilidad
- Undo para operaciones no destructivas.
- Guardado automático con indicador si corresponde (ej. drafts) y posibilidad de revertir.

Documentación y especificaciones
- Cada microinteracción debe describirse en Stories/Component docs (ej. Storybook) con estados: default, hover, active, loading, error, disabled.