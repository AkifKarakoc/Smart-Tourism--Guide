package com.tourguide.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestStepRepository extends JpaRepository<QuestStep, UUID> {

    List<QuestStep> findByQuestIdOrderByStepOrder(UUID questId);
}
