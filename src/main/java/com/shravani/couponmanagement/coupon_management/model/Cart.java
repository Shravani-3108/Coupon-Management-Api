package com.shravani.couponmanagement.coupon_management.model;
import java.util.List;
public class Cart {
    private List<CartItem> items;

    public Cart() {}

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getCartValue() {
        return items.stream()
                .mapToDouble(item -> item.getUnitPrice() * item.getQuantity())
                .sum();
    }

}
