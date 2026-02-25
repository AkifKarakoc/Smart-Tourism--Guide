package com.tourguide.admin.superadmin.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserManagementResponse {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private Boolean isActive;
    private Integer expPoints;
    private Integer level;
    private LocalDateTime createdAt;
}
