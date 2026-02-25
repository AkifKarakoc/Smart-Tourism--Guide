package com.tourguide.image.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageAnalysisResponse {
    private UUID placeId;
    private String placeName;
    private Double confidence;
    private String description;
    private String imageUrl;
}
