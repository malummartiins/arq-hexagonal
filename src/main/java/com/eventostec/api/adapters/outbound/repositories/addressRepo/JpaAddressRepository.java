package com.eventostec.api.adapters.outbound.repositories.addressRepo;

import com.eventostec.api.adapters.outbound.entities.JpaAddressEntity;
import com.eventostec.api.adapters.outbound.repositories.eventRepo.JpaEventRepository;
import com.eventostec.api.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaAddressRepository extends JpaRepository <JpaAddressEntity, UUID> {


    public Optional<Address> findByEventId(UUID eventId);
}
