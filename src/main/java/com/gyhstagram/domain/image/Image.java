package com.gyhstagram.domain.image;

import com.gyhstagram.domain.Likes.Likes;
import com.gyhstagram.domain.Tag.Tag;
import com.gyhstagram.domain.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption; //내용 ex) 오늘 운동 완료
    private String postImageUrl;

    @ManyToOne
    @JoinColumn(name = "userId")//DB컬럼명에 이렇게 담김
    private User user; //자식이 외래키의 주인, 한명의 유저는 여러개의 이미지를 만들수 있음

    //양방향 매핑 , DB에 생기면 안됨
    @OneToMany(mappedBy = "image") //외래키의 변수명을 적으면 된다. 기본 LAZY
    private List<Tag> tags;

    //라이크 정보도 가지고 있어야함 그래야 조건 걸수 있음
    @OneToMany(mappedBy = "image") //외래키의 변수명을 적으면 된다 기본LAZY
    private List<Likes> likes;

    //follow정보
    //comment 댓글

    @CreationTimestamp
    private Timestamp createDate;

}
