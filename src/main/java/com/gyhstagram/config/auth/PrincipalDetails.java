package com.gyhstagram.config.auth;

import com.gyhstagram.domain.User.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {
    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        //해당 유저의 권한을 리턴 getRole을 바로 할수 없음
        Collection<GrantedAuthority> collectors = new ArrayList<>();//자바 유틸 collector 권한을 넣어줌
        collectors.add(() -> "ROLE_" + user.getRole().toString()); //collector에 리턴되어서 권한이 들어감
        return collectors;
    }
}
