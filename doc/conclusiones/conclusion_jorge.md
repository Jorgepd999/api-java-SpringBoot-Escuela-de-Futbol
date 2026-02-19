# Conclusión – Análisis DAFO

Para concluir el desarrollo del proyecto *Escuela de Fútbol - API*, realizo un análisis DAFO que me permite evaluar el trabajo realizado desde una perspectiva crítica.

## Fortalezas

Considero que una de las principales fortalezas del proyecto es la arquitectura en capas bien organizada, lo que facilita la comprensión y el mantenimiento del código.
Además, la integración de Swagger para documentar la API, la generación de PDF y la internacionalización son funcionalidades que aportan valor añadido y demuestran un nivel técnico superior al mínimo requerido.
También destaco el uso de un DevContainer, que mejora la portabilidad del entorno.

## Debilidades

La principal debilidad es que no se ha implementado seguridad real (autenticación y autorización), aunque sí se ha documentado su posible integración.
Otra limitación es el uso de H2 en memoria, lo que impide que la aplicación esté lista para un entorno de producción sin ajustes adicionales.

## Oportunidades

El proyecto tiene gran potencial de ampliación: se podría integrar Spring Security con roles, migrar a una base de datos como PostgreSQL y desarrollar un frontend más avanzado que consuma la API.
La arquitectura actual permite escalar fácilmente sin rehacer el sistema.

## Amenazas

Existen soluciones comerciales más completas en el mercado, y si no se implementan mejoras de seguridad, la aplicación podría presentar vulnerabilidades en un entorno real.

---

## Conclusión final

En general, considero que el proyecto cumple los objetivos planteados y demuestra una buena aplicación de los conceptos trabajados en clase. Aunque existen aspectos mejorables, la base desarrollada es sólida y permite una evolución futura sin necesidad de rediseñar la estructura principal.
