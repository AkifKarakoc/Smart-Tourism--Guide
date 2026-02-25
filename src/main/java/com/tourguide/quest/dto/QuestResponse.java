package com.tourguide.quest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestResponse {
    private UUID id;
    private String title;
    private String description;
    private Integer expReward;
    private String region;
    private String thumbnailUrl;
    private Integer totalSteps;
    private String userStatus;
}
