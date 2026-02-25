package com.tourguide.place;

import com.tourguide.place.dto.PlaceDetailResponse;
import com.tourguide.place.dto.PlaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    @Mapping(target = "distance", ignore = true)
    @Mapping(target = "isFavorited", ignore = true)
    PlaceResponse toResponse(Place place);

    @Mapping(target = "isFavorited", ignore = true)
    PlaceDetailResponse toDetailResponse(Place place);
}
