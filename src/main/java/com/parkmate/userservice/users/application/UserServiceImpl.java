package com.parkmate.userservice.users.application;

import com.parkmate.userservice.common.exception.BaseException;
import com.parkmate.userservice.common.exception.ErrorCode;
import com.parkmate.userservice.users.domain.User;
import com.parkmate.userservice.users.dto.request.UserRegisterRequestDto;
import com.parkmate.userservice.users.dto.request.UserUpdateRequestDto;
import com.parkmate.userservice.users.dto.response.UserGetResponseDto;
import com.parkmate.userservice.users.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.parkmate.userservice.common.exception.ErrorCode.FAILED_TO_FIND_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(UserRegisterRequestDto userRegisterRequestDto) {
        try {
            userRepository.save(userRegisterRequestDto.toEntity());
        } catch (Exception e) {
            throw new BaseException(ErrorCode.FAILED_TO_REGISTER_USER);
        }

    }

    @Transactional
    @Override
    public void updateUser(String userUuid,
                           UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(FAILED_TO_FIND_USER));

        user.update(userUpdateRequestDto.getName(),
                userUpdateRequestDto.getEmail(),
                userUpdateRequestDto.getPhoneNumber());
    }

    @Transactional(readOnly = true)
    @Override
    public UserGetResponseDto findUserByUuid(String userUuid) {
        User user = userRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(FAILED_TO_FIND_USER));

        return UserGetResponseDto.from(user);
    }

    @Transactional
    @Override
    public void deleteUser(String userUuid) {
        User user = userRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(FAILED_TO_FIND_USER));

        userRepository.delete(user);
    }

}