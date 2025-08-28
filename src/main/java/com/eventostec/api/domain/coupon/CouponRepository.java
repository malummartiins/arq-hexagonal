package com.eventostec.api.domain.coupon;

import com.eventostec.api.domain.event.Event;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    Optional <List<Coupon>> findByEventIdAndValidAfter(UUID eventId, Date currentDate);

    Coupon save (Coupon coupon);
}
