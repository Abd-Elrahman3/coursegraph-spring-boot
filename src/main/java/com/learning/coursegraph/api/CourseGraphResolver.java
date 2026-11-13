package com.learning.coursegraph.api;
import java.util.*;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import static com.learning.coursegraph.api.Responses.*;

/** Tenant identity comes from verified request security context, never from a GraphQL argument. */
@Controller
public class CourseGraphResolver {
    @QueryMapping
    public CourseConnection courses(@Argument int first, @Argument String after) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 courses");
    }
    @QueryMapping
    public CourseView course(@Argument UUID id) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 course");
    }
    @QueryMapping
    public EnrollmentConnection myEnrollments(@Argument int first, @Argument String after) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 myEnrollments");
    }
    @MutationMapping
    public CoursePayload createCourse(@Argument Requests.CreateCourseInput input) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 createCourse");
    }
    @MutationMapping
    public CoursePayload publishCourse(@Argument Requests.PublishCourseInput input) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 publishCourse");
    }
    @MutationMapping
    public EnrollmentPayload enroll(@Argument Requests.EnrollInput input) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 enroll");
    }
    @MutationMapping
    public EnrollmentPayload completeLesson(@Argument Requests.CompleteLessonInput input) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 completeLesson");
    }
    @BatchMapping(typeName="Course", field="lessons")
    public Map<CourseView,List<LessonView>> lessons(List<CourseView> courses) {
        throw new UnsupportedOperationException("TODO: M3 BR-302 D4 BR-401 tenant-scoped batching");
    }
    @BatchMapping(typeName="Course", field="enrollmentCount")
    public Map<CourseView,Integer> enrollmentCount(List<CourseView> courses) {
        throw new UnsupportedOperationException("TODO: M3 BR-302 D4 BR-401 bounded query count");
    }
}
