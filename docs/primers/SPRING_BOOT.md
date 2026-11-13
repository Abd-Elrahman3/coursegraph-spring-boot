# Spring Boot Concepts to Reproduce

1. Explain bean creation, constructor injection and component scanning. Show why manually constructing a service bypasses Spring proxies.
2. Run with the condition evaluation report and explain one auto-configuration that matched and one that did not.
3. Bind a validated @ConfigurationProperties record; compare profile defaults with environment overrides.
4. Demonstrate @Transactional self-invocation and rollback behavior. Read-only is a hint/optimization, not authorization.
5. Explain validation at request, domain and database layers. Explain why entity serialization and open-in-view can hide N+1 queries.
6. Compare servlet and reactive request execution; blocking IO on a reactive event loop harms all requests sharing it.
7. Test a configuration slice separately from a full application. Discuss health, readiness and graceful shutdown.

Use the reference documentation matching the pinned version: https://docs.spring.io/spring-boot/3.5/ and https://docs.spring.io/spring-framework/reference/.
