package com.tourguide.route;

import com.tourguide.route.dto.RouteDetailResponse;
import com.tourguide.route.dto.RouteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteResponse>> getAllRoutes(
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double longitude) {
        return ResponseEntity.ok(routeService.findAll(latitude, longitude));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDetailResponse> getRouteDetail(@PathVariable UUID id) {
        return ResponseEntity.ok(routeService.findById(id));
    }
}
