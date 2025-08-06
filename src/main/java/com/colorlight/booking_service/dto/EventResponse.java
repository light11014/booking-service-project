package com.colorlight.booking_service.dto;

import com.colorlight.booking_service.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EventResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public EventResponse(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
    }
}
