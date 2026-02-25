package com.tourguide.badge;

import com.tourguide.badge.dto.BadgeResponse;
import com.tourguide.badge.dto.UserBadgeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping("/badges")
    public ResponseEntity<List<BadgeResponse>> getAllBadges(@AuthenticationPrincipal UUID userId) {
        return ResponseEntity.ok(badgeService.getAllBadges(userId));
    }

    @GetMapping("/users/me/badges")
    public ResponseEntity<List<UserBadgeResponse>> getMyBadges(@AuthenticationPrincipal UUID userId) {
        return ResponseEntity.ok(badgeService.getUserBadges(userId));
    }
}
