# Developer Track (D4–D7)

Rules are mandatory and cumulative. README section 5 is authoritative. Testing is part of each milestone; the AQA guide is complementary, not an alternative that skips implementation.

## D4 — API contracts and authorization

**Branch:** `feature/d4-api`

**Goal:** Implement the GraphQL schema; Authorize fields and mutations.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-401 | Implement the GraphQL schema — GraphQlTester verifies nullability, aliases, variables and partial data without exposing stack traces. |
| [ ] | BR-402 | Authorize fields and mutations — An alias and a nested resolver cannot fetch another tenant’s enrollment or another learner’s private progress. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/D4AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D4.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D5 — Advanced behavior and resource limits

**Branch:** `feature/d5-advanced`

**Goal:** Bound query cost; Cache with tenant-aware invalidation.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-501 | Bound query cost — A shallow query with 500 aliases is rejected; repeated fragments cannot evade the budget. |
| [ ] | BR-502 | Cache with tenant-aware invalidation — Tenant A and B with matching logical keys see only their data; rolled-back updates do not poison caches. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/D5AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D5.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D6 — Failure testing and recovery

**Branch:** `feature/d6-failures`

**Goal:** Restart bulk imports; Test security and query shape.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-601 | Restart bulk imports — Stop after chunk 2 of 1,000 rows, restart the same job parameters and produce exactly the valid rows once. |
| [ ] | BR-602 | Test security and query shape — Removing tenant from either a composite FK or a DataLoader key makes a required test fail. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/D6AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D6.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D7 — Operations and design defense

**Branch:** `feature/d7-operations`

**Goal:** Observe GraphQL safely; Evolve the schema without breaking clients.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-701 | Observe GraphQL safely — Identify a slow nested resolver in a trace and show an index/query change reducing its time under the same dataset. |
| [ ] | BR-702 | Evolve the schema without breaking clients — Restore tenant A export to an isolated database and prove counts; delete A and prove B’s counts and progress are unchanged. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/D7AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D7.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.
