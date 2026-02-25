package com.tourguide.quest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyStepResponse {
    private UUID verificationId;
    private String status;
    private Double confidenceScore;
    private Integer expEarned;
    private Boolean questCompleted;
}
