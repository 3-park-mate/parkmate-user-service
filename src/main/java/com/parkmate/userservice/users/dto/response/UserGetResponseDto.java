package com.parkmate.userservice.users.dto.response;

import com.parkmate.userservice.users.domain.User;
import com.parkmate.userservice.users.vo.response.UserGetResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserGetResponseDto {

    private String name;
    private String email;
    private String phoneNumber;
    private int point;

    @Builder
    public UserGetResponseDto(String name,
                              String email,
                              String phoneNumber,
                              int point) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

    public static UserGetResponseDto from(User user) {
        return UserGetResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .point(user.getPoint())
                .build();
    }

    public UserGetResponseVo toVo() {
        return UserGetResponseVo.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .point(point)
                .build();
    }

}