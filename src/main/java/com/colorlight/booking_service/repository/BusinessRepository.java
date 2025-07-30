package com.colorlight.booking_service.repository;

import com.colorlight.booking_service.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
