# Acceptance Tests

Every row is mandatory. M1 includes provided examples in starters; later test skeletons must become real behavior tests. Test names below are descriptions, not a hidden API.

| Milestone | Rule | Scenario and expected result |
| --- | --- | --- |
| M1 | BR-101 | Publishing an empty course fails unchanged; archiving prevents new enrollment but preserves existing progress. |
| M1 | BR-102 | 1 of 3 → 33.33; 2 of 3 → 66.67; duplicate completion does not make 4 of 3. |
| M2 | BR-201 | Raw SQL attempting tenant A enrollment into tenant B course fails a constraint. |
| M2 | BR-202 | Reuse one pooled connection for alternating tenants; no rows or settings leak. A missing tenant context denies access. |
| M3 | BR-301 | Insert a newer course between page 1 and page 2; previously seen courses are not duplicated. Changed filter/tenant cursor → BAD_USER_INPUT. |
| M3 | BR-302 | The same operation for 1 vs 20 courses does not grow query count linearly; concurrent tenant requests do not share cache entries. |
| D4 | BR-401 | GraphQlTester verifies nullability, aliases, variables and partial data without exposing stack traces. |
| D4 | BR-402 | An alias and a nested resolver cannot fetch another tenant’s enrollment or another learner’s private progress. |
| D5 | BR-501 | A shallow query with 500 aliases is rejected; repeated fragments cannot evade the budget. |
| D5 | BR-502 | Tenant A and B with matching logical keys see only their data; rolled-back updates do not poison caches. |
| D6 | BR-601 | Stop after chunk 2 of 1,000 rows, restart the same job parameters and produce exactly the valid rows once. |
| D6 | BR-602 | Removing tenant from either a composite FK or a DataLoader key makes a required test fail. |
| D7 | BR-701 | Identify a slow nested resolver in a trace and show an index/query change reducing its time under the same dataset. |
| D7 | BR-702 | Restore tenant A export to an isolated database and prove counts; delete A and prove B’s counts and progress are unchanged. |

## Failure drills

1. Alternate tenants through a one-connection pool.
2. Compare nested query SQL counts for 1 and 20 courses.
3. Crash a CSV import between chunks and restart it.

## Evidence standard

Record setup, exact command, controlled failure point, durable before/after state, expected result and actual result. A test that only asserts an exception or mocks all persistence cannot prove a database invariant. Use bounded timeouts and deterministic coordination; avoid sleeps as a race strategy. Record a seed for randomized tests. Do not turn an unavailable Docker dependency into a silently skipped passing test.

For D6, deliberately introduce one representative bug and verify a test detects it. For D7, record machine configuration, dataset, concurrency, p50/p95/p99, throughput, errors and resource usage. Restore tests use a different database from the source.
