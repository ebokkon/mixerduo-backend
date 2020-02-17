package com.codecool.mixerduo2.model;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
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
        if (cartMap.containsKey(name)){
            cartMap.put(name, cartMap.get(name)+1);
        }
        cartMap.putIfAbsent(name, 1);
    }

    public void removeFromCart(String name) {
        cartMap.remove(name);
    }

    public void increaseQuantity(String name) {
        addToCart(name);
    }

    public void decreaseQuantity(String name) {
        if (cartMap.containsKey(name) && cartMap.get(name) == 1) cartMap.remove(name);
        if (cartMap.containsKey(name) && cartMap.get(name) > 1) {
            cartMap.put(name, cartMap.get(name)-1);
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
