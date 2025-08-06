package com.colorlight.booking_service.service;

import com.colorlight.booking_service.domain.Event;
import com.colorlight.booking_service.dto.AddEventRequest;
import com.colorlight.booking_service.dto.UpdateEventRequest;
import com.colorlight.booking_service.repository.BusinessRepository;
import com.colorlight.booking_service.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventRepository eventRepository;
    private final BusinessRepository businessRepository;

    public Event save(AddEventRequest dto) {
        businessRepository.findById(dto.getBusinessId())
                .orElseThrow(() -> new IllegalArgumentException("unexpected business account"));

        return eventRepository.save(dto.toEntity());
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("unexpected event id"));
    }

    public void delete(long id) {
        eventRepository.deleteById(id);
    }

    @Transactional
    public Event update(long id, UpdateEventRequest request) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        event.update(request);
        return event;
    }
}
