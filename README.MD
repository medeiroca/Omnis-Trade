# 🚀 Omnis-Trade: High-Performance Event-Driven Exchange

A state-of-the-art, cloud-native trading platform built to demonstrate mastery over **Distributed Systems**, **Event Sourcing**, and **Observability** in the 2026 tech landscape.

This project implements a reactive currency exchange engine leveraging the full power of the Spring ecosystem, Axon Framework, and the LGTM observability stack.

## 🏗️ The Tech Stack

| Category           | Technology                                                            |
|:-------------------|:----------------------------------------------------------------------|
| **Framework** | Spring Boot 3.4+ / Spring Cloud Gateway (Reactive & Non-blocking)     |
| **Architecture** | CQRS & Event Sourcing with **Axon Framework**                         |
| **Observability** | **OpenTelemetry**, Prometheus, Grafana, Jaeger, Loki (LGTM Stack)      |
| **Resilience** | **Resilience4j** (Circuit Breaker, Rate Limiter, Retry)               |
| **Security** | Spring Security, **OAuth2**, Keycloak (JWT)                           |
| **Persistence** | PostgreSQL (Write/Event Store), Redis (Read Cache), **Flyway**        |
| **Messaging** | Apache Kafka / Axon Server                                            |
| **Infrastructure** | **Testcontainers**, Docker Compose, GraalVM Native Image (AOT)        |

---
## 📐 System Architecture

The project follows a Hexagonal Architecture (Ports and Adapters) combined with a reactive Edge Gateway:

[User] -> [Spring Cloud Gateway (Auth/Rate Limit)] -> [Kafka/Axon Server] -> [Core Trading Service (Axon Aggregate)]
|
[LGTM Stack Monitoring]
---
## 🎯 Project Objectives

1.  **Strict CQRS & Event Sourcing:** Complete separation of read and write concerns, ensuring a 100% auditable financial history using Axon.
2.  **Full-Spectrum Observability:** Implementing a "Single Pane of Glass" view where traces, logs, and metrics are correlated via OpenTelemetry.
3.  **Resilience by Design:** Protecting internal services from external API instability using sophisticated fault-tolerance patterns.
4.  **Security at the Edge:** Centralized authentication and RBAC (Role-Based Access Control) at the Gateway level.
5.  **Cloud-Native Performance:** Leveraging Spring AOT for GraalVM Native Images to achieve sub-second startup times and minimal memory footprint.

---

## 🗺️ Roadmap & Evolution

### Phase 1: The Observability Foundation (Current)
- [x] Setup Docker Compose with **Observability Stack** (Loki, Grafana, Jaeger, Prometheus).
- [x] Configure **OpenTelemetry Collector** for cross-service telemetry.
- [x] Implement **Spring Cloud Gateway** as the unified entry point.

### Phase 2: Domain Core & Event Sourcing
- [x] Initialize Trade Service with Spring Boot 3.5.2 and Java 21.
- [x] Implement the Trade Aggregate using Axon Framework.
- [x] Configure Jackson Serialization for Java Records support in Axon.
- [x] Connect and verify Axon Server as the Event Store and Message Router.
- [ ] Implement R2DBC Projection to persist trades in PostgreSQL.
- [ ] Setup Flyway/R2DBC for relational schema versioning.


### Phase 3: Security & Resilience
- [ ] Integrate **Keycloak** for OAuth2 Identity Management.
- [ ] Apply **Resilience4j** decorators on external service clients.
- [ ] Implement Global Exception Handling with correlated Trace IDs.

### Phase 4: High-Performance & Testing
- [ ] Create Integration Tests using **Testcontainers** (Postgres, Kafka, Keycloak).
- [ ] Optimize for **Spring Native** (GraalVM).
- [ ] Benchmark JVM vs Native Image performance.

---

## 🛠️ Getting Started (Local Environment)

### Prerequisites
* Java 21+
* Docker & Docker Compose
* GraalVM (Optional, for Native builds)

### Running the Infrastructure
```bash
docker-compose up -d
```

### 🔍 Observability Access
*   **Grafana (Centralized):** [http://localhost:3000](http://localhost:3000) (Use the **Explore** tab with **Jaeger** datasource)
*   **Jaeger UI (Traces):** [http://localhost:16686](http://localhost:16686)
*   **Prometheus (Metrics):** [http://localhost:9090](http://localhost:9090)
*   **Axon Dashboard:** [http://localhost:8024](http://localhost:8024)