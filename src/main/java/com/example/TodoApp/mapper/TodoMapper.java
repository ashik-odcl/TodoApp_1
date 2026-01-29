package com.example.TodoApp.mapper;

import com.example.TodoApp.dto.TodoRequestDto;
import com.example.TodoApp.dto.TodoResponseDto;
import com.example.TodoApp.entity.Todo;

public class TodoMapper {
    public static Todo todoEntity(TodoRequestDto dto){
        Todo todo = new Todo();
        todo.setDescription(dto.getDescription());
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }

    public static TodoResponseDto todoResponseDto(Todo todo){
        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(todo.getId());
        todoResponseDto.setDescription(todo.getDescription());
        todoResponseDto.setCompleted(todo.isCompleted());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setCreatedAt(todo.getCreatedAt());
        return todoResponseDto;
    }
}

