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
    private String phoneNumber;

    @Builder
    private UserRegisterRequestDto(String userUuid,
                                   String name,
                                   String phoneNumber) {
        this.userUuid = userUuid;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static UserRegisterRequestDto from(UserRegisterRequestVo userRegisterRequestVo) {
        return UserRegisterRequestDto.builder()
                .userUuid(userRegisterRequestVo.getUserUuid())
                .name(userRegisterRequestVo.getName())
                .phoneNumber(userRegisterRequestVo.getPhoneNumber())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userUuid(userUuid)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }

}