# Puesta en Producción

Objetivos
- Desplegar la API de forma reproducible, segura y monitorizada.

Estrategia de despliegue (opciones)
1. Docker + Docker Compose (pequeñas infraestructuras)
   - Contenedor de la aplicación
   - Contenedor de PostgreSQL (o servicio gestionado)
   - Ejemplo docker-compose.yml mínimo:
```yaml
version: '3.8'
services:
  app:
    image: jornada/escuela-api:latest
    ports:
      - "8080:8080"
    environment:
      SPRING_PROFILES_ACTIVE: prod
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/escuela_db
      SPRING_DATASOURCE_USERNAME: pguser
      SPRING_DATASOURCE_PASSWORD: pgpass
    depends_on:
      - db
  db:
    image: postgres:15
    environment:
      POSTGRES_DB: escuela_db
      POSTGRES_USER: pguser
      POSTGRES_PASSWORD: pgpass
    volumes:
      - pgdata:/var/lib/postgresql/data
volumes:
  pgdata:
```

2. Kubernetes (recomendado para producción escalable)
   - Deployments + Services + ConfigMaps + Secrets
   - Ingress + TLS para exponer la API
   - Habilitar readiness/liveness probes

CI/CD
- Pipeline sugerido (GitHub Actions / GitLab CI):
  - build → test → build image → push image al registry → desplegar en staging → pruebas E2E → promover a prod
- Repositorio de imágenes: Docker Hub, GitHub Packages o registry privado

Seguridad y operaciones
- Secrets: almacenar credenciales en Secret Manager (K8s Secrets, Vault, etc.)
- HTTPS obligatorio: configurar TLS en Ingress o load balancer
- Backups: programar dumps periódicos de la BD y testear restauraciones
- Monitorización: Prometheus + Grafana, logs centralizados (ELK / Loki)
- Alertas: configurar alertas de errores altos o caídas de instancias

Rollback
- Mantener versiones de despliegue y usar despliegues con política de rollback (K8s roll back por replicaset)

Consideraciones de escalabilidad
- Separar base de datos gestionada (RDS, Cloud SQL) para tolerancia y backups
- Habilitar cache (Redis) si lecturas frecuentes de listados