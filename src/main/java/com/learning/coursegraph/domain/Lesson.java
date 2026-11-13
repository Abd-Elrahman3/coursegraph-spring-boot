package com.learning.coursegraph.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


/** M1 domain skeleton. Position >=1 and unique per tenant/course. See README sections 4–5. */
public class Lesson {
    private UUID id;
    private UUID tenantId;
    private UUID courseId;
    private String title;
    private int position;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public Lesson(UUID id, UUID tenantId, UUID courseId, String title, int position) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public UUID getTenantId() { return tenantId; }
    public UUID getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public int getPosition() { return position; }
}
