package com.colorlight.booking_service.service;

import com.colorlight.booking_service.domain.User;
import com.colorlight.booking_service.dto.AddUserRequest;
import com.colorlight.booking_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .loginId(dto.getLoginId())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .name(dto.getName())
                .role(dto.getRole()).build()).getId();
    }
}
