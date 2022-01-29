package com.example.exam_9_irina.service;

import com.example.exam_9_irina.model.Answer;
import com.example.exam_9_irina.model.dto.AnswerDTO;
import com.example.exam_9_irina.repository.AnswerRepository;
import com.example.exam_9_irina.repository.ThemeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final ThemeRepository themeRepository;

    public List<Answer> getAnswer(int id) {
        return answerRepository.findAllByThemeId(id);
    }

    public void addAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setDescription(answerDTO.getDescription());
        answer.setTheme(themeRepository.getById(answerDTO.getThemeDTO().getId()));
        answerRepository.save(answer);
    }

    public int getAnswerThemeId(int answerId) {
        Answer answer = answerRepository.getById(answerId);
        return answer.getTheme().getId();
    }

    public List<Answer>getAll() {
        return answerRepository.findAll();
    }
}


