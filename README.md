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
  - [GUI]()
    - [UI (vistas)]()
    - [UX (usabilidad)]()
    - [IxD]()
    - [Diagrama navegación]()
    - [Reutilización]()
  - [Arquitectura]()
    - [Despliegue](./doc/arquitectura/despliegue.plantuml)
    - [Componentes](./doc/arquitectura/componente.plantuml)
  - [Diseño de los servicios REST]()
    - [Endpoints Alumnos](./doc/endpoints/alumnos.md)
    - [Endpoints Categorías](./doc/endpoints/categorias.md)
  - [Base de datos]()
  - [Plan de pruebas]()
- [Implementación]()
  - [Entorno de Desarrollo]() 
    - [Puesta en producción]()
- [Capturas de la ejecución de la funcionalidad]()
  - [Ejecución de las pruebas]()
- [Información sobre la versión de las herramientas utilizadas]()
- [Elementos destacables del desarrollo ]()
- [Manual de usuario]()
- [Conclusiones]()
  - [Jorge]()
  - [David]()
- [Bibliografía]()
- [Anexos]()
---

## Cómo ejecutar



```plantuml
title Diagrama de Componentes

package "Módulo Jugadores" as Jugador{

    package "Aplicación" {
        component "JugadorService" as JugadorService
        component "JugadorUseCase" as JugadorUseCase
        component "JugadorCommond" as JugadorCommond
    }

    package "DominioJugador" {
        component "Error" as JugadorError
        component "Model" as JugadorModel
        component "Repository" as JugadorRepository
    }

    package "infraestructura" as ij{
        component "Config" as JugadorConfig
        component "db" as JugadorDb
        component "Mapper" as JugadorMapper
        component "Web" as JugadorWeb
    }


    JugadorUseCase --> JugadorRepository
    JugadorRepository --> JugadorModel
    JugadorRepository --> JugadorError

    Jugador --> SpringData
    Jugador --> Common
}

package "Módulo Common" as Common {

    package "DominioCommon" {
        component "Error" as CommonError
        component "Model" as CommonModel
        component "Repository" as CommonRepository
    }

    package "infraestructura" as iw{
       component "Web" as CommonWeb
    }

    CommonWeb ..> CommonRepository
    CommonRepository --> CommonModel
    CommonRepository --> CommonError
}

package "Spring data" as SpringData{
    component "H2"
}

```