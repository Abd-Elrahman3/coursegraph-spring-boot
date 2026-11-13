# AQA Track — Mandatory Companion to Development

Unlike the workshop’s choose-one-track arrangement, do these checks alongside the developer track. Backend correctness includes testing.

| Stage | Test work | What it must catch |
| --- | --- | --- |
| A4 after M3 | Domain boundaries and real-database integration | Invalid transitions, unique/FK violations, transaction rollback |
| A5 after D4 | API contract and authorization | Bad payloads, wrong owner/tenant, invalid tokens, error details |
| A6 after D5 | Concurrent and dependency-failure cases | Races, duplicate effects, retry storms, stale cache |
| A7 after D6/D7 | Recovery, load, schema compatibility | Lost intents, unsafe replay, resource growth, broken old clients |

Write a test matrix mapping every BR rule to test class/method and evidence. Use Testcontainers for database-specific semantics, a controlled clock for time, and a mock HTTP server for external dependencies. Assertions should inspect committed state and response semantics. After a test passes, deliberately break the corresponding rule and verify the test fails; revert that experiment and record the result. Do not weaken provided tests to make the build green.

There is no remote grading bot. See ACCEPTANCE_TESTS.md and aqa/API_SPEC.md for this project's cases.
