package com.tourguide.image;

import com.tourguide.common.config.PilotZoneConfig;
import com.tourguide.common.exception.OutsidePilotZoneException;
import com.tourguide.common.util.MinioUtil;
import com.tourguide.image.dto.ImageAnalysisResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final PilotZoneConfig pilotZoneConfig;
    private final MinioUtil minioUtil;
    private final ImageRepository imageRepository;

    private static final String PLACE_IMAGES_BUCKET = "place-images";

    public ImageAnalysisResponse identifyImage(MultipartFile photo, Double latitude, Double longitude, UUID userId) {
        if (!pilotZoneConfig.isWithinPilotZone(latitude, longitude)) {
            throw new OutsidePilotZoneException(latitude, longitude);
        }

        String fileName = minioUtil.upload(PLACE_IMAGES_BUCKET, photo);

        log.info("Image identification requested at ({}, {}), stub response returned", latitude, longitude);

        return ImageAnalysisResponse.builder()
                .placeId(null)
                .placeName("Stub - AI service not connected")
                .confidence(0.0)
                .description("This is a stub response. Connect the Python AI microservice for real image recognition.")
                .imageUrl(fileName)
                .build();
    }
}
