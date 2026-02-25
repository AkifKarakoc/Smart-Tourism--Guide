package com.tourguide.chat.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatResponse {
    private UUID sessionId;
    private String role;
    private String content;
    private LocalDateTime sentAt;
}
