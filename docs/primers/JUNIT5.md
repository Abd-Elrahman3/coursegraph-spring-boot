# JUnit 5 and Test Design

JUnit assertions should describe a business guarantee. A good test names a scenario, controls time/input, calls one use case and asserts the durable outcome. Use assertThrows for rejected commands and then assert that state did not change. Use parameterized tests for decision tables. Give race tests barriers and deadlines, not sleeps.

Use Clock.fixed(instant, ZoneOffset.UTC); do not make tests depend on the wall clock. Unit tests isolate domain rules, slice tests isolate transport/persistence, and a few integration tests cross real boundaries. Testcontainers requires Docker. A mock repository cannot prove PostgreSQL isolation or a unique constraint.

In starters, tags select milestones: default `structure`; profile `learning` accepts `-Dmilestone.groups=structure,M1,M2`. Provided TODO failures are exercises, not ignored tests. See https://junit.org/junit5/docs/current/user-guide/ and https://java.testcontainers.org/.
