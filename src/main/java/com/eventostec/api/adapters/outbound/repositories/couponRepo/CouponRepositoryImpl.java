package com.eventostec.api.adapters.outbound.repositories.couponRepo;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final JpaCouponRepository couponRepository;

    public CouponRepositoryImpl(JpaCouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<Coupon> findByEventIdAndValidAfter(UUID eventId, Date currentDate) {
        return this.couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}
