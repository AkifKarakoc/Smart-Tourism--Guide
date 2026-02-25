package com.tourguide.admin.moderator;

import com.tourguide.quest.IQuestService;
import com.tourguide.quest.QuestVerification;
import com.tourguide.quest.VerificationStatus;
import com.tourguide.review.IReviewService;
import com.tourguide.review.ReviewStatus;
import com.tourguide.review.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModeratorService {

    private final IReviewService reviewService;
    private final IQuestService questService;

    public List<ReviewResponse> getPendingReviews() {
        return reviewService.getPendingReviews();
    }

    @Transactional
    public ReviewResponse moderateReview(UUID reviewId, ReviewStatus status, String moderatorNote) {
        return reviewService.moderateReview(reviewId, status, moderatorNote);
    }

    public List<QuestVerification> getPendingVerifications() {
        return questService.getPendingVerifications();
    }

    @Transactional
    public QuestVerification moderateVerification(UUID verificationId, VerificationStatus status,
            String moderatorNote, Integer expEarned) {
        return questService.moderateVerification(verificationId, status, moderatorNote, expEarned);
    }
}
