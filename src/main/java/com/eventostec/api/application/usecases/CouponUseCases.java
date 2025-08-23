package com.eventostec.api.application.usecases;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CouponUseCases {
    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponData);

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate);
}
