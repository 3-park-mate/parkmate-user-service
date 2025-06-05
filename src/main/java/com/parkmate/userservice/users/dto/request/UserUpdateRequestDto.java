package com.parkmate.userservice.users.dto.request;

import com.parkmate.userservice.users.vo.request.UserUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;
    private String email;
    private String phoneNumber;

    @Builder
    public UserUpdateRequestDto(String name,
                                String email,
                                String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static UserUpdateRequestDto from(UserUpdateRequestVo userUpdateRequestVo) {
        return UserUpdateRequestDto.builder()
                .name(userUpdateRequestVo.getName())
                .email(userUpdateRequestVo.getEmail())
                .phoneNumber(userUpdateRequestVo.getPhoneNumber())
                .build();
    }

}