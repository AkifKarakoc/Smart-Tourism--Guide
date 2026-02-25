package com.tourguide.place.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceResponse {
    private UUID id;
    private String name;
    private String nameTr;
    private String nameEn;
    private String category;
    private Double latitude;
    private Double longitude;
    private String address;
    private String photoUrl;
    private Double avgRating;
    private Integer reviewCount;
    private Double distance;
    private Boolean isFavorited;
}
