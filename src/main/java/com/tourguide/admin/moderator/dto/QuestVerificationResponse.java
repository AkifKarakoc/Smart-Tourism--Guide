package com.tourguide.admin.moderator.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestVerificationResponse {
    private UUID id;
    private UUID userQuestId;
    private UUID stepId;
    private UUID userId;
    private String photoUrl;
    private Double latitude;
    private Double longitude;
    private String status;
    private Double confidenceScore;
    private String moderatorNote;
    private Integer expEarned;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
