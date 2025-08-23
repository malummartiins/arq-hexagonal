package com.eventostec.api.domain.address;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository {
    Optional<Address> findByEventId(UUID eventId);

    Address save(Address address);
}
