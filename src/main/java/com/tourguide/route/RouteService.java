package com.tourguide.route;

import com.tourguide.common.exception.ResourceNotFoundException;
import com.tourguide.route.dto.RouteDetailResponse;
import com.tourguide.route.dto.RouteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService implements IRouteService {

    private final RouteRepository routeRepository;
    private final RoutePlaceRepository routePlaceRepository;

    @Transactional(readOnly = true)
    public List<RouteResponse> findAll(Double latitude, Double longitude) {
        List<Route> routes;
        if (latitude != null && longitude != null) {
            routes = routeRepository.findNearby(latitude, longitude);
        } else {
            routes = routeRepository.findByIsActiveTrue();
        }

        return routes.stream()
                .map(route -> RouteResponse.builder()
                .id(route.getId())
                .name(route.getName())
                .description(route.getDescription())
                .centerLatitude(route.getCenterLatitude())
                .centerLongitude(route.getCenterLongitude())
                .radiusMeters(route.getRadiusMeters())
                .estimatedMinutes(route.getEstimatedMinutes())
                .expReward(route.getExpReward())
                .thumbnailUrl(route.getThumbnailUrl())
                .totalStops(route.getRoutePlaces().size())
                .build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RouteDetailResponse findById(UUID routeId) {
        Route route = routeRepository.findByIdAndIsActiveTrue(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", routeId));

        List<RouteDetailResponse.RoutePlaceResponse> places = routePlaceRepository
                .findByRouteIdOrderByStopOrder(routeId).stream()
                .map(rp -> RouteDetailResponse.RoutePlaceResponse.builder()
                .id(rp.getId())
                .placeId(rp.getPlaceId())
                .stopOrder(rp.getStopOrder())
                .estimatedMinutes(rp.getEstimatedMinutes())
                .notes(rp.getNotes())
                .build())
                .collect(Collectors.toList());

        return RouteDetailResponse.builder()
                .id(route.getId())
                .name(route.getName())
                .description(route.getDescription())
                .centerLatitude(route.getCenterLatitude())
                .centerLongitude(route.getCenterLongitude())
                .radiusMeters(route.getRadiusMeters())
                .estimatedMinutes(route.getEstimatedMinutes())
                .expReward(route.getExpReward())
                .thumbnailUrl(route.getThumbnailUrl())
                .places(places)
                .build();
    }

    @Override
    @Transactional
    public Route createRoute(Route route, List<RoutePlace> places) {
        Route saved = routeRepository.save(route);
        if (places != null) {
            for (RoutePlace rp : places) {
                rp.setRoute(saved);
                routePlaceRepository.save(rp);
            }
        }
        return saved;
    }

    @Override
    @Transactional
    public void softDeleteRoute(UUID routeId) {
        Route route = routeRepository.findByIdAndIsActiveTrue(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", routeId));
        route.setIsActive(false);
        routeRepository.save(route);
    }
}
