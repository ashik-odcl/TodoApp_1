package com.example.TodoApp.service;

import com.example.TodoApp.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo createTodo(Todo todo);
    List<Todo>  getAllTodos();
    Todo getTodoById(Long id);
    Todo updateStatus(Long id, Boolean status);
    Todo updateTodo(Long id, Todo todo);
    void deleteTodo(Long id);
}
