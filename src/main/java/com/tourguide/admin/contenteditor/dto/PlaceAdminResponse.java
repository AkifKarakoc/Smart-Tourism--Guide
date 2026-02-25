package com.tourguide.admin.contenteditor.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceAdminResponse {
    private UUID id;
    private String name;
    private String nameTr;
    private String nameEn;
    private String category;
    private Double latitude;
    private Double longitude;
    private String description;
    private String address;
    private String phone;
    private String website;
    private String openingHours;
    private String photoUrl;
}
