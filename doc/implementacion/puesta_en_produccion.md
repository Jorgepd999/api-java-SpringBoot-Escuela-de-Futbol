# Puesta en Producción

## Objetivos

- Desplegar la aplicación de forma reproducible.
- Permitir ejecución aislada mediante contenedores.
- Facilitar el despliegue en cualquier entorno (local, servidor o cloud).
- Proporcionar documentación interactiva de la API.
- Permitir futuras mejoras en monitorización y escalabilidad.

Repositorio del proyecto:

https://github.com/Jorgepd999/api-java-SpringBoot-Escuela-de-Futbol.git

---

# Opciones de Ejecución

La aplicación puede ejecutarse de dos formas:

1. Mediante Docker (recomendado para despliegue).
2. De forma local sin contenedor, descargando el código desde GitHub.

---

# 1. Despliegue con Docker Compose

Se utiliza la imagen publicada en Docker Hub:

```
jorgeperez099/academia:v1
```

## docker-compose.yml utilizado

```yaml
services:
  mi-api-rest-academia:
    image: jorgeperez099/academia:v1
    container_name: academia-container
    ports:
      - "8080:8080"
    restart: always
```

## Pasos de despliegue

Clonar el repositorio:

```bash
git clone https://github.com/Jorgepd999/api-java-SpringBoot-Escuela-de-Futbol.git
cd api-java-SpringBoot-Escuela-de-Futbol
```

Ejecutar Docker Compose:

```bash
docker compose up -d
```

Verificar contenedor:

```bash
docker ps
```

---

## Acceso a la Aplicación (Docker)

Base URL:

```
http://localhost:8080
```

### API REST

Los endpoints REST pueden probarse con:

- Postman
- Navegador (para métodos GET)

### Interfaz Web con Thymeleaf

La aplicación incluye vistas renderizadas con Thymeleaf.

Acceso al menú principal:

```
http://localhost:8080/web/menu
```

### Documentación Swagger (OpenAPI)

La API dispone de documentación interactiva mediante Swagger UI.

Acceso:

```
http://localhost:8080/swagger-ui.html
```

o

```
http://localhost:8080/swagger-ui/index.html
```

Desde esta interfaz se pueden:

- Consultar todos los endpoints disponibles.
- Ver los modelos de datos.
- Probar peticiones directamente desde el navegador.

---

## Características del despliegue con Docker

- Imagen versionada.
- Puerto 8080 expuesto.
- Reinicio automático del contenedor (`restart: always`).
- Entorno reproducible en cualquier máquina con Docker instalado.

---

# 2. Ejecución Local sin Docker

También es posible ejecutar la aplicación directamente desde el código fuente.

## Requisitos

- Java 17 (o versión compatible con el proyecto).
- Maven instalado.

## Pasos

Clonar el repositorio:

```bash
git clone https://github.com/Jorgepd999/api-java-SpringBoot-Escuela-de-Futbol.git
cd api-java-SpringBoot-Escuela-de-Futbol
```

Compilar el proyecto:

```bash
mvn clean install
```

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

O ejecutar el JAR generado:

```bash
java -jar target/*.jar
```

---

## Acceso a la Aplicación (Ejecución Local)

Base URL:

```
http://localhost:8080/jugadores
```

Interfaz web:

```
http://localhost:8080/web/menu
```

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

o

```
http://localhost:8080/swagger-ui/index.html
```

---

# Tecnologías Utilizadas

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- OpenAPI / Swagger
- Maven
- Docker

La aplicación funciona tanto como:

- API REST documentada mediante OpenAPI.
- Aplicación web tradicional con renderizado del lado del servidor.

---

# Consideraciones de Escalabilidad

- Despliegue en Kubernetes para alta disponibilidad.
- Uso de balanceador de carga en caso de múltiples instancias.
- Separación futura de servicios si la aplicación crece.
- Posible incorporación de sistema de caché (Redis).

---

# Conclusión

La aplicación está preparada para ejecutarse tanto en entorno local como en entorno contenedorizado, permitiendo portabilidad, reproducibilidad y facilidad de despliegue en diferentes infraestructuras. Además, incorpora documentación interactiva mediante OpenAPI (Swagger), facilitando el consumo y prueba de la API.