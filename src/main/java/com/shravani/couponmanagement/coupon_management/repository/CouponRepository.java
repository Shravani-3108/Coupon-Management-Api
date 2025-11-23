package com.shravani.couponmanagement.coupon_management.repository;
import com.shravani.couponmanagement.coupon_management.model.Coupon;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class CouponRepository {
        // In-memory store
        private final Map<String, Coupon> coupons = new HashMap<>();

        public void save(Coupon coupon) {
            if (coupons.containsKey(coupon.getCode())) {
                throw new IllegalArgumentException("Coupon code already exists: " + coupon.getCode());
            }
            coupons.put(coupon.getCode(), coupon);
        }

        public Optional<Coupon> findByCode(String code) {
            return Optional.ofNullable(coupons.get(code));
        }

        public List<Coupon> findAll() {
            return new ArrayList<>(coupons.values());
        }



}
