# Database Requirements

## 1. Ownership and schema

PostgreSQL tables tenants(id,name), courses(id,tenant_id FK,title,status,created_at,version), lessons(id,tenant_id,course_id,title,position,required), enrollments(id,tenant_id,course_id,learner_subject,enrolled_at), progress(tenant_id,enrollment_id,lesson_id,completed_at), import_rows(job_id,tenant_id,row_number,status,error_code), plus Spring Batch metadata. Each entity has a UUID PK and UNIQUE(tenant_id,id). Composite FKs prevent cross-tenant relationships, UNIQUE(tenant_id,course_id,position) orders lessons and UNIQUE(tenant_id,course_id,learner_subject) deduplicates enrollment. Add tenant+created_at+id pagination index and progress/enrollment lookup indexes. Migrations run under a separate owner role; app role has limited grants, FORCE ROW LEVEL SECURITY policies where appropriate and no BYPASSRLS. Provide rollback-safe tenant context setup and test with a pool size of one. Redis is optional acceleration, never an authorization source.

## 2. Required artifacts

- ERD with cardinality, PK, FK, nullability and ownership.
- Versioned forward migrations for every constraint/index; no automatic schema update in final configuration.
- Seed fixtures for normal, duplicate, missing-reference and boundary cases.
- Explicit transaction isolation, lock order, timeout and retry policy.
- EXPLAIN (ANALYZE, BUFFERS) for the busiest query before and after an index; include row counts and hardware.
- Upgrade test from a prior schema fixture, not only create-from-empty.
- Backup/restore commands for a disposable destination and SQL integrity checks.

## 3. Testing rules

Run actual PostgreSQL semantics. Use separate connections/processes for concurrent transactions and deterministic barriers; bound all waits. A service-level existence check is not a uniqueness guarantee. If the app relies on a constraint, test direct SQL violating it. Explain any SELECT FOR UPDATE, SKIP LOCKED, RLS, serializable retry or projection checkpoint used here.

## 4. Migration discipline

An applied migration is immutable. Use expand/backfill/contract for incompatible changes, and state how old/new application versions coexist. Separate migration privileges from runtime privileges. Document retention and restore behavior for derived data, deduplication records and secrets. Do not ship real user data in fixtures.

See [Implementation Labs and Contract Details](IMPLEMENTATION_LABS.md) for concrete fixtures, payload semantics and boundary experiments. These are required, not optional extras.
