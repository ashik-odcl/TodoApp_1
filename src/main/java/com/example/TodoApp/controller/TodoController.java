package com.example.TodoApp.controller;

import com.example.TodoApp.dto.TodoRequestDto;
import com.example.TodoApp.dto.TodoResponseDto;
import com.example.TodoApp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }



    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<TodoResponseDto> addTodo(@Valid  @RequestBody TodoRequestDto todo){
        return ResponseEntity.status(201).body(todoService.createTodo(todo));
    }

    @GetMapping("/allTodo")
    @ResponseBody
    public List<TodoResponseDto> getAllTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return todoService.getAllTodos(page,size,sort,direction);
    }

    @GetMapping("getTodo")
    @ResponseBody
    public TodoResponseDto getTodoById(@Valid @RequestParam Long id){
        return todoService.getTodoById(id);
    }

    @PutMapping("updateStatus")
    @ResponseBody
    public TodoResponseDto updateStatus(@RequestParam Long id,@Valid @RequestBody Boolean status){
        return todoService.updateStatus(id, status);
    }

    @PutMapping("updateTodo")
    @ResponseBody
    public TodoResponseDto updateTodo(@RequestParam Long id,@Valid @RequestBody TodoRequestDto todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("deleteTodo")
    @ResponseBody
    public Boolean deleteUpdate(@RequestParam Long id){
        todoService.deleteTodo(id);
        return true;
    }


}
