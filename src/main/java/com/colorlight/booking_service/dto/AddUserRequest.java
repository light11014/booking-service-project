package com.colorlight.booking_service.dto;

import com.colorlight.booking_service.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String loginId;
    private String password;
    private Role role;
    private String email;
    private String name;
    private String phoneNumber;

    // business 필드
    private String companyAddress;
    private String companyName;
    private String businessNumber;
}
