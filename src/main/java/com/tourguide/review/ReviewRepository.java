package com.tourguide.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

    List<Review> findByPlaceIdAndStatusAndIsActiveTrue(UUID placeId, ReviewStatus status);

    List<Review> findByStatusAndIsActiveTrue(ReviewStatus status);

    boolean existsByUserIdAndPlaceId(UUID userId, UUID placeId);
}
