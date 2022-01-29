package com.example.exam_9_irina.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "themes")
@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String title;

    @Column
    private LocalDate created= LocalDate.EPOCH;

    @Column
    private String description;

    @Column
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
