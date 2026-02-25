package com.tourguide.route.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteDetailResponse {
    private UUID id;
    private String name;
    private String description;
    private Double centerLatitude;
    private Double centerLongitude;
    private Integer radiusMeters;
    private Integer estimatedMinutes;
    private Integer expReward;
    private String thumbnailUrl;
    private List<RoutePlaceResponse> places;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RoutePlaceResponse {
        private UUID id;
        private UUID placeId;
        private Integer stopOrder;
        private Integer estimatedMinutes;
        private String notes;
    }
}
