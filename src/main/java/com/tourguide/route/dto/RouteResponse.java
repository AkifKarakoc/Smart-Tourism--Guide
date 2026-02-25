package com.tourguide.route.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteResponse {
    private UUID id;
    private String name;
    private String description;
    private Double centerLatitude;
    private Double centerLongitude;
    private Integer radiusMeters;
    private Integer estimatedMinutes;
    private Integer expReward;
    private String thumbnailUrl;
    private Integer totalStops;
}
