# Entorno de Desarrollo

Requisitos locales
- Java JDK 17 (o la versión indicada en pom.xml)
- Maven 3.8+
- Docker (opcional, recomendado para DB con Testcontainers o para ejecutar Postgres)
- IDE recomendado: IntelliJ IDEA / VSCode (con plugin Spring Boot)

Preparación
1. Clonar el repositorio
   ```
   git clone https://github.com/Jorgepd999/api-java-SpringBoot-Escuela-de-Futbol.git
   cd api-java-SpringBoot-Escuela-de-Futbol
   ```

2. Variables de entorno / application.properties
- Perfil `application-dev.yml` (ejemplo):
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/escuela_db
    username: pguser
    password: pgpass
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
server:
  port: 8080
```
- Para desarrollo local con H2:
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:escuela;DB_CLOSE_DELAY=-1
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: create-drop
```

3. Iniciar la base de datos
- Con Docker:
  ```
  docker run --name escuela-postgres -e POSTGRES_USER=pguser -e POSTGRES_PASSWORD=pgpass -e POSTGRES_DB=escuela_db -p 5432:5432 -d postgres:15
  ```

4. Build y ejecución
- Desde línea de comandos:
  ```
  ./mvnw clean package
  ./mvnw spring-boot:run
  ```
- O ejecutar desde el IDE la clase con @SpringBootApplication

Depuración
- Habilitar logs SQL (spring.jpa.show-sql=true)
- Puntos de entrada: controladores en paquete ...controller, servicios en ...service

Buenas prácticas
- Usar perfiles (`dev`, `test`, `prod`)
- No poner credenciales en repositorio: usar variables de entorno o .env local no versionado