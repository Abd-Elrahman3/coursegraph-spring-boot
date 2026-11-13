package com.learning.coursegraph.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


/** M1 domain skeleton. DRAFT → PUBLISHED → ARCHIVED. Publishing requires at least one lesson. See README sections 4–5. */
public class Course {
    private UUID id;
    private UUID tenantId;
    private String title;
    private CourseStatus status;
    private long version;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public Course(UUID id, UUID tenantId, String title, CourseStatus status, long version) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public UUID getTenantId() { return tenantId; }
    public String getTitle() { return title; }
    public CourseStatus getStatus() { return status; }
    public long getVersion() { return version; }

    /** M1 BR-101. At least one lesson required; only DRAFT can publish. */
    public void publish(int lessonCount) {
        throw new UnsupportedOperationException("TODO: M1 BR-101");
    }

    /** M1 BR-101. Only PUBLISHED may archive. */
    public void archive() {
        throw new UnsupportedOperationException("TODO: M1 BR-101");
    }
}
