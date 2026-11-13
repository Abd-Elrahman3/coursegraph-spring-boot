package com.learning.coursegraph.api;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import static com.learning.coursegraph.api.Responses.*;
import com.learning.coursegraph.service.CourseGraphService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

/** D4 transport skeleton. Implement validation, authorization and DTO/service mapping.
 * Throwing TODOs is deliberate: no endpoint claims business success yet.
 */
@RestController
public class BusinessApiController {
    private final CourseGraphService service;
    public BusinessApiController(CourseGraphService service) { this.service = service; }
    @PostMapping("/api/v1/imports")
    public ResponseEntity<ImportReceipt> importLessons(@RequestPart("file") org.springframework.web.multipart.MultipartFile file, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 importLessons");
    }
    @GetMapping("/api/v1/imports/{jobId}")
    public ResponseEntity<ImportStatus> importStatus(@PathVariable UUID jobId, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 importStatus");
    }
}
