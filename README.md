# Build and run locally

## Build and Run Backend

```sh
cd backend
docker build -t backend-six:latest .
docker run -p 8080:8080 backend-six:latest
```

## Build and Run frontend

```sh
cd frontend
docker build -f Dockerfile.local -t frontend-six:latest .
docker run -p 3000:80 frontend-six:latest
```

# Improvements

## Helm charts / CI/CD

- Environment (dev, staging, production) based Helm chart overrides
- Ingress(es) and LoadBalancers for backend and frontend if needed
- Running tests in CI before building Docker images
- Automatic Semantic Versioning with tagging (e.g., Commitizen)
- Protected main branch with CI tests and automatic test environments

## Front-end

- Dynamic runtime backend env configuration
- Tests

## Back-end

- Test

# Architecture diagram

>!NB: Not including Ingresses, LoadBalancers, etc.

          +---------------------+
          |                     |
          |      Browser        |
          |                     |
          +---------+-----------+
                    |
                    |
        +-----------+-----------+
        |                       |
        |    Frontend Service   |
        |        (K8s)          |
        +-----------+-----------+
                    |
        +-----------+-----------+
        |  Frontend Deployment   |
        |        (K8s)           |
        +-----------+-----------+
                    |
        +-----------+-----------+
        |  Frontend Docker       |
        |      Container         |
        +-----------+-----------+
                    |
        +-----------+-----------+
        |      Nginx Server      |
        +-----------------------+
                    |
                    |
        +-----------------------+
        |   Backend Service     |
        |        (K8s)          |
        +-----------+-----------+
                    |
        +-----------+-----------+
        |  Backend Deployment    |
        |        (K8s)           |
        +-----------+-----------+
                    |
        +-----------+-----------+
        |  Backend Docker        |
        |      Container         |
        +-----------+-----------+
                    |
        +-----------+-----------+
        | Java Spring Boot App   |
        +-----------------------+
