package com.tourguide.route;

import com.tourguide.route.dto.RouteDetailResponse;
import com.tourguide.route.dto.RouteResponse;

import java.util.List;
import java.util.UUID;

public interface IRouteService {

    List<RouteResponse> findAll(Double latitude, Double longitude);

    RouteDetailResponse findById(UUID routeId);

    Route createRoute(Route route, List<RoutePlace> places);

    void softDeleteRoute(UUID routeId);
}
