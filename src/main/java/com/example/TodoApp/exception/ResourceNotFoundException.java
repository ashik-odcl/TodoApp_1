package com.example.TodoApp.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super(id +" id todo not found");
    }

}
