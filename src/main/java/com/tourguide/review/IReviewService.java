package com.tourguide.review;

import com.tourguide.review.dto.ReviewRequest;
import com.tourguide.review.dto.ReviewResponse;

import java.util.List;
import java.util.UUID;

public interface IReviewService {

    List<ReviewResponse> getReviewsForPlace(UUID placeId);

    ReviewResponse createReview(UUID userId, UUID placeId, ReviewRequest request);

    void deleteReview(UUID userId, UUID placeId, UUID reviewId);

    ReviewResponse moderateReview(UUID reviewId, ReviewStatus status, String moderatorNote);

    List<ReviewResponse> getPendingReviews();
}
