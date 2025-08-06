package com.colorlight.booking_service.domain;

import com.colorlight.booking_service.dto.UpdateEventRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "business_id", nullable = false)
    private Long businessId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;  // 이벤트 시작 날짜

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;  // 이벤트 종료 날짜

    @Column(name = "event_open_date", nullable = false)
    private LocalDateTime openDate;  // 이벤트 공개 날짜

    @Column(name = "ticket_open_date", nullable = false)
    private LocalDateTime ticketOpenDate;  // 예약 오픈 날짜

    @Column(name = "max_ticket_per_user", nullable = false)
    private Integer maxTicketPerUser;

    @Builder
    public Event(Long businessId, String name, String description, LocalDate startDate, LocalDate endDate,
                 LocalDateTime openDate, LocalDateTime ticketOpenDate, Integer maxTicketPerUser) {
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.openDate = openDate;
        this.ticketOpenDate = ticketOpenDate;
        this.maxTicketPerUser = maxTicketPerUser;
    }

    public void update(UpdateEventRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.openDate = request.getOpenDate();
        this.ticketOpenDate = request.getTicketOpenDate();
        this.maxTicketPerUser = request.getMaxTicketPerUser();
    }
}
