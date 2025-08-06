package com.colorlight.booking_service.controller;

import com.colorlight.booking_service.domain.Role;
import com.colorlight.booking_service.dto.AddUserRequest;
import com.colorlight.booking_service.service.BusinessUserService;
import com.colorlight.booking_service.service.CommonUserService;
import com.colorlight.booking_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final CommonUserService commonUserService;
    private final BusinessUserService businessUserService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        switch (request.getRole()) {
            case BUSINESS -> businessUserService.save(request);
            case USER -> commonUserService.save(request);
        }

        return "redirect:/login";
    }
}
