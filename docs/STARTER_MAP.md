# Starter File Map

These are intentionally unfinished building blocks, not a complete solution. Add missing DTOs, entity mappings, repository queries, configuration and tests as specified. No business endpoint is provided complete.

| File | Purpose |
| --- | --- |
| src/main/java/com/learning/coursegraph/CourseGraphApplication.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/coursegraph/advanced/CursorCodec.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/advanced/LessonImportJob.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/advanced/ProgressCalculator.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/advanced/QueryBudget.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/advanced/TenantContext.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/api/ApiExceptionHandler.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/api/CourseGraphController.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/api/CourseGraphResolver.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/config/SecurityConfig.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/coursegraph/config/TimeConfig.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/coursegraph/domain/Course.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/domain/CourseStatus.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/domain/Enrollment.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/domain/Lesson.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/domain/Progress.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/exception/ConflictException.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/coursegraph/exception/NotFoundException.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/coursegraph/persistence/CourseEntity.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/repository/CourseGraphRepository.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/repository/PostgresCourseGraphRepository.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/coursegraph/service/CourseGraphService.java | Unfinished learner code; see rule IDs in Javadoc |
| src/test/java/com/learning/coursegraph/acceptance/D4AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/D5AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/D6AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/D7AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/M1DomainTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/M2AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/acceptance/M3AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/coursegraph/structure/StarterStructureTest.java | Behavioral examples / test exercise |

Constructors use declared fields in README order. Implement validation and assignment before services. Repository ports describe the first core use cases; extend them as necessary. Advanced component methods are starting boundaries, not prescribed complete architecture. Keep provided behavioral constructor/method signatures while adding overloads or collaborators.

## Typed transport exercises

- `src/main/java/com/learning/coursegraph/api/BusinessApiController.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
- `src/main/java/com/learning/coursegraph/api/Requests.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
- `src/main/java/com/learning/coursegraph/api/Responses.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
