package com.gyhstagram.web.service;

import com.gyhstagram.domain.User.User;
import com.gyhstagram.domain.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinMember(User user) {
        String rawPassword = user.getPassword();
        log.info("rawpassword={},encPasswrod ={}",rawPassword);
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("USER");
        userRepository.save(user);
    }
}
