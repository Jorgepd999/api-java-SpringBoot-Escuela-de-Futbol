# UX — Usabilidad

Objetivo
- Establecer las reglas y criterios de usabilidad que guiarán el diseño de la interfaz.

Principios UX aplicados
- Consistencia: patrones de interacción coherentes.
- Minimizar la carga cognitiva: mostrar solo lo necesario, orden lógico y grouping visual.
- Familiaridad: usar patrones conocidos (botones en el lugar esperado, iconos comunes).
- Feedback inmediato: confirmar acciones con toasts/snackbars y cambiar estados visuales.
- Recuperabilidad: facilitar deshacer acciones cuando sea posible (ej. soft delete).

Patrones de interacción clave
- Acciones primarias: resaltar el botón principal (Guardar, Crear) con color distintivo.
- Confirmaciones: modal antes de acciones destructivas (Eliminar).
- Indicadores de estado:
  - Spinner en botones mientras se realiza petición.
  - Barra de progreso en operaciones largas.
- Errores y ayuda:
  - Mensajes claros (qué pasó y cómo solucionarlo).
  - Mostrar validaciones asociadas a cada campo.

Formularios
- Agrupación lógica de campos (fieldset / secciones).
- Validación progresiva (inline) antes de submit.
- Autoenfoque en el primer campo válido al abrir un formulario.
- Uso de placeholders solo como ejemplo, no como sustituto de label.

Navegación
- Breadcrumbs en vistas de detalle para facilitar contexto.
- Accesos rápidos desde dashboard para tareas frecuentes.
- Mantener rutas claras y RESTful para facilitar deep linking.

Performance percibida
- Carga optimizada: lazy-loading de vistas no esenciales.
- Skeletons / placeholders para listados mientras se cargan datos.
- Reducir cantidad de llamadas innecesarias (debounce en búsquedas).

Métricas UX recomendadas
- Tiempo a primera interacción (TTFI)
- Tasa de éxito de tareas críticas (crear jugador, asignar categoría)
- Error rate en formularios
- Feedback cualitativo (encuestas cortas in-app)

Pruebas de usabilidad
- Sesiones de 5-7 usuarios con tareas concretas (crear jugador, encontrar categoría).
- Observación de flujos y puntos de fricción.
- Iterar diseño en base a pruebas.

Localización e internacionalización
- Mensajes y formatos locales (fechas, números).
- Evitar textos largos en botones; pensar en expansión de cadenas traducidas.

Conclusión
- UX orientada a tareas: reducir pasos para operaciones comunes y dar feedback claro.