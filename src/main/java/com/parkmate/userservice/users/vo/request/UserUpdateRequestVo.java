package com.parkmate.userservice.users.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestVo {

    private String name;
    private String phoneNumber;

}