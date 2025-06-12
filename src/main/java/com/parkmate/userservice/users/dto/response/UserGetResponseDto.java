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
    private String phoneNumber;
    private int point;

    @Builder
    private UserGetResponseDto(String name,
                              String phoneNumber,
                              int point) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

    public static UserGetResponseDto from(User user) {
        return UserGetResponseDto.builder()
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .point(user.getPoint())
                .build();
    }

    public UserGetResponseVo toVo() {
        return UserGetResponseVo.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .point(point)
                .build();
    }

}