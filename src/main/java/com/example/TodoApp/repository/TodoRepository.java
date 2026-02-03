package com.example.TodoApp.repository;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByUser(User user, Pageable pageable);
    Optional<Todo> findByIdAndUser(Long id, User user);
}
