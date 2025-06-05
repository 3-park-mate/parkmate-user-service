package com.parkmate.userservice.users.dto.request;

import com.parkmate.userservice.users.domain.User;
import com.parkmate.userservice.users.vo.request.UserRegisterRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterRequestDto {

    private String userUuid;
    private String name;
    private String email;
    private String phoneNumber;
    private int point;

    @Builder
    public UserRegisterRequestDto(String userUuid,
                                  String name,
                                  String email,
                                  String phoneNumber,
                                  int point) {
        this.userUuid = userUuid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

    public static UserRegisterRequestDto from(UserRegisterRequestVo userRegisterRequestVo) {
        return UserRegisterRequestDto.builder()
                .userUuid(userRegisterRequestVo.getUserUuid())
                .email(userRegisterRequestVo.getEmail())
                .name(userRegisterRequestVo.getName())
                .phoneNumber(userRegisterRequestVo.getPhoneNumber())
                .point(userRegisterRequestVo.getPoint())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userUuid(userUuid)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .point(point)
                .build();
    }

}