package com.eventostec.api.adapters.outbound.repositories.couponRepo;

import com.eventostec.api.adapters.outbound.entities.JpaCouponEntity;
import com.eventostec.api.adapters.outbound.entities.JpaEventEntity;
import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRepository;
import com.eventostec.api.domain.event.Event;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final JpaCouponRepository couponRepository;

    public CouponRepositoryImpl(JpaCouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Optional<List<Coupon>> findByEventIdAndValidAfter(UUID eventId, Date currentDate) {
        return Optional.ofNullable(this.couponRepository.findByEventIdAndValidAfter(eventId, currentDate));
    }

    @Override
    public Coupon save(Coupon coupon) {
        JpaCouponEntity couponEntity = new JpaCouponEntity();
        this.couponRepository.save(couponEntity);
        return new Coupon(couponEntity.getId(), couponEntity.getCode(), couponEntity.getDiscount(),
                couponEntity.getValid(),couponEntity.getEvent());
    }
}
