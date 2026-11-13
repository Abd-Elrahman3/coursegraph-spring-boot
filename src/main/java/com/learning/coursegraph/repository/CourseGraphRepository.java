package com.learning.coursegraph.repository;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;
import com.learning.coursegraph.domain.*;

public interface CourseGraphRepository {
    Optional<Course> findCourse(UUID tenantId, UUID id);
    List<Course> findCoursePage(UUID tenantId, Instant beforeTime, UUID beforeId, int limit);
    List<Lesson> findLessons(UUID tenantId, List<UUID> courseIds);
    Enrollment saveEnrollment(Enrollment enrollment);
}
