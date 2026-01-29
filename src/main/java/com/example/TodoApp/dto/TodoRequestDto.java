package com.example.TodoApp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDto {

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title should be less than 150")
    private String title;

    @Size(max = 500, message = "Message should be less than 500")
    private String description;

    private boolean completed;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String  getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
