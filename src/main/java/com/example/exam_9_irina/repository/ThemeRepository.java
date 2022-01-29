package com.example.exam_9_irina.repository;

import com.example.exam_9_irina.model.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    Page<Theme> findAll(Pageable pageable);
}