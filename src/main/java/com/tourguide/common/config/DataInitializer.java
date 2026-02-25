package com.tourguide.common.config;

import com.tourguide.common.enums.Role;
import com.tourguide.user.IUserService;
import com.tourguide.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;

    private static final String SUPERADMIN_EMAIL = "superadmin@tourguide.com";
    private static final String SUPERADMIN_PASSWORD = "Admin@1234";

    @Override
    public void run(ApplicationArguments args) {
        if (!userService.existsByEmail(SUPERADMIN_EMAIL)) {
            User admin = User.builder()
                    .email(SUPERADMIN_EMAIL)
                    .passwordHash(passwordEncoder.encode(SUPERADMIN_PASSWORD))
                    .firstName("Super")
                    .lastName("Admin")
                    .role(Role.SUPERADMIN)
                    .preferredLanguage("tr")
                    .build();

            userService.createUser(admin);
            log.info("SuperAdmin user created: {}", SUPERADMIN_EMAIL);
        } else {
            log.debug("SuperAdmin user already exists, skipping seed.");
        }
    }
}
