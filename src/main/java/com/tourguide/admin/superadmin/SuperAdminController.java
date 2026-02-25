package com.tourguide.admin.superadmin;

import com.tourguide.admin.superadmin.dto.AssignRoleRequest;
import com.tourguide.admin.superadmin.dto.UpdateStatusRequest;
import com.tourguide.admin.superadmin.dto.UserManagementResponse;
import com.tourguide.common.enums.Role;
import com.tourguide.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @GetMapping("/users")
    public ResponseEntity<List<UserManagementResponse>> getAllUsers() {
        List<UserManagementResponse> users = superAdminService.getAllUsers().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/users/{id}/role")
    public ResponseEntity<UserManagementResponse> assignRole(
            @PathVariable UUID id,
            @Valid @RequestBody AssignRoleRequest request) {
        User user = superAdminService.assignRole(id, Role.valueOf(request.getRole()));
        return ResponseEntity.ok(toResponse(user));
    }

    @PatchMapping("/users/{id}/status")
    public ResponseEntity<UserManagementResponse> updateStatus(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateStatusRequest request) {
        User user = superAdminService.updateStatus(id, request.getIsActive());
        return ResponseEntity.ok(toResponse(user));
    }

    private UserManagementResponse toResponse(User user) {
        return UserManagementResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole().name())
                .isActive(user.getIsActive())
                .expPoints(user.getExpPoints())
                .level(user.getLevel())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
