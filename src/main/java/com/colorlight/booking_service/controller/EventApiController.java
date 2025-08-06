package com.colorlight.booking_service.controller;

import com.colorlight.booking_service.domain.CustomUserDetails;
import com.colorlight.booking_service.domain.Event;
import com.colorlight.booking_service.dto.AddEventRequest;
import com.colorlight.booking_service.dto.EventListViewResponse;
import com.colorlight.booking_service.dto.EventResponse;
import com.colorlight.booking_service.dto.UpdateEventRequest;
import com.colorlight.booking_service.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventApiController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponse> registerEvent(@RequestBody AddEventRequest request) {
        Event savedEvent = eventService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new EventResponse(savedEvent));
    }

    @GetMapping
    public ResponseEntity<List<EventListViewResponse>> getAllEvents() {
        List<EventListViewResponse> events = eventService.findAll().stream()
                .map(EventListViewResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEvent(@PathVariable Long id) {
        Event event = eventService.findById(id);
        return ResponseEntity.ok()
                .body(new EventResponse(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @RequestBody UpdateEventRequest request) {
        Event updatedEvent = eventService.update(id, request);
        return ResponseEntity.ok()
                .body(new EventResponse(updatedEvent));
    }
}
