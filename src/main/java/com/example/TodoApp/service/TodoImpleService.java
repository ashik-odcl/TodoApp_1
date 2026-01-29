package com.example.TodoApp.service;

import com.example.TodoApp.dto.TodoRequestDto;
import com.example.TodoApp.dto.TodoResponseDto;
import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.exception.ResourceNotFoundException;
import com.example.TodoApp.mapper.TodoMapper;
import com.example.TodoApp.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoImpleService implements TodoService {
    private final TodoRepository todoRepository;

    // this is constructor injection, here object is not created
    // object is injected by spring boot
    public TodoImpleService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public TodoResponseDto createTodo(TodoRequestDto dto){
        Todo todo = TodoMapper.todoEntity(dto);
        return TodoMapper.todoResponseDto(todoRepository.save(todo));
    }
    @Override
    public List<TodoResponseDto> getAllTodos(){
        return todoRepository.findAll()
                .stream()
                .map(TodoMapper :: todoResponseDto)
                .collect(Collectors.toList());
    }
    @Override
    public TodoResponseDto getTodoById(Long id){
        Todo todo =  todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        return TodoMapper.todoResponseDto(todo);
    }
    @Override
    public TodoResponseDto updateStatus(Long id, Boolean status){
        Todo updateStatusTodo = todoRepository.findById(id).orElseThrow(((()->new ResourceNotFoundException(id))));
        updateStatusTodo.setCompleted(status);
        todoRepository.save(updateStatusTodo);
        return TodoMapper.todoResponseDto(updateStatusTodo);
    }


    @Override
    public TodoResponseDto updateTodo(Long id, TodoRequestDto todo){
        Todo updateTodo =   todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
            updateTodo.setCompleted(todo.isCompleted());
            updateTodo.setTitle(todo.getTitle());
            updateTodo.setDescription(todo.getDescription());
            todoRepository.save(updateTodo);
            return TodoMapper.todoResponseDto(updateTodo);
    }
    @Override
    public void deleteTodo(Long id){
        todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        todoRepository.deleteById(id);
    }
}
