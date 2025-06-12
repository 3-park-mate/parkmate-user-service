package com.parkmate.userservice.users.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserGetResponseVo {

    private String name;
    private String phoneNumber;
    private int point;

    @Builder
    public UserGetResponseVo(String name,
                             String phoneNumber,
                             int point) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

}