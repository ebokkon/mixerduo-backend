package com.codecool.mixerduo2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class Cart {

    private String id = UUID.randomUUID().toString();
    private Map<Course, Integer> cart = new LinkedHashMap<>();

    public String getId() {
        return id;
    }

    public Map<Course, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Course, Integer> cart) {
        this.cart = cart;
    }

    public Cart addToCart(String name) {
        for (Map.Entry<Course,Integer> entry : cart.entrySet()) {
            if (entry.getKey().getName().equals(name)){

            } else {

            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", cart=" + cart +
                '}';
    }
}
