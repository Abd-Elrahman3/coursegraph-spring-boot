# API Requirements

## 1. Transport contract

| Method / protocol | Path / operation | Request / headers | Response |
| --- | --- | --- | --- |
| POST | /graphql | GraphQL {query,variables,operationName}; bearer tenant token | 200 data/errors; 400 invalid document; 401 invalid token |
| POST | /api/v1/imports | multipart CSV, max 5MiB; bearer instructor | 202 {jobId,status}; 413 too large |
| GET | /api/v1/imports/{jobId} | bearer owner tenant/instructor | 200 {status,read,written,rejected,errorReportUrl}; 404 |
| GET | /actuator/health/readiness | operations access | 200 ready; 503 dependencies unavailable |

JSON UUIDs and timestamps are strings. Instants use RFC 3339 UTC. Money represented as decimal values must serialize without binary floating-point loss; integer minor units remain integers. Successful entity DTOs expose the documented public model fields, omitting secrets, internal hashes and versioning infrastructure except explicit version/ETag fields. Reject unknown write fields where they could spoof ownership or alter privileged state. Missing required fields, malformed UUIDs and invalid bounds return 400 before side effects. JSON requests use Content-Type: application/json; unsupported content types return 415.

## 2. Authentication and authorization

Validate JWT signature, issuer, expiry/not-before and audience `coursegraph-api` using Spring Security. Use JWT sub for ownership and verified membership claims for tenant context. Do not accept an owner/tenant identity merely because a client sent it in a header or body. Missing/invalid token → 401; missing scope → 403; resources belonging to another owner/tenant → 404. Explicit exceptions: a carrier webhook uses its signature contract; WebSocket uses a scoped one-use ticket. Operations routes require their own scope. Never log credentials.

## 3. Error contract

REST errors use application/problem+json with type,title,status,detail,instance,code and traceId; validation adds fieldErrors:[{field,message}]. Use stable public codes, not exception class names. Domain conflict → 409, not 500. Missing resource → 404. Optimistic version mismatch → 412 where specified. Body limit → 413. Rate limit → 429 with Retry-After. Temporary unavailable dependency → 503 with bounded Retry-After. These general mappings do not override more specific rule contracts above.

Example:

```json
{"type":"urn:problem:business-conflict","title":"Conflict","status":409,"detail":"The requested state transition is not allowed","instance":"/api/v1/resource/example","code":"STATE_CONFLICT","traceId":"example-trace"}
```

GraphQL uses errors[].extensions.code and may return partial data; do not turn every resolver failure into an HTTP 500. gRPC uses canonical status codes and explicit deadlines, with typed error details where needed. Once SSE/WebSocket headers are committed, close or send a documented protocol error rather than attempting to replace the HTTP status.

## 4. Compatibility and limits

REST paths are versioned except /graphql, infrastructure health and the specified WebSocket path. Additive response fields are compatible; changing meaning/nullability/status requires a migration plan. Defaults: page size 20, max 100; stable sort needs a unique tie breaker. Limit request body size and concurrency explicitly. Use client-generated idempotency keys only for endpoints requiring them and preserve the documented scope/retention. A timeout does not prove a remote action failed.

## 5. Required contract tests

For every operation cover success, malformed input, missing resource, duplicate/state conflict and relevant authorization denial. Validate status, headers and response fields, plus absence of unintended DB/broker effects. Document client retry behavior. Test provider callbacks using exact raw bytes and deterministic secrets. Use local simulators rather than paid services.

## 6. GraphQL operation semantics

Required queries: courses(first,after), course(id), myEnrollments(first,after). Required mutations: createCourse(title,clientMutationId), publishCourse(id,clientMutationId), enroll(courseId,clientMutationId), completeLesson(enrollmentId,lessonId,clientMutationId). Course exposes id,title,status,lessons,enrollmentCount. Enrollment exposes id,course,completedLessons,progressPercent. Each connection has edges{cursor,node},pageInfo{endCursor,hasNextPage}. IDs are tenant-scoped by authorization, not client-selected tenant arguments. Use DRAFT/PUBLISHED/ARCHIVED enum. Progress percent is serialized as a decimal string to preserve scale. Enrollment/completion repeat returns the existing effect; clientMutationId is echoed and is not an idempotency key. Add new lessons through the required CSV import operation. Instructor scope courses:manage; learner scope learning:write. Support partial null data according to schema nullability and stable NOT_FOUND/FORBIDDEN/BAD_USER_INPUT/QUERY_TOO_COMPLEX extension codes.

Required nested operation: courses(first:20){edges{node{id title lessons{id title} enrollmentCount}} pageInfo{endCursor hasNextPage}}. This is the <=4 SQL-query budget workload. Request-scoped DataLoader caching must include tenant context.

See [Implementation Labs and Contract Details](IMPLEMENTATION_LABS.md) for concrete fixtures, payload semantics and boundary experiments. These are required, not optional extras.
