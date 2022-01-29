package com.example.exam_9_irina.service;

import com.example.exam_9_irina.exception.UserAlreadyRegister;
import com.example.exam_9_irina.model.User;
import com.example.exam_9_irina.model.dto.UserDTO;
import com.example.exam_9_irina.model.form.UserRegisterForm;
import com.example.exam_9_irina.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import java.security.Principal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserDTO register(UserRegisterForm user) {
        if (repository.existsByName(user.getName())) {
            throw new UserAlreadyRegister();
        }

        var userRegister = User.builder()
                .name(user.getName())
                .password(encoder.encode(user.getPassword()))
                .role("USER")
                .build();

        repository.save(userRegister);

        return UserDTO.from(userRegister);

    }

    public UserDTO getByEmail(String name) {
        var user = repository.findByName(name);

        return UserDTO.from(user);
    }
}


