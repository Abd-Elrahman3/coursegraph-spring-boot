package com.learning.coursegraph.repository;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;
import com.learning.coursegraph.domain.*;

/** M2 BR-201/BR-202. Implement using real PostgreSQL; do not substitute an in-memory map. */
@org.springframework.stereotype.Repository
public class PostgresCourseGraphRepository implements CourseGraphRepository {
    @Override public Optional<Course> findCourse(UUID tenantId, UUID id) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 findCourse");
    }
    @Override public List<Course> findCoursePage(UUID tenantId, Instant beforeTime, UUID beforeId, int limit) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 findCoursePage");
    }
    @Override public List<Lesson> findLessons(UUID tenantId, List<UUID> courseIds) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 findLessons");
    }
    @Override public Enrollment saveEnrollment(Enrollment enrollment) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 saveEnrollment");
    }
}
