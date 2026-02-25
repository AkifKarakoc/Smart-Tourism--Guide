package com.tourguide.common.util;

import ch.hsr.geohash.GeoHash;

public final class GeohashUtil {

    private static final int PRECISION = 6;

    private GeohashUtil() {
    }

    public static String encode(double latitude, double longitude) {
        return GeoHash.withCharacterPrecision(latitude, longitude, PRECISION).toBase32();
    }

    public static String encode(double latitude, double longitude, int precision) {
        return GeoHash.withCharacterPrecision(latitude, longitude, precision).toBase32();
    }
}
