package com.tourguide.common.exception;

public class GpsCheckFailedException extends RuntimeException {
    public GpsCheckFailedException(String message) {
        super(message);
    }

    public GpsCheckFailedException(double distance, double maxDistance) {
        super(String.format("GPS check failed: distance %.1fm exceeds maximum %.1fm", distance, maxDistance));
    }
}
