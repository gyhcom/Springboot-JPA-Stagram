package com.gyhstagram.config.auth;

import com.gyhstagram.domain.User.User;
import com.gyhstagram.domain.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
      log.info("로그인 진행 ={}",username);
        User principal = userRepository.findByUsername(username);

        if (principal == null) {
            return null;
        } else{
            log.info("로그인 정보" + principal);

            return new PrincipalDetails(principal);
        }
    }
}
