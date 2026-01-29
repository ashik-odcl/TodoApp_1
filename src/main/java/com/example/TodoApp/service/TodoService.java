package com.example.TodoApp.service;

import com.example.TodoApp.dto.TodoRequestDto;
import com.example.TodoApp.dto.TodoResponseDto;
import com.example.TodoApp.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    TodoResponseDto createTodo(TodoRequestDto todo);
    List<TodoResponseDto>  getAllTodos();
    TodoResponseDto getTodoById(Long id);
    TodoResponseDto updateStatus(Long id, Boolean status);
    TodoResponseDto updateTodo(Long id, TodoRequestDto todo);
    void deleteTodo(Long id);
}
