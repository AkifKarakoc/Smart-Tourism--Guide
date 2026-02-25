package com.tourguide.admin.superadmin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignRoleRequest {

    @NotNull(message = "Role is required")
    @Pattern(
            regexp = "TOURIST|CONTENT_EDITOR|MODERATOR|SUPERADMIN",
            message = "Role must be one of: TOURIST, CONTENT_EDITOR, MODERATOR, SUPERADMIN"
    )
    private String role;
}
