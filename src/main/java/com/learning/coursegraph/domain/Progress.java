package com.learning.coursegraph.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


/** M1 domain skeleton. Unique(tenantId,enrollmentId,lessonId); completion is idempotent. See README sections 4–5. */
public class Progress {
    private UUID tenantId;
    private UUID enrollmentId;
    private UUID lessonId;
    private Instant completedAt;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public Progress(UUID tenantId, UUID enrollmentId, UUID lessonId, Instant completedAt) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getTenantId() { return tenantId; }
    public UUID getEnrollmentId() { return enrollmentId; }
    public UUID getLessonId() { return lessonId; }
    public Instant getCompletedAt() { return completedAt; }
}
