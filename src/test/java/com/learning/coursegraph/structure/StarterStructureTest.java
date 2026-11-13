package com.learning.coursegraph.structure;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** A packaging check only; does not grade business behavior. */
@Tag("structure")
class StarterStructureTest {
    @Test void applicationAndPortArePresent() throws Exception {
        assertTrue(Class.forName("com.learning.coursegraph.repository.CourseGraphRepository").isInterface());
        assertTrue(Class.forName("com.learning.coursegraph.CourseGraphApplication").isAnnotationPresent(
            org.springframework.boot.autoconfigure.SpringBootApplication.class));
    }
    @Test void clockBeanUsesUtc() {
        assertEquals(java.time.ZoneOffset.UTC, new com.learning.coursegraph.config.TimeConfig().clock().getZone());
    }
}
