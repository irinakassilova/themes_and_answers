package com.example.exam_9_irina.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegisterForm {
    @NotBlank
    private String name= "";

    @NotBlank
    private String password = "";
}