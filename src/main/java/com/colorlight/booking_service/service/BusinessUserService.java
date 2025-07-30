package com.colorlight.booking_service.service;

import com.colorlight.booking_service.domain.Business;
import com.colorlight.booking_service.dto.AddUserRequest;
import com.colorlight.booking_service.repository.BusinessRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessUserService {
    private final BusinessRepository businessRepository;
    private final CommonUserService commonUserService;

    @Transactional
    public Long save(AddUserRequest dto) {
        Long userId = commonUserService.save(dto);
        return businessRepository.save(Business.builder()
                        .userId(userId)
                        .companyAddress(dto.getCompanyAddress())
                        .companyName(dto.getCompanyName())
                        .businessNumber(dto.getBusinessNumber())
                        .build()).getId();
    }
}
