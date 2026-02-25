package com.tourguide.quest.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StartQuestResponse {
    private UUID userQuestId;
    private UUID questId;
    private String status;
    private LocalDateTime startedAt;
}
