package com.learning.coursegraph.acceptance;
import com.learning.coursegraph.domain.*;
import com.learning.coursegraph.exception.*;
import java.util.*;
import java.time.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** Provided behavioral examples. These fail until M1 is implemented. Add boundary cases. */
@Tag("M1")
class M1DomainTest {
    @Test void emptyCourseCannotPublish() {
        var course = new Course(UUID.randomUUID(), UUID.randomUUID(), "Spring", CourseStatus.DRAFT, 0);
        assertThrows(ConflictException.class, () -> course.publish(0));
        assertEquals(CourseStatus.DRAFT, course.getStatus());
    }
    @Test void percentageUsesHalfUp() {
        var calculator = new com.learning.coursegraph.advanced.ProgressCalculator();
        assertEquals(new java.math.BigDecimal("33.33"), calculator.percentage(1,3));
        assertEquals(new java.math.BigDecimal("0.00"), calculator.percentage(0,0));
    }
}
