# Escuela de Fútbol - API

**Versión:** 1.0  
**Integrantes:** 
David Aguilar,
Jorge Perez 

---

## Resumen del proyecto
API para gestionar alumnos y categorías en una escuela de fútbol, con:
- Gestión de entidades `Jugador` y `Categoria` (relación 1:N)
- Persistencia en base de datos con Spring Data JPA
- Validaciones estándar y personalizadas
- Autenticación y autorización con Spring Security
- Caché para consultas frecuentes
- Multilenguaje
- Pruebas unitarias e integración
- Versionado interno de la API
- Documentación automatizada
- Perfiles para diferentes entornos
- Mecanismo de despliegue automatizado

---

## Documentación completa

- [Contexto de la aplicación](./doc/contexto/contexto.md)
  - [Comparativa con otras apps](./doc/comparativa/apps_existentes.md)
    - [Casos de Uso jugadores](./doc/casos_uso/casos_uso_jugadores.md)
    - [Casos de Uso categorias](./doc/casos_uso/casos_uso_categorias.md)
    - [Requisitos F y NF](./doc/requisitos)
      - [Funcional](./doc/requisitos/requisitosFuncionales.md)
      - [No funcional](./doc/requisitos/requisitosNoFuncionales.md)
- [Diseño]()
  - [GUI](./doc/disenio/gui.md)
    - [UI (vistas)](./doc/disenio/ui_vistas.md)
    - [UX (usabilidad)](./doc/disenio/ux_usabilidad.md)
    - [IxD](./doc/disenio/ixd_interaccion.md)
    - [Diagrama navegación](./doc/disenio/diagrama_navegacion.md)
    - [Reutilización](./doc/disenio/reutilizacion.md)
  - [Arquitectura]()
    - [Despliegue](./doc/arquitectura/despliegue.md)
    - [Componentes Global](./doc/arquitectura/componenteGlobal.md)
      - [Componente Jugadores](./doc/arquitectura/componenteJugadores.md)
      - [Componente Categorias](./doc/arquitectura/componenteCategoria.md)
    - [Seguridad (Spring Security)](./doc/arquitectura/seguridad.md)
  - Diseño de los servicios REST
    - [Endpoints Jugadores](./doc/servicios_REST/endpoints/jugadores.md)
    - [Endpoints Categorías](./doc/servicios_REST/endpoints/categorias.md)
  - [Base de datos](./doc/disenio/base_de_datos.md)
  - [Plan de pruebas](./doc/disenio/plan_de_pruebas.md)
- [Implementación]()
  - [Entorno de Desarrollo](./doc/implemetaicon/entorno_desarrollo.md) 
    - [Puesta en producción](./doc/implemetaicon/puesta_en_produccion.md)
- [Capturas de la ejecución de la funcionalidad]()
  - [Ejecución de las pruebas]()
- [Información sobre la versión de las herramientas utilizadas](./doc/versiones_herramientas/versiones_herramientas.md)
- [Elementos destacables del desarrollo ](./doc/elementos_destacables/elementos_destacables.md)
- [Manual de usuario](./doc/manual_usuario/manual_usuario.md)
- [Conclusiones]()
  - [Jorge]()
  - [David]()
- [Bibliografía](./doc/bibliografia/bibliografia.md)
- [Anexos](./doc/anexos/anexos.md)
---

## Cómo ejecutar




