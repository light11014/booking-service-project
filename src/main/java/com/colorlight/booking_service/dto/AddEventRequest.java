package com.colorlight.booking_service.dto;

import com.colorlight.booking_service.domain.Event;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddEventRequest {
    private String name;
    private Long businessId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime openDate;
    private LocalDateTime ticketOpenDate;
    private Integer maxTicketPerUser;

    public Event toEntity() {
        return Event.builder()
                .name(name)
                .businessId(businessId)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .openDate(openDate)
                .ticketOpenDate(ticketOpenDate)
                .maxTicketPerUser(maxTicketPerUser)
                .build();
    }
}
