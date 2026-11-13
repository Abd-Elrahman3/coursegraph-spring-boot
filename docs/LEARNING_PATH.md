# Learning Path

| Order | Project | Format | Main progression |
| --- | --- | --- | --- |
| 1 | [ShelfFlow](https://github.com/Abd-Elrahman3/01-shelfflow-spring-boot) | Unfinished Java starter | Spring IoC and auto-configuration, MVC REST, Bean Validation, JPA mappings, PostgreSQL, Flyway, transactions, pagination, test slices, Testcontainers, Actuator |
| 2 | [SeatLock](https://github.com/Abd-Elrahman3/02-seatlock-spring-boot) | Unfinished Java starter | Spring Security, OAuth2/OIDC JWT resource server, authorization, PostgreSQL locking, idempotency, Redis cache and rate limits, scheduled expiry, optimistic concurrency |
| 3 | [ParcelRelay](https://github.com/Abd-Elrahman3/03-parcelrelay-spring-boot) | Unfinished Java starter | REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing |
| 4 | [CourseGraph](https://github.com/Abd-Elrahman3/04-coursegraph-spring-boot) | Unfinished Java starter | Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch |
| 5 | [FleetStream](https://github.com/Abd-Elrahman3/05-fleetstream-spring-boot) | Unfinished Java starter | Spring WebFlux, Reactor, R2DBC, Kafka, SSE, WebSocket, backpressure, ordering, event time, replay, bounded resources, reactive security and observability |
| 6 | [MarketMesh](https://github.com/Abd-Elrahman3/06-marketmesh-spring-boot) | Requirements only | Architecture from scratch: service boundaries, gRPC/Protobuf, REST, Kafka, sagas, money, distributed idempotency, contract evolution, resilience, OpenTelemetry |
| 7 | [VaultIndex](https://github.com/Abd-Elrahman3/07-vaultindex-spring-boot) | Requirements only | Architecture from scratch: S3-compatible object storage, multipart uploads, Spring Batch, OpenSearch, CDC/outbox, signed URLs, malware quarantine, deletion and retention, multitenancy |
| 8 | [LedgerAtlas](https://github.com/Abd-Elrahman3/08-ledgeratlas-spring-boot) | Requirements only | Architecture from scratch: double-entry ledger, event sourcing, CQRS, serializable transactions, durable workflow, fencing, consistency models, reconciliation, multi-region recovery |

Complete all seven milestones, including failure drills and reflection, before moving on. Suggested pace: 1–3 focused sessions per milestone for projects 1–2, 2–5 for 3–5, and several weeks per independent capstone; use evidence, not elapsed time, to decide readiness.

The first five teach implementation with shrinking support; the last three require design from a blank build. Spring fundamentals recur: bean lifecycle, auto-configuration conditions, profiles, configuration properties, proxy-based AOP/transactions, validation, data access, security, testing and observability. API choices are intentional: REST for resources, webhooks for third-party callbacks, GraphQL for client-driven nested reads, SSE for one-way resumable streams, WebSocket for bidirectional sessions, gRPC for internal typed RPC, and Kafka/RabbitMQ for asynchronous contracts. Do not equate a queue with an HTTP API.

Further study after these projects: Spring Integration, SOAP/WSDL for legacy interoperability, native images/AOT, Kubernetes operators, advanced JVM profiling/GC, deep consensus algorithms and additional databases. These are not prerequisites for the eight-project path.
