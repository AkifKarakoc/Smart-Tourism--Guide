package com.tourguide.todo;

import com.tourguide.common.exception.ResourceNotFoundException;
import com.tourguide.todo.dto.TodoRequest;
import com.tourguide.todo.dto.TodoResponse;
import com.tourguide.todo.dto.UpdateTodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<TodoResponse> getTodos(UUID userId) {
        return todoRepository.findByUserIdAndIsActiveTrue(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoResponse createTodo(UUID userId, TodoRequest request) {
        TodoItem item = TodoItem.builder()
                .userId(userId)
                .placeId(request.getPlaceId())
                .note(request.getNote())
                .build();
        item = todoRepository.save(item);
        return toResponse(item);
    }

    @Transactional
    public TodoResponse updateTodo(UUID userId, UUID todoId, UpdateTodoRequest request) {
        TodoItem item = todoRepository.findByIdAndUserIdAndIsActiveTrue(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));

        if (request.getNote() != null) item.setNote(request.getNote());
        if (request.getIsCompleted() != null) item.setIsCompleted(request.getIsCompleted());

        item = todoRepository.save(item);
        return toResponse(item);
    }

    @Transactional
    public void deleteTodo(UUID userId, UUID todoId) {
        TodoItem item = todoRepository.findByIdAndUserIdAndIsActiveTrue(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoId));
        item.setIsActive(false);
        todoRepository.save(item);
    }

    private TodoResponse toResponse(TodoItem item) {
        return TodoResponse.builder()
                .id(item.getId())
                .placeId(item.getPlaceId())
                .note(item.getNote())
                .isCompleted(item.getIsCompleted())
                .createdAt(item.getCreatedAt())
                .build();
    }
}
