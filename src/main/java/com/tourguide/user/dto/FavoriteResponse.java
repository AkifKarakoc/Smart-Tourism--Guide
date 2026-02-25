package com.tourguide.user.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteResponse {
    private UUID id;
    private UUID placeId;
    private LocalDateTime savedAt;
}
