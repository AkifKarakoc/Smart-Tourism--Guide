package com.tourguide.image;

import com.tourguide.image.dto.ImageAnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/identify", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageAnalysisResponse> identifyImage(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @AuthenticationPrincipal UUID userId) {
        return ResponseEntity.ok(imageService.identifyImage(photo, latitude, longitude, userId));
    }
}
