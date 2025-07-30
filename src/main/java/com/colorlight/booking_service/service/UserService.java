package com.colorlight.booking_service.service;

import com.colorlight.booking_service.domain.User;
import com.colorlight.booking_service.dto.AddUserRequest;

public interface UserService {
    Long save(AddUserRequest request);

    User findById(Long id);
}
