package com.parkmate.userservice.users.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("유저 UUID")
    @Column(name = "user_uuid", nullable = false, length = 36)
    private String userUuid;

    @Comment("유저 이름")
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Comment("유저 이메일")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Comment("유저 전화번호")
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Comment("유저 포인트")
    @Column(name = "point", nullable = false)
    private int point;

    @Builder
    public User(Long id,
                String userUuid,
                String name,
                String email,
                String phoneNumber,
                int point) {
        this.id = id;
        this.userUuid = userUuid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

    public void update(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}