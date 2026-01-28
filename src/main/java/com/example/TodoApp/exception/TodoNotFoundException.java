package com.example.TodoApp.exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super(id +" id todo not found");
    }

}
