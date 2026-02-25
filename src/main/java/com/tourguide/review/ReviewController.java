package com.tourguide.review;

import com.tourguide.review.dto.ReviewRequest;
import com.tourguide.review.dto.ReviewResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/places/{placeId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable UUID placeId) {
        return ResponseEntity.ok(reviewService.getReviewsForPlace(placeId));
    }

    @PostMapping("/places/{placeId}/reviews")
    public ResponseEntity<ReviewResponse> createReview(
            @AuthenticationPrincipal UUID userId,
            @PathVariable UUID placeId,
            @Valid @RequestBody ReviewRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(userId, placeId, request));
    }

    @DeleteMapping("/places/{placeId}/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(
            @AuthenticationPrincipal UUID userId,
            @PathVariable UUID placeId,
            @PathVariable UUID reviewId) {
        reviewService.deleteReview(userId, placeId, reviewId);
        return ResponseEntity.noContent().build();
    }
}
