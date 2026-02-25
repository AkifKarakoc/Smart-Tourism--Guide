package com.tourguide.notification.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationPageResponse {
    private List<NotificationResponse> notifications;
    private Long unreadCount;
    private Integer totalPages;
    private Long totalElements;
}
