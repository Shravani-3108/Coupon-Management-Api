package com.shravani.couponmanagement.coupon_management.service;

import com.shravani.couponmanagement.coupon_management.model.*;
import org.springframework.stereotype.Service;

@Service
public class CouponEligibilityService {

    // Total items in cart
    public int getTotalItems(Cart cart) {
        return cart.getItems().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    // Total cart value
    public double getTotalCartValue(Cart cart) {
        return cart.getCartValue();
    }

    // Check if coupon is eligible
    public boolean isEligible(Coupon coupon, UserContext user, Cart cart) {
        Eligibility e = coupon.getEligibility();

        if (e == null) return true; // If no eligibility rules, coupon is valid

        double cartValue = getTotalCartValue(cart);
        int totalItems = getTotalItems(cart);

        // USER-BASED CHECKS
        if (e.getAllowedUserTiers() != null &&
                !e.getAllowedUserTiers().contains(user.getUserTier())) {
            return false;
        }

        if (e.getMinLifetimeSpend() != null &&
                user.getLifetimeSpend() < e.getMinLifetimeSpend()) {
            return false;
        }

        if (e.getMinOrdersPlaced() != null &&
                user.getOrdersPlaced() < e.getMinOrdersPlaced()) {
            return false;
        }

        if (Boolean.TRUE.equals(e.getFirstOrderOnly()) &&
                user.getOrdersPlaced() > 0) {
            return false;
        }

        if (e.getAllowedCountries() != null &&
                !e.getAllowedCountries().contains(user.getCountry())) {
            return false;
        }

        // CART-BASED CHECKS
        if (e.getMinCartValue() != null && cartValue < e.getMinCartValue()) {
            return false;
        }

        if (e.getApplicableCategories() != null) {
            boolean match = cart.getItems().stream()
                    .anyMatch(i -> e.getApplicableCategories().contains(i.getCategory()));
            if (!match) return false;
        }

        if (e.getExcludedCategories() != null) {
            boolean banned = cart.getItems().stream()
                    .anyMatch(i -> e.getExcludedCategories().contains(i.getCategory()));
            if (banned) return false;
        }

        if (e.getMinItemsCount() != null && totalItems < e.getMinItemsCount()) {
            return false;
        }

        return true;
    }

    // Calculate discount of a single coupon
    public double calculateDiscount(Coupon coupon, double cartValue) {
        if (coupon.getDiscountType().equalsIgnoreCase("FLAT")) {
            return coupon.getDiscountValue();
        } else { // PERCENT
            double percentValue = (coupon.getDiscountValue() / 100.0) * cartValue;

            if (coupon.getMaxDiscountAmount() != null) {
                return Math.min(percentValue, coupon.getMaxDiscountAmount());
            }

            return percentValue;
        }
    }
}
