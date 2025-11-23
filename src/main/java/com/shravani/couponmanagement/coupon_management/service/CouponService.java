package com.shravani.couponmanagement.coupon_management.service;

import com.shravani.couponmanagement.coupon_management.model.*;
import com.shravani.couponmanagement.coupon_management.repository.CouponRepository;
import com.shravani.couponmanagement.coupon_management.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class CouponService {

    private final CouponRepository repository;
    private final CouponEligibilityService eligibilityService;

    public CouponService(CouponRepository repository, CouponEligibilityService eligibilityService) {
        this.repository = repository;
        this.eligibilityService = eligibilityService;
    }

    public Coupon createCoupon(CreateCouponRequest req) {
        Coupon c = req.toCoupon();
        repository.save(c);
        return c;
    }

    public BestCouponResponse findBestCoupon(BestCouponRequest req) {
        List<Coupon> coupons = repository.findAll();
        UserContext user = req.getUser();
        Cart cart = req.getCart();
        double cartValue = cart.getCartValue();

        return coupons.stream()
                .filter(c -> isValidDate(c))
                .filter(c -> eligibilityService.isEligible(c, user, cart))
                .map(c -> new BestCouponResponse(c, eligibilityService.calculateDiscount(c, cartValue)))
                .max(Comparator.comparing(BestCouponResponse::getDiscountAmount)
                        .thenComparing(r -> r.getCouponCode()))
                .orElse(null);
    }

    private boolean isValidDate(Coupon c) {
        LocalDate now = LocalDate.now();
        return (c.getStartDate().isEqual(now) || c.getStartDate().isBefore(now))
                && (c.getEndDate().isEqual(now) || c.getEndDate().isAfter(now));
    }
}
