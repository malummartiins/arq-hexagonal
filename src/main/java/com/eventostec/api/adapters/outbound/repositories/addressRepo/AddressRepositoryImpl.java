package com.eventostec.api.adapters.outbound.repositories.addressRepo;

import com.eventostec.api.adapters.outbound.entities.JpaAddressEntity;
import com.eventostec.api.adapters.outbound.entities.JpaEventEntity;
import com.eventostec.api.domain.address.Address;
import com.eventostec.api.domain.address.AddressRepository;

import java.util.Optional;
import java.util.UUID;

public class AddressRepositoryImpl implements AddressRepository {

    private final JpaAddressRepository jpaAddressRepository;

    public AddressRepositoryImpl(JpaAddressRepository jpaAddressRepository) {
        this.jpaAddressRepository = jpaAddressRepository;
    }

    @Override
    public Optional<Address> findByEventId(UUID eventId) {
        return this.jpaAddressRepository.findByEventId(eventId);
    }

    @Override
    public Address save(Address address) {
        JpaAddressEntity addressEntity = new JpaAddressEntity(address);
        this.jpaAddressRepository.save(addressEntity);
        return new Address(address.getId(), address.getCity(), address.getUf(), address.getEvent());
    }
}
