package com.shravani.couponmanagement.coupon_management.dto;

import com.shravani.couponmanagement.coupon_management.model.Coupon;

public class BestCouponResponse {
    private String couponCode;
    private double discountAmount;

    public BestCouponResponse(Coupon c, double discountAmount) {
        this.couponCode = c.getCode();
        this.discountAmount = discountAmount;
    }

    public BestCouponResponse(String couponCode, double discountAmount) {
        this.couponCode = couponCode;
        this.discountAmount = discountAmount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

}
