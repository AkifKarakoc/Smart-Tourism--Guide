package com.tourguide.admin.superadmin;

import com.tourguide.common.enums.Role;
import com.tourguide.user.IUserService;
import com.tourguide.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SuperAdminService {

    private final IUserService userService;

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Transactional
    public User assignRole(UUID userId, Role role) {
        return userService.assignRole(userId, role);
    }

    @Transactional
    public User updateStatus(UUID userId, boolean isActive) {
        return userService.updateStatus(userId, isActive);
    }
}
