package com.tourguide.todo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoResponse {
    private UUID id;
    private UUID placeId;
    private String note;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
}
