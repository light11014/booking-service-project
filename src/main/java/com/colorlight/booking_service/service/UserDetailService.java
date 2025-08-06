package com.colorlight.booking_service.service;

import com.colorlight.booking_service.domain.CustomUserDetails;
import com.colorlight.booking_service.domain.Role;
import com.colorlight.booking_service.domain.User;
import com.colorlight.booking_service.repository.BusinessRepository;
import com.colorlight.booking_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("UserDetailService : " + loginId));

        Long businessId = null;
        if(user.getRole() == Role.BUSINESS) {
            businessId = businessRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Business 정보 없음")).getId();
        }

        return new CustomUserDetails(user, businessId);
    }
}
