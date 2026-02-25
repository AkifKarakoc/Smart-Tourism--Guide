package com.tourguide.user;

import com.tourguide.common.entity.BaseEntity;
import com.tourguide.common.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "profile_photo_url", length = 500)
    private String profilePhotoUrl;

    @Column(name = "preferred_language", length = 5)
    @Builder.Default
    private String preferredLanguage = "tr";

    @Column(name = "age_group", length = 20)
    private String ageGroup;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Role role = Role.TOURIST;

    @Column(name = "exp_points", nullable = false)
    @Builder.Default
    private Integer expPoints = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer level = 1;
}
