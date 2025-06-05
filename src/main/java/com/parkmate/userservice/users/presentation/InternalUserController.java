package com.parkmate.userservice.users.presentation;

import com.parkmate.userservice.common.response.BaseResponseEntity;
import com.parkmate.userservice.common.response.ResponseMessage;
import com.parkmate.userservice.users.application.UserService;
import com.parkmate.userservice.users.dto.request.UserRegisterRequestDto;
import com.parkmate.userservice.users.vo.request.UserRegisterRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalUserController {

    private final UserService userService;

    @Operation(
            summary = "유저 등록",
            description = "Auth-service에서 openFeign으로 전송받은 UserRegisterRequestVo로 유저를 등록하는 API 입니다.",
            tags = "{USER-SERVICE}"
    )
    @PostMapping("/register")
    public BaseResponseEntity<Void> register(@RequestBody UserRegisterRequestVo userRegisterRequestVo) {
        userService.createUser(UserRegisterRequestDto.from(userRegisterRequestVo));

        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_REGISTER_USER.getMessage());
    }

}
