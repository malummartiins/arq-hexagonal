package com.eventostec.api.adapters.outbound.entities;

import com.eventostec.api.domain.address.Address;
import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "address")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JpaAddressEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String city;
    private String uf;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public JpaAddressEntity(Address address) {
        this.id = address.getId();
        this.city = address.getCity();
        this.uf = address.getUf();
        this.event = address.getEvent();
    }
}


