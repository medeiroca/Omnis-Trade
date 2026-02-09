# Omnis-Trade: High-Performance Event-Driven Exchange

A state-of-the-art, cloud-native trading platform built to demonstrate mastery over Distributed Systems, Event Sourcing, and advanced Observability in the modern tech landscape.

This project implements a reactive currency exchange engine leveraging the full power of the Spring ecosystem, Axon Framework, and the LGTM observability stack (Loki, Grafana, Tempo, Prometheus).

## Tech Stack

| Category | Technology |
|:---|:---|
| **Framework** | Spring Boot 3.4+ / Spring Cloud Gateway (Reactive Stack) |
| **Architecture** | CQRS & Event Sourcing via Axon Framework |
| **Observability** | OpenTelemetry, Prometheus, Grafana, Jaeger, Loki (LGTM Stack) |
| **Resilience** | Resilience4j (Circuit Breaker, Rate Limiter, Retry) |
| **Security** | Spring Security, OAuth2, Keycloak (JWT) |
| **Persistence** | PostgreSQL (Write/Event Store), Redis (Read Cache), Flyway |
| **Data Access** | R2DBC (Reactive & Non-blocking Persistence) |
| **Messaging** | Apache Kafka / Axon Server |
| **Infrastructure** | Testcontainers, Docker Compose, GraalVM Native Image (AOT) |

---

## System Architecture

The project follows a Hexagonal Architecture (Ports and Adapters) combined with a reactive Edge Gateway for traffic management and security.

---

## Project Objectives

1. **Strict CQRS & Event Sourcing:** Complete separation of read and write concerns, ensuring a 100% auditable financial history using Axon's Event Store.
2. **Full-Spectrum Observability:** Implementation of correlated telemetry where traces, logs, and metrics are integrated via OpenTelemetry into a single pane of glass.
3. **Reactive Persistence:** Leveraging R2DBC to ensure the data flow from the database to the end client remains entirely non-blocking.
4. **Resilience by Design:** Protecting against cascading failures using fault-tolerance patterns for both internal and external services.
5. **Cloud-Native Performance:** Optimization via Spring AOT for GraalVM execution, targeting low memory footprint and near-instant startup times.

---

## Roadmap & Evolution

### Phase 1: Foundation & Observability
- [x] Setup Docker Compose with LGTM Stack.
- [x] Configure OpenTelemetry Collector for cross-service telemetry.
- [x] Implement Spring Cloud Gateway as the unified entry point.

### Phase 2: Domain Core & Persistence
- [x] Initialize Trade Service (Spring Boot 3.4+ / Java 21).
- [x] Implement the Trade Aggregate (Write Side) with Axon.
- [x] Configure Reactive Projections with R2DBC and PostgreSQL.
- [x] Database versioning with Flyway and manual ID support (Persistable).
- [x] Data exposure via DTOs in reactive controllers.

### Phase 3: Quality & Testing Infrastructure
- [ ] Implement integration tests using **Testcontainers** (Postgres and Axon).
- [ ] Implement Subscription Queries for real-time updates (SSE).
- [ ] Global Exception Handling with correlated Trace IDs.

### Phase 4: Resilience & Performance
- [ ] Decorate external clients with Resilience4j.
- [ ] Optimize for GraalVM Native Image.
- [ ] Benchmark JVM vs Native Image performance.

---

## Local Environment Setup

### Prerequisites
* Java 21+
* Docker & Docker Compose
* GraalVM (Optional)

### Running the Infrastructure
```bash
docker-compose up -d
```

## Monitoring Endpoints
- Grafana: http://localhost:3000 (Telemetry Dashboards)
- Jaeger UI: http://localhost:16686 (Distributed Tracing)
- Prometheus: http://localhost:9090 (Metrics)
- Axon Dashboard: http://localhost:8024 (Message Routing & Event Store)