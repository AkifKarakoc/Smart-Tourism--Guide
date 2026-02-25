package com.tourguide.quest;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "quest_steps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestStep {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    private Quest quest;

    @Column(name = "place_id", nullable = false)
    private UUID placeId;

    @Column(name = "step_order", nullable = false)
    private Integer stepOrder;

    @Column(columnDefinition = "text")
    private String hint;

    @Column(name = "requires_photo", nullable = false)
    @Builder.Default
    private Boolean requiresPhoto = true;

    @Column(name = "confidence_threshold", nullable = false)
    @Builder.Default
    private Double confidenceThreshold = 0.80;
}
