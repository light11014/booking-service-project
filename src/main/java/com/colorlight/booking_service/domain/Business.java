package com.colorlight.booking_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Business {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(name = "company_address", nullable = false)
    private String companyAddress;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "business_number", unique = true, nullable = false)
    private String businessNumber;

    @Builder
    public Business(Long userId, String companyAddress, String companyName, String businessNumber) {
        this.userId = userId;
        this.companyAddress = companyAddress;
        this.companyName = companyName;
        this.businessNumber = businessNumber;
    }
}
