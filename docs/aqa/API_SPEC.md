# API Test Specification

The authoritative contract is [API Requirements](../API_REQUIREMENTS.md). Build a test matrix for all 4 operations.

For each: test successful response/status/headers, malformed payload, boundary values, missing resource, duplicate request, authorization denial and relevant unavailable dependency. Check database side effects after rejection. Use exact request bytes for signatures, real JWT validation tests for issuer/audience, and protocol-specific assertions for GraphQL/gRPC/streaming.

| Rule | Required sample |
| --- | --- |
| BR-401 | GraphQlTester verifies nullability, aliases, variables and partial data without exposing stack traces. |
| BR-402 | An alias and a nested resolver cannot fetch another tenant’s enrollment or another learner’s private progress. |
| BR-501 | A shallow query with 500 aliases is rejected; repeated fragments cannot evade the budget. |
| BR-502 | Tenant A and B with matching logical keys see only their data; rolled-back updates do not poison caches. |

Do not call real carrier/payment/customer services. Build deterministic local provider fixtures and record request counts and idempotency keys.
