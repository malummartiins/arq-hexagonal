package com.eventostec.api.application.service;

import com.eventostec.api.application.usecases.AddressUseCases;
import com.eventostec.api.domain.address.Address;
import com.eventostec.api.domain.address.AddressRepository;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.adapters.outbound.repositories.addressRepo.JpaAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressUseCases {

    private final AddressRepository addressRepository;

    public void createAddress(EventRequestDTO data, Event event) {
        Address address = new Address();
        address.setCity(data.city());
        address.setUf(data.state());
        address.setEvent(event);
        addressRepository.save(address);
    }

    public Optional<Address> findByEventId(UUID eventId) {
        return addressRepository.findByEventId(eventId);
    }
}

