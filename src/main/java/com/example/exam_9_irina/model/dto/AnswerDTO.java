package com.example.exam_9_irina.model.dto;

import com.example.exam_9_irina.model.Answer;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerDTO {

    private int id;
    private String description;
    private ThemeDTO themeDTO;

    public static AnswerDTO from(Answer answer) {
        return builder()
                .id(answer.getId())
                .description(answer.getDescription())
                .themeDTO(ThemeDTO.from(answer.getTheme()))
                .build();
    }
}

