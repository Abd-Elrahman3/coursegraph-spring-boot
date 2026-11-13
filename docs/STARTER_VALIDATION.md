# Starter Validation

The initial package is intentionally incomplete. Validation distinguishes infrastructure from solved behavior.

| Check | Expected initial result |
| --- | --- |
| Java 21 Maven clean verify | Pass; compile production/test code and run two structure tests |
| Maven learning profile through M1 | Fail in domain TODOs; no skipped tests |
| Python cumulative gate through M1 | Reject incomplete evidence and implementation |
| OpenAPI 3.1 document validation | Pass |
| JSON request example parsing | Pass |
| Compose configuration validation | Pass |
| Full application/business API integration | Not yet implemented; learner milestones |

GraphQL schema and example operations are validated for CourseGraph. Markdown local links are checked. The published starter build does not launch databases/brokers or prove business rules. Integration, security, concurrency, load and recovery tests are mandatory learner work. No live provider calls were made.
