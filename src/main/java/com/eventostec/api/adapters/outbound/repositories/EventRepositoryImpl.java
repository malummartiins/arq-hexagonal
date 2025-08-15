package com.eventostec.api.adapters.outbound.repositories;

import com.eventostec.api.adapters.outbound.entities.JpaEventEntity;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventRepositoryImpl implements EventRepository {

    private final JpaEventRepository jpaEventRepository;

    public EventRepositoryImpl (JpaEventRepository jpaEventRepository){
        this.jpaEventRepository = jpaEventRepository;
    }

    @Override
    public Event save(Event event) {
        JpaEventEntity eventEntity = new JpaEventEntity(event);
        this.jpaEventRepository.save(eventEntity);
        return new Event(eventEntity.getId(), eventEntity.getTitle(), eventEntity.getDescription(),
                eventEntity.getImgUrl(), event.getEventUrl(), eventEntity.getRemote(), eventEntity.getDate());
    }

    @Override
    public Event findById(UUID id) {
        Optional<JpaEventEntity> eventEntity = this.jpaEventRepository.findById(id);
        return eventEntity.map(entity -> new Event(entity.getId(), entity.getTitle(),
                entity.getDescription(), entity.getImgUrl(), entity.getEventUrl(),
                entity.getRemote(), entity.getDate())).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return this.jpaEventRepository.findAll()
                .stream()
                .map(entity -> new Event(entity.getId(), entity.getTitle(),
                entity.getDescription(), entity.getImgUrl(), entity.getEventUrl(),
                entity.getRemote(), entity.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaEventRepository.deleteById(id);
    }
}
