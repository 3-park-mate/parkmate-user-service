package com.parkmate.userservice.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    /**
     * 800 ~ 899 : internal server error
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 888, "서버에서 요청을 처리하지 못했습니다."),

    /**
     * 1000 ~ 1999 : user error
     */
    FAILED_TO_REGISTER_USER(HttpStatus.INTERNAL_SERVER_ERROR, false, 1000, "회원 등록에 실패하였습니다."),
    FAILED_TO_FIND_USER(HttpStatus.NOT_FOUND, false, 1001, "회원을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final boolean isSuccess;
    private final int code;
    private final String message;

}
