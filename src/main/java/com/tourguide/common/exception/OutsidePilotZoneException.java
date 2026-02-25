package com.tourguide.common.exception;

public class OutsidePilotZoneException extends RuntimeException {
    public OutsidePilotZoneException(String message) {
        super(message);
    }

    public OutsidePilotZoneException(double latitude, double longitude) {
        super(String.format("Location (%.6f, %.6f) is outside the pilot zone", latitude, longitude));
    }
}
