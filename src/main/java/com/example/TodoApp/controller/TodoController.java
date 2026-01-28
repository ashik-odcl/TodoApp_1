package com.example.TodoApp.controller;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping("/allTodo")
    @ResponseBody
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }


    @PutMapping("updateStatus")
    @ResponseBody
    public Todo updateStatus(@RequestParam Long id,@RequestBody Boolean status){
        return todoService.updateStatus(id, status);
    }

    @PutMapping("updateTodo")
    @ResponseBody
    public Todo updateTodo(@RequestParam Long id,@RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("deleteTodo")
    @ResponseBody
    public Boolean deleteUpdate(@RequestParam Long id){
        todoService.deleteTodo(id);
        return true;
    }

}
