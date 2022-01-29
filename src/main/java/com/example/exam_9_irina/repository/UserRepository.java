package com.example.exam_9_irina.repository;

import com.example.exam_9_irina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByName(String name);
    User findByName(String name);
}