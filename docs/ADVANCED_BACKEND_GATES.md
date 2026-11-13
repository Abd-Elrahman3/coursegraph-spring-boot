# Advanced Backend Gates

CRUD alone does not complete this project. Every README rule is required, including the following demonstrations.

| Gate | Required demonstration |
| --- | --- |
| D5 | A shallow query with 500 aliases is rejected; repeated fragments cannot evade the budget. |
| D5 | Tenant A and B with matching logical keys see only their data; rolled-back updates do not poison caches. |
| D6 | Stop after chunk 2 of 1,000 rows, restart the same job parameters and produce exactly the valid rows once. |
| D6 | Removing tenant from either a composite FK or a DataLoader key makes a required test fail. |
| D7 | Identify a slow nested resolver in a trace and show an index/query change reducing its time under the same dataset. |
| D7 | Restore tenant A export to an isolated database and prove counts; delete A and prove B’s counts and progress are unchanged. |

## Explain before advancing

1. Which invariant belongs in the domain, database, transport and worker respectively?
2. Where is the transaction boundary, and what happens if the process dies immediately after commit?
3. Which operations can safely retry, and how are duplicates or uncertain results resolved?
4. What is bounded: threads, connections, queues, buffers, retries and query sizes?
5. How is authorization enforced below the controller and across caches/messages?
6. Which metric tells you this system is failing before users report it?
7. How do you restore data and prove correctness after recovery?

Project-specific concepts to defend: Spring for GraphQL, schema design, DataLoader, N+1 queries, cursor pagination, PostgreSQL tenant isolation/RLS, Redis cache scoping, query budgets, Spring Batch.

Record commands and results in evidence files. An owner can alter CI; the gates are an honest learning contract, not tamper-proof certification. Mark incomplete behavior openly.
