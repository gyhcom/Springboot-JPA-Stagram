package com.gyhstagram.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, unique = true)
    private String username;

    @JsonIgnore//제이슨 파싱불가하게 막음
    private String password;
    private String name; // 이름
    private String website; //자기 홈페이지
    private String bio; //자기소개
    private String email;
    private String phone;
    private String gender;
    private String profileImage; // 프로필 이미지 경로로 설정

    private String provider; // 제공자, google, facebook, naver 구분 / provider가 null 이면 기본 로그인

    private String role; // USER,ADMIN

    @CreationTimestamp // 자동으로 만든시간이 들어감
    private Timestamp createDate;


}
