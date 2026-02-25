package com.tourguide.admin.contenteditor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlaceRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String nameTr;
    private String nameEn;
    private String category;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;

    private String description;
    private String address;
    private String phone;
    private String website;
    private String openingHours;
    private String photoUrl;
}
