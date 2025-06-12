package com.parkmate.userservice.users.dto.request;

import com.parkmate.userservice.users.vo.request.UserUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String userUuid;
    private String name;
    private String phoneNumber;

    @Builder
    private UserUpdateRequestDto(String userUuid,
                                 String name,
                                 String phoneNumber) {
        this.userUuid = userUuid;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static UserUpdateRequestDto from(String userUuid, UserUpdateRequestVo userUpdateRequestVo) {
        return UserUpdateRequestDto.builder()
                .userUuid(userUuid)
                .name(userUpdateRequestVo.getName())
                .phoneNumber(userUpdateRequestVo.getPhoneNumber())
                .build();
    }

}