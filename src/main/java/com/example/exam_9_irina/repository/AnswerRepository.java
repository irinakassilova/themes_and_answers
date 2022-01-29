package com.example.exam_9_irina.repository;

import com.example.exam_9_irina.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByThemeId(int themeId);
}

