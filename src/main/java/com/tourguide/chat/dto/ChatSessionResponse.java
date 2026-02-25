package com.tourguide.chat.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatSessionResponse {
    private UUID sessionId;
    private String language;
    private LocalDateTime startedAt;
}
