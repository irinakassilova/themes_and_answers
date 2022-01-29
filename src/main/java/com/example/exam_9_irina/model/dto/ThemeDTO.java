package com.example.exam_9_irina.model.dto;

import com.example.exam_9_irina.model.Theme;
import com.example.exam_9_irina.model.User;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeDTO {
    private Integer id;
    private String title;
    private String description;
    private LocalDate created = LocalDate.now();
    private int count;
    private User user;

    public static ThemeDTO from(Theme theme) {
        return builder()
                .id(theme.getId())
                .title(theme.getTitle())
                .created(theme.getCreated())
                .description(theme.getDescription())
                .count(theme.getCount())
                .user(theme.getUser())
                .build();
    }
}

