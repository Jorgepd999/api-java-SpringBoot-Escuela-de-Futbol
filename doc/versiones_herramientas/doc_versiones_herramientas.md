# Versiones de las herramientas utilizadas

Versión recomendada (ejemplo)
- Java: 17 (LTS)
- Spring Boot: 3.x (según pom.xml)
- Maven: 3.8.x
- PostgreSQL: 15
- Hibernate: versión integradas por Spring Boot
- Testcontainers: último estable compatible con JUnit5
- Docker: 20+
- GitHub Actions: runner ubuntu-latest

Cómo comprobar versiones
- Java: `java -version`
- Maven: `mvn -v`
- PostgreSQL: `psql --version`

Nota: Ajustar las versiones al contenido del `pom.xml` del proyecto. Mantener un archivo `tools-versions.md` actualizado para reproducibilidad.