package com.gyhstagram.web.dto;

import com.gyhstagram.domain.User.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinReqDto {
    private String username;
    private String password;
    private String email;
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
