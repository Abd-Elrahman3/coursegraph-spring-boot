# Implementation Labs and Contract Details

These details are part of the requirements and refine the README rules.

## Tenant fixture

Create two tenants, each with an instructor and learner. JWT contains a verified tenant_id and membership; request tenant selection must be checked against that membership. Audience coursegraph-api; courses:manage creates/publishes/imports courses, learning:write enrolls/completes lessons. Create 20 courses per tenant with 5 lessons each and enroll one learner in each. Add createdAt to persistence/course query DTOs as needed for keyset pagination; the provided constructor may remain as a convenience overload for domain tests.

## CSV import contract

UTF-8 CSV header is courseId,title,position,required. courseId is UUID, title 1..200 trimmed characters, position>=1, required is true/false. Tenant comes exclusively from authenticated context. File max 5MiB, max 10,000 data rows. Missing/wrong header rejects the job before writes; malformed data rows become rejection report entries containing rowNumber,code,message. Duplicate (courseId,position) rows are rejected; first successfully committed row wins. All referenced courses must be DRAFT and belong to the tenant. Error report download requires current tenant/instructor authorization. Import status: QUEUED,RUNNING,COMPLETED,FAILED; counters satisfy read=written+rejected on completion.

## Pagination and GraphQL semantics

Use the input wrappers in api/schema.graphqls (for example createCourse(input:{title,clientMutationId})). clientMutationId is correlation only. Course lookup returns null with NOT_FOUND for inaccessible data; non-null child failures propagate according to GraphQL semantics. myEnrollments uses enrollment enrolledAt DESC,id DESC and the same tenant/filter-bound cursor strategy. For lessons and enrollmentCount, use explicit GraphQL typeName="Course" when a Java DTO is named CourseView. DataLoader caches last only for the request.

## RLS lab

Migrations run as a separate owner. Use a runtime role with NOBYPASSRLS; ensure policies are effective for that role and fail closed without tenant context. BEGIN; SELECT set_config('app.tenant_id', :verifiedTenant, true); perform queries; COMMIT. Parameterize the tenant value. A one-connection pool alternating tenant A/B catches leaked session state. Request-scoped loaders and Redis keys must carry tenant identity independently of RLS.
