package com.tourguide.quest;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "quest_verifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_quest_id", nullable = false)
    private UUID userQuestId;

    @Column(name = "step_id", nullable = false)
    private UUID stepId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "photo_url", length = 500)
    private String photoUrl;

    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private VerificationStatus status = VerificationStatus.PENDING;

    @Column(name = "confidence_score")
    private Double confidenceScore;

    @Column(name = "moderator_note", columnDefinition = "text")
    private String moderatorNote;

    @Column(name = "exp_earned")
    @Builder.Default
    private Integer expEarned = 0;

    @Column(name = "created_at", nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
