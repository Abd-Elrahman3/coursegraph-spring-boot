# Shared Milestones (M1–M3)

Rules are mandatory and cumulative. README section 5 is authoritative. Testing is part of each milestone; the AQA guide is complementary, not an alternative that skips implementation.

## M1 — Domain and invariants

**Branch:** `feature/m1-domain`

**Goal:** Model publication rules; Calculate progress precisely.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-101 | Model publication rules — Publishing an empty course fails unchanged; archiving prevents new enrollment but preserves existing progress. |
| [ ] | BR-102 | Calculate progress precisely — 1 of 3 → 33.33; 2 of 3 → 66.67; duplicate completion does not make 4 of 3. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/M1DomainTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M1.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## M2 — Database and persistence

**Branch:** `feature/m2-database`

**Goal:** Enforce tenant-safe relationships; Layer row-level isolation.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-201 | Enforce tenant-safe relationships — Raw SQL attempting tenant A enrollment into tenant B course fails a constraint. |
| [ ] | BR-202 | Layer row-level isolation — Reuse one pooled connection for alternating tenants; no rows or settings leak. A missing tenant context denies access. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/M2AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M2.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## M3 — Transactional use cases

**Branch:** `feature/m3-transactions`

**Goal:** Implement cursor pagination; Batch nested loads.

**You will practise:** Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-301 | Implement cursor pagination — Insert a newer course between page 1 and page 2; previously seen courses are not duplicated. Changed filter/tenant cursor → BAD_USER_INPUT. |
| [ ] | BR-302 | Batch nested loads — The same operation for 1 vs 20 courses does not grow query count linearly; concurrent tenant requests do not share cache entries. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/coursegraph/acceptance/M3AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M3.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.
