package com.shravani.couponmanagement.coupon_management.dto;
import com.shravani.couponmanagement.coupon_management.model.Coupon;
import com.shravani.couponmanagement.coupon_management.model.Eligibility;
import java.time.LocalDate;


public class CreateCouponRequest {
    public CreateCouponRequest() {}
    private String code;
    private String description;
    private String discountType;   // FLAT or PERCENT
    private double discountValue;
    private Double maxDiscountAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer usageLimitPerUser;
    private Eligibility eligibility;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Double maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getUsageLimitPerUser() {
        return usageLimitPerUser;
    }

    public void setUsageLimitPerUser(Integer usageLimitPerUser) {
        this.usageLimitPerUser = usageLimitPerUser;
    }

    public Eligibility getEligibility() {
        return eligibility;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }

    public Coupon toCoupon() {
        Coupon c = new Coupon();
        c.setCode(code);
        c.setDescription(description);
        c.setDiscountType(discountType);
        c.setDiscountValue(discountValue);
        c.setMaxDiscountAmount(maxDiscountAmount);
        c.setStartDate(startDate);
        c.setEndDate(endDate);
        c.setUsageLimitPerUser(usageLimitPerUser);
        c.setEligibility(eligibility);
        return c;

    }

}
