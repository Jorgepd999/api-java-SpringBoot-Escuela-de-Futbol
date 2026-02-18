# GUI — Diseño de Interfaz (UI Visual)

Propósito
- Definir la apariencia visual y las pautas para construir las vistas del cliente que consumirá la API de la Escuela de Fútbol.
- Servir como guía para desarrolladores front-end y diseñadores sobre layout, estilo, componentes visuales y assets.

1. Principios visuales
- Claridad: tipografía legible, jerarquía clara entre títulos, subtítulos y cuerpo.
- Consistencia: sistema único de colores, iconografía y espaciado.
- Legibilidad: contraste suficiente entre texto y fondo (mín. 4.5:1 para texto normal).
- Simplicidad: evitar elementos decorativos que no aporten funcionalidad.

2. Tokens de diseño (ejemplo)
- Colores (ejemplo):
  - Primary: #1E88E5
  - Primary-700: #1565C0
  - Success: #43A047
  - Warning: #F57C00
  - Error: #E53935
  - Surface / Background: #FFFFFF
  - On-surface text: #212121
- Tipografías:
  - Primaria: Inter / Roboto (weights: 400, 500, 700)
  - Tamaños recomendados: h1 28px, h2 22px, h3 18px, body 14px, small 12px
- Espaciado:
  - Base spacing: 8px (multiplicadores: 8, 16, 24, 32)

3. Sistema de layout
- Grid: 12 columnas para desktop; en móvil pasar a 4 o 1 columna.
- Breakpoints sugeridos:
  - Mobile: < 600px
  - Tablet: 600px–1024px
  - Desktop: > 1024px
- Margins/padding: usar tokens (p-2, p-3) en lugar de valores hardcoded.

4. Paleta y tema
- Soporte de tema claro y oscuro con las mismas variables de tokens.
- Evitar uso de color exclusivamente para transmitir información (añadir iconos/labels).

5. Iconografía y assets
- Sistema de íconos: Material Icons o FontAwesome (vectoriales).
- Formato de assets: SVG para iconos; WebP/PNG optimizado para imágenes.
- Nombres de archivos: kebab-case, por ejemplo: icon-add-player.svg

6. Componentes visuales (resumen)
- Botones: primary / secondary / ghost / danger
  - Estados: default, hover, active, disabled, loading
- Cards: para listados o fichas (sombra sutil, border-radius 8px)
- Tables: encabezados fijos, fila hover, acciones en columna final
- Forms: label + input + helper text + error text
- Modal: center/dialog con focus-trap y close con ESC
- Toast/Snackbar: temporales, no intrusivos, duración configurable

7. Estilos de interacción
- Duración de transiciones: 150–200ms
- Efectos: elevation (subtle shadow) para elementos flotantes
- Feedback visual: loader en botones, skeletons en listados

8. Diseño responsivo y adaptativo
- En móvil, transformar tablas en listas/cards con la información esencial.
- Utilizar collapse/accordions para secciones con muchos campos en móvil.
- Mantener acciones primarias accesibles (bottom-floating action button opcional en móviles).

9. Accesibilidad visual
- Labels siempre visibles (no usar placeholders como única etiqueta).
- Foco visible y alto contraste en elemento activo.
- Tamaño objetivo mínimo para botones: 44x44px (según recomendaciones táctiles).

10. Guidelines de contenido y microcopy
- Botones: verbos cortos y claros (Crear, Guardar, Eliminar).
- Mensajes de error: explicar el problema y cómo resolverlo (ej. "El nombre es obligatorio").
- Mensajes de confirmación: breves y directos.

11. Mockups y entregables
- Wireframes de baja fidelidad: layout por vista (Login, Dashboard, Listados, Detalle).
- Mockups de alta fidelidad: para pantallas claves (Detalle Jugador, Formulario).
- Component library / Storybook: documentar estados y variantes de cada componente.

12. Ejemplo rápido de paleta CSS (variables)
```css
:root {
  --color-primary: #1E88E5;
  --color-primary-700: #1565C0;
  --color-success: #43A047;
  --color-error: #E53935;
  --bg-surface: #ffffff;
  --text-primary: #212121;
  --spacing-1: 8px;
  --spacing-2: 16px;
  --border-radius: 8px;
}
```

13. Entregables y próximos pasos
- Crear Storybook con los componentes listados.
- Generar wireframes de baja fidelidad para cada vista (puedo preparar bocetos SVG o enlace a Figma).
- Revisar tokens y adaptarlos según identidad visual final (logo / colores institucionales).

Notas finales
- Este documento define la base visual; las decisiones concretas (paleta final, tipografías licencias) deben validarse con stakeholders antes de implementación.