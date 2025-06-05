package com.parkmate.userservice.users.presentation;

import com.parkmate.userservice.common.response.BaseResponseEntity;
import com.parkmate.userservice.common.response.ResponseMessage;
import com.parkmate.userservice.users.application.UserService;
import com.parkmate.userservice.users.dto.request.UserUpdateRequestDto;
import com.parkmate.userservice.users.vo.request.UserUpdateRequestVo;
import com.parkmate.userservice.users.vo.response.UserGetResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "유저 수정",
            description = "userUuid를 PathVariable로 받고, 수정할 유저 정보를 RequestBody로 받아 유저 정보를 수정하는 API 입니다.",
            tags = {"USER-SERVICE"}
    )
    @PutMapping("/{userUuid}")
    public BaseResponseEntity<Void> updateUser(@PathVariable String userUuid,
                                               @RequestBody UserUpdateRequestVo userUpdateRequestVo) {
        userService.updateUser(userUuid,
                UserUpdateRequestDto.from(userUpdateRequestVo));

        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_MODIFY_USER.getMessage());
    }

    @Operation(
            summary = "유저 조회",
            description = "userUuid를 PathVariable로 받아 해당 유저 정보를 조회하는 API 입니다.",
            tags = {"USER-SERVICE"}
    )
    @GetMapping("/{userUuid}")
    public BaseResponseEntity<UserGetResponseVo> getUserByUuid(@PathVariable String userUuid) {

        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_GET_USER.getMessage(),
                userService.findUserByUuid(userUuid).toVo());
    }

    @Operation(
            summary = "유저 삭제",
            description = "userUuid를 PathVariable로 받아 해당 유저 정보를 삭제하는 API 입니다.",
            tags = {"USER-SERVICE"}
    )
    @DeleteMapping("/{userUuid}")
    public BaseResponseEntity<Void> deleteUser(@PathVariable String userUuid) {
        userService.deleteUser(userUuid);

        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_DELETE_USER.getMessage());
    }

}