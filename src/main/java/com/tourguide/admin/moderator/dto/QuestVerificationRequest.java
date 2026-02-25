package com.tourguide.admin.moderator.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestVerificationRequest {

    @NotNull(message = "Status is required")
    @Pattern(
            regexp = "APPROVED|REJECTED",
            message = "Status must be either APPROVED or REJECTED"
    )
    private String status;

    @Size(max = 500, message = "Moderator note must not exceed 500 characters")
    private String moderatorNote;

    private Integer expEarned;
}
