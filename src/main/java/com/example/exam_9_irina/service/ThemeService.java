package com.example.exam_9_irina.service;

import com.example.exam_9_irina.exception.ResourceNotFoundException;
import com.example.exam_9_irina.model.Answer;
import com.example.exam_9_irina.model.Theme;
import com.example.exam_9_irina.model.User;
import com.example.exam_9_irina.model.dto.ThemeDTO;
import com.example.exam_9_irina.repository.AnswerRepository;
import com.example.exam_9_irina.repository.ThemeRepository;
import com.example.exam_9_irina.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public Page<ThemeDTO> getThemes(Pageable pageable) {
        return themeRepository.findAll(pageable)
                .map(ThemeDTO::from);
    }

    public ThemeDTO getTheme(int id) {
        var theme = themeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("theme", id));
        return ThemeDTO.from(theme);
    }

    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    public Theme getById(int themeId) {
        return themeRepository.getById(themeId);
    }

    public void addTheme(ThemeDTO themeDTO, String name) {
        Theme theme = new Theme();
        theme.setTitle(themeDTO.getTitle());
//        theme.setCreated(themeDTO.getCreated());
        //        LocalDateTime currentDate = LocalDateTime.now();
        User user = userRepository.findByName(name);
        theme.setUser(user);
        theme.setDescription(themeDTO.getDescription());
        themeRepository.save(theme);
    }
//
//    public List<Answer> findAllAnswersByThemeId(int themeId) {
//        return answerRepository.findAllByThemeId(themeId);
//    }
}
