package com.colorlight.booking_service.repository;

import com.colorlight.booking_service.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
