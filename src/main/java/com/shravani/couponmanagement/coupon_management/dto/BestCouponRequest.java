package com.shravani.couponmanagement.coupon_management.dto;
import com.shravani.couponmanagement.coupon_management.model.Cart;
import com.shravani.couponmanagement.coupon_management.model.UserContext;


public class BestCouponRequest {
    private UserContext user;
    private Cart cart;

    public UserContext getUser() {
        return user;
    }

    public void setUser(UserContext user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
