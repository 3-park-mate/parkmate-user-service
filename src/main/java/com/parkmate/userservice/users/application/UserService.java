package com.parkmate.userservice.users.application;

import com.parkmate.userservice.users.dto.request.UserRegisterRequestDto;
import com.parkmate.userservice.users.dto.request.UserUpdateRequestDto;
import com.parkmate.userservice.users.dto.response.UserGetResponseDto;

public interface UserService {

    void createUser(UserRegisterRequestDto userRegisterRequestDto);

    void updateUser(String userUuid, UserUpdateRequestDto userUpdateRequestDto);

    UserGetResponseDto findUserByUuid(String userUuid);

    void deleteUser(String userUuid);

}