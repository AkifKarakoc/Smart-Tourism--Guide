package com.tourguide.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserQuestRepository extends JpaRepository<UserQuest, UUID> {

    Optional<UserQuest> findByUserIdAndQuestId(UUID userId, UUID questId);

    boolean existsByUserIdAndQuestId(UUID userId, UUID questId);
}
