package com.tourguide.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "pilot-zone")
public class PilotZoneConfig {

    private boolean enabled;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    private double centerLatitude;
    private double centerLongitude;

    public boolean isWithinPilotZone(double latitude, double longitude) {
        if (!enabled) {
            return true;
        }
        return latitude >= minLatitude && latitude <= maxLatitude
                && longitude >= minLongitude && longitude <= maxLongitude;
    }
}
