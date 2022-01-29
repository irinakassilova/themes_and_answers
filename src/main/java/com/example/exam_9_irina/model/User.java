package com.example.exam_9_irina.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Table(name="users")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String name;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(length = 128)
    private String password;

    @Column
    private String role;

    @Column
    @Builder.Default
    private boolean enabled = true;
}
