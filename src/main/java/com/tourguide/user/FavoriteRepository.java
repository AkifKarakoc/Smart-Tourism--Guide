package com.tourguide.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {

    List<Favorite> findByUserId(UUID userId);

    boolean existsByUserIdAndPlaceId(UUID userId, UUID placeId);

    void deleteByUserIdAndPlaceId(UUID userId, UUID placeId);
}
