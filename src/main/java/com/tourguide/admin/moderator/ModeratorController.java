package com.tourguide.admin.moderator;

import com.tourguide.admin.moderator.dto.QuestVerificationRequest;
import com.tourguide.admin.moderator.dto.QuestVerificationResponse;
import com.tourguide.admin.moderator.dto.ReviewModerationRequest;
import com.tourguide.quest.QuestVerification;
import com.tourguide.quest.VerificationStatus;
import com.tourguide.review.ReviewStatus;
import com.tourguide.review.dto.ReviewResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/moderator")
@RequiredArgsConstructor
public class ModeratorController {

    private final ModeratorService moderatorService;

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResponse>> getPendingReviews() {
        return ResponseEntity.ok(moderatorService.getPendingReviews());
    }

    @PatchMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> moderateReview(
            @PathVariable UUID id,
            @Valid @RequestBody ReviewModerationRequest request) {
        ReviewStatus status = ReviewStatus.valueOf(request.getStatus());
        return ResponseEntity.ok(moderatorService.moderateReview(id, status, request.getModeratorNote()));
    }

    @GetMapping("/verifications")
    public ResponseEntity<List<QuestVerificationResponse>> getPendingVerifications() {
        List<QuestVerificationResponse> verifications = moderatorService.getPendingVerifications()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(verifications);
    }

    @PatchMapping("/verifications/{id}")
    public ResponseEntity<QuestVerificationResponse> moderateVerification(
            @PathVariable UUID id,
            @Valid @RequestBody QuestVerificationRequest request) {
        VerificationStatus status = VerificationStatus.valueOf(request.getStatus());
        QuestVerification verification = moderatorService.moderateVerification(
                id, status, request.getModeratorNote(), request.getExpEarned());
        return ResponseEntity.ok(toResponse(verification));
    }

    private QuestVerificationResponse toResponse(QuestVerification v) {
        return QuestVerificationResponse.builder()
                .id(v.getId())
                .userQuestId(v.getUserQuestId())
                .stepId(v.getStepId())
                .userId(v.getUserId())
                .photoUrl(v.getPhotoUrl())
                .latitude(v.getLatitude())
                .longitude(v.getLongitude())
                .status(v.getStatus().name())
                .confidenceScore(v.getConfidenceScore())
                .moderatorNote(v.getModeratorNote())
                .expEarned(v.getExpEarned())
                .createdAt(v.getCreatedAt())
                .updatedAt(v.getUpdatedAt())
                .build();
    }
}
