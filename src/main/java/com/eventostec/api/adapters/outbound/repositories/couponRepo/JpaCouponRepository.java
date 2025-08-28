package com.eventostec.api.adapters.outbound.repositories.couponRepo;

import com.eventostec.api.adapters.outbound.entities.JpaCouponEntity;
import com.eventostec.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface JpaCouponRepository extends JpaRepository <JpaCouponEntity, UUID> {
    List<Coupon> findByEventIdAndValidAfter(UUID eventId, Date currentDate);


}
