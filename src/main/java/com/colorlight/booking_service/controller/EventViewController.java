package com.colorlight.booking_service.controller;

import com.colorlight.booking_service.domain.CustomUserDetails;
import com.colorlight.booking_service.domain.Event;
import com.colorlight.booking_service.dto.EventListViewResponse;
import com.colorlight.booking_service.service.EventService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class EventViewController {
    private final EventService eventService;

    @GetMapping("/events")
    public String getEvents(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<EventListViewResponse> events = eventService.findAll().stream()
                .map(EventListViewResponse::new)
                .toList();

        model.addAttribute("events", events);

        if (userDetails != null) {
            model.addAttribute("userRole", userDetails.getRole());
        }

        return "eventList";
    }
}
