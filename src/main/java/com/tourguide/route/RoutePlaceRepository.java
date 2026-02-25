package com.tourguide.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoutePlaceRepository extends JpaRepository<RoutePlace, UUID> {

    List<RoutePlace> findByRouteIdOrderByStopOrder(UUID routeId);
}
