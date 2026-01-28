package com.example.TodoApp.service;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.exception.TodoNotFoundException;
import com.example.TodoApp.repository.TodoRepository;
import com.example.TodoApp.service.TodoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoImpleService implements TodoService {
    private final TodoRepository todoRepository;

    // this is constructor injection, here object is not created
    // object is injected by spring boot
    public TodoImpleService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    @Override
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();

    }
    @Override
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(()->new TodoNotFoundException(id));
    }
    @Override
    public Todo updateStatus(Long id, Boolean status){
        Todo updateStatusTodo = todoRepository.findById(id).isPresent() ? todoRepository.findById(id).get() : null;
        if(updateStatusTodo != null){
            updateStatusTodo.setCompleted(status);
        }
        return updateStatusTodo;
    }


    @Override
    public Todo updateTodo(Long id, Todo todo){
        Todo updateTodo =   todoRepository.findById(id).orElseThrow(()->new TodoNotFoundException(id));
            updateTodo.setCompleted(todo.isCompleted());
            updateTodo.setTitle(todo.getTitle());
            updateTodo.setDescription(todo.getDescription());
            todoRepository.save(updateTodo);
            return updateTodo;
    }
    @Override
    public void deleteTodo(Long id){
        todoRepository.findById(id).orElseThrow(()->new TodoNotFoundException(id));
        todoRepository.deleteById(id);
    }
}
