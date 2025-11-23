package com.shravani.couponmanagement.coupon_management.controller;

import com.shravani.couponmanagement.coupon_management.model.Coupon;
import com.shravani.couponmanagement.coupon_management.dto.*;
import com.shravani.couponmanagement.coupon_management.service.CouponService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService service;

    public CouponController(CouponService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Coupon createCoupon(@RequestBody CreateCouponRequest request) {
        return service.createCoupon(request);
    }

    @PostMapping("/best")
    public BestCouponResponse getBestCoupon(@RequestBody BestCouponRequest request) {
        return service.findBestCoupon(request);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleDuplicate(IllegalArgumentException ex) {
        return ex.getMessage();
    }

}

