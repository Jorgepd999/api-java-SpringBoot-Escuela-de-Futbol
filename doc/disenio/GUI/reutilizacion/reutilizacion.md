# Reutilización de componentes

Objetivo
- Definir componentes reutilizables y estrategias para crear una librería de UI mantenible y coherente.

Componentes atómicos y compuestos
- Átomos:
  - Button, Icon, Input, Select, Checkbox, Radio, Label, Avatar
- Moléculas:
  - FormField (Label + Input + Error), ModalHeader, TableRow
- Organismos:
  - DataTable, FormModal, CardList
- Templates / Pages:
  - PageWithSidebar, DashboardLayout

Lista de componentes recomendados
- FormInput: input con label, hint, error, required flag
- FormSelect: select con search opcional
- DatePicker: wrapper con formato localizable
- DataTable: soporte sorting, pagination, rowActions
- Modal: header/body/footer + accessible focus trap
- Toast/Snackbar: niveles (success, info, warning, error)
- ConfirmDialog: reusable para acciones destructivas
- Badge: para estados (activo, inactivo)
- EmptyState: para listados vacíos con CTA

Estrategia de desarrollo
- Carpeta central: src/components (organizada por atomo/molecula/organismo)
- Documentación: Storybook para catálogo y pruebas visuales
- Tests: snapshot + accessibility (axe) por componente

Theming y tokens
- Variables globales (CSS variables o design tokens) para colores, tamaños, tipografías.
- Soporte de temas: light/dark mediante provider de contexto.

Publicación y reutilización entre proyectos
- Empaquetar librería de componentes como paquete npm privado o repo mono-repo si se va a reutilizar en otros proyectos.
- Versionado semántico (semver) de la librería.

Buenas prácticas
- Componentes sin lógica de negocio (solo UI y callbacks).
- Evitar estilos inline; usar clases/variables temáticas.
- Documentar props y contratos claramente (Typescript types / PropTypes).
- Accesibilidad integrada (labels, roles, aria-*).

Ejemplo de estructura de carpetas
- src/components/
  - atoms/
  - molecules/
  - organisms/
  - templates/
  - hooks/
  - styles/
  - utils/

Workflow
- Añadir componente → escribir story → tests visuales y unitarios → publicar / merge