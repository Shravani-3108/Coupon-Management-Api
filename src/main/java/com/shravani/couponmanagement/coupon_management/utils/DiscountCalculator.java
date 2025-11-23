package com.shravani.couponmanagement.coupon_management.utils;
import com.shravani.couponmanagement.coupon_management.model.Coupon;
import org.springframework.stereotype.Component;
@Component
public class DiscountCalculator {
    public double calculate(Coupon coupon, double cartValue) {
        if ("FLAT".equalsIgnoreCase(coupon.getDiscountType())) {
            return coupon.getDiscountValue();
        } else {
            double discount = (coupon.getDiscountValue() / 100.0) * cartValue;

            if (coupon.getMaxDiscountAmount() != null) {
                return Math.min(discount, coupon.getMaxDiscountAmount());
            }

            return discount;
        }
    }




}
