package com.learning.coursegraph.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


/** M1 domain skeleton. Unique(tenantId,courseId,learnerSubject); only published courses enroll. See README sections 4–5. */
public class Enrollment {
    private UUID id;
    private UUID tenantId;
    private UUID courseId;
    private String learnerSubject;
    private Instant enrolledAt;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public Enrollment(UUID id, UUID tenantId, UUID courseId, String learnerSubject, Instant enrolledAt) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public UUID getTenantId() { return tenantId; }
    public UUID getCourseId() { return courseId; }
    public String getLearnerSubject() { return learnerSubject; }
    public Instant getEnrolledAt() { return enrolledAt; }
}
