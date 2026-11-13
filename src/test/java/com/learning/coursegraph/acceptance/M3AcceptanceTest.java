package com.learning.coursegraph.acceptance;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** Required test exercises. Read docs/ACCEPTANCE_TESTS.md for setup and expected results. */
@Tag("M3")
class M3AcceptanceTest {
    /** BR-301: Insert a newer course between page 1 and page 2; previously seen courses are not duplicated. Changed filter/tenant cursor → BAD_USER_INPUT. */
    @Test void br301_acceptance() {
        fail("TODO: M3 BR-301 replace this with a behavior test; do not disable or delete it");
    }
    /** BR-302: The same operation for 1 vs 20 courses does not grow query count linearly; concurrent tenant requests do not share cache entries. */
    @Test void br302_acceptance() {
        fail("TODO: M3 BR-302 replace this with a behavior test; do not disable or delete it");
    }
}
