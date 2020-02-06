package com.codecool.mixerduo2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
public class Cart implements Serializable {

    private String id = UUID.randomUUID().toString();
    private Map<String, Integer> cartMap = new HashMap<>();

    public String getId() {
        return id;
    }

    public Map<String, Integer> getCartMap() {
        return cartMap;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cartMap = cart;
    }

    public void addToCart(String name) {
        for (Map.Entry<String,Integer> entry : cartMap.entrySet()) {
            if (entry.getKey().equals(name)){
                cartMap.put(entry.getKey(), cartMap.get(entry.getKey())+1);
            }
        }
        cartMap.putIfAbsent(name, 1);
    }

    public void removeFromCart(String name) {
        for (Map.Entry<String,Integer> entry : cartMap.entrySet()) {
            if (entry.getKey().equals(name)) {
                cartMap.remove(entry.getKey());
            }
        }
    }

    public void increaseQuantity(String name) {
        addToCart(name);
    }

    public void decreaseQuantity(String name) {
        for (Map.Entry<String,Integer> entry : cartMap.entrySet()) {
            if (entry.getKey().equals(name) && cartMap.get(entry.getKey()) != 1) {
                cartMap.put(entry.getKey(), cartMap.get(entry.getKey())-1);
            }
            if (entry.getKey().equals(name)){
                cartMap.remove(entry.getKey());
            }
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", cart=" + cartMap +
                '}';
    }
}
