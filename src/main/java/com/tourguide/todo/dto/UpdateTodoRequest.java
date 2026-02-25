package com.tourguide.todo.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoRequest {

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    private Boolean isCompleted;
}
