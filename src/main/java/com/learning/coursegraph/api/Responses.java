package com.learning.coursegraph.api;
import java.util.*;
import java.time.*;
import java.math.BigDecimal;
/** Transport shapes. TODO: D4 BR-401 add field validation, defensive copies and mapping tests.
 * Treat secrets and internal persistence fields as excluded unless explicitly part of the contract.
 */
public final class Responses {
    private Responses() {}
    public record CourseView(UUID id, String title, String status) {}
    public record LessonView(UUID id, String title, int position) {}
    public record EnrollmentView(UUID id, CourseView course, List<LessonView> completedLessons, String progressPercent) {}
    public record PageInfo(String endCursor, boolean hasNextPage) {}
    public record CourseEdge(String cursor, CourseView node) {}
    public record CourseConnection(List<CourseEdge> edges, PageInfo pageInfo) {}
    public record EnrollmentEdge(String cursor, EnrollmentView node) {}
    public record EnrollmentConnection(List<EnrollmentEdge> edges, PageInfo pageInfo) {}
    public record CoursePayload(CourseView course, String clientMutationId) {}
    public record EnrollmentPayload(EnrollmentView enrollment, String clientMutationId) {}
    public record ImportReceipt(UUID jobId, String status) {}
    public record ImportStatus(UUID jobId, String status, long read, long written, long rejected, String errorReportUrl) {}
}
