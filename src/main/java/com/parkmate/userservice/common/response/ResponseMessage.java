package com.parkmate.userservice.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {

    SUCCESS_REGISTER_USER("유저 등록에 성공하였습니다."),
    SUCCESS_GET_USER("유저 조회에 성공하였습니다."),
    SUCCESS_DELETE_USER("유저 삭제에 성공하였습니다."),
    SUCCESS_MODIFY_USER("유저 수정에 성공하였습니다.");

    private final String message;

}