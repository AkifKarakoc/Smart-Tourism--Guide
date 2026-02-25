package com.tourguide.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestVerificationRepository extends JpaRepository<QuestVerification, UUID> {

    List<QuestVerification> findByUserQuestId(UUID userQuestId);

    boolean existsByUserQuestIdAndStepId(UUID userQuestId, UUID stepId);

    List<QuestVerification> findByStatus(VerificationStatus status);
}
