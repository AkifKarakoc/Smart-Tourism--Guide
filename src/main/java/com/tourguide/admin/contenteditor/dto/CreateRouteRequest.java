package com.tourguide.admin.contenteditor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Center latitude is required")
    private Double centerLatitude;

    @NotNull(message = "Center longitude is required")
    private Double centerLongitude;

    private Integer radiusMeters;
    private Integer estimatedMinutes;
    private Integer expReward;
    private String thumbnailUrl;
    private List<RoutePlaceRequest> places;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutePlaceRequest {
        private UUID placeId;
        private Integer stopOrder;
        private Integer estimatedMinutes;
        private String notes;
    }
}
