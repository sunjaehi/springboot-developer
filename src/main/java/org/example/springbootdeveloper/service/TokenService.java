package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.config.jwt.TokenProvider;
import org.example.springbootdeveloper.domain.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service

public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    //전달받은 리프레시 토큰으로 토큰 유효성 검사를 진행하고,
    //유효한 토큰일 때 리프레시 토큰으로 사용자 ID를 찾음
    public String createNewAccessToken(String refreshToken) {
        //토큰 유효성 검사에 실패하면 예외발생
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected Token");
        }
        Long userId=refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user=userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
