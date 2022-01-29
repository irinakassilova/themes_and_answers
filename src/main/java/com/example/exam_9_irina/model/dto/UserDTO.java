package com.example.exam_9_irina.model.dto;

import com.example.exam_9_irina.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserDTO {
    private int id;
    private String name;
    private String role;
    private String avatar;

    static public UserDTO from(User user){
        return builder()
                .id(user.getId())
                .name(user.getName())
                .role("USER")
                .build();
    }
}


