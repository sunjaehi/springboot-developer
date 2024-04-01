package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.domain.User;
import org.example.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override //사용자의 이름(email)으로 사용자의 정보를 가져오는 메서드
    public User loadUserByUserName(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException((email));
    }

}
