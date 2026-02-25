package com.tourguide.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, UUID> {

    List<TodoItem> findByUserIdAndIsActiveTrue(UUID userId);

    Optional<TodoItem> findByIdAndUserIdAndIsActiveTrue(UUID id, UUID userId);
}
