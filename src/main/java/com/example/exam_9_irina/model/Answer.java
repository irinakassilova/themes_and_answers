package com.example.exam_9_irina.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "answers")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1280)
    private String description;

    @Column
    private LocalDate created = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}

