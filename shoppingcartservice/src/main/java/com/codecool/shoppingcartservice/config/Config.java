package com.codecool.shoppingcartservice.config;

import com.codecool.shoppingcartservice.model.Cart;
import com.codecool.shoppingcartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {
        Cart adminCart = new Cart();
        adminCart.setId(Long.valueOf(1));
        adminCart.setUsername("admin");
        Cart userCart = new Cart();
        userCart.setId(Long.valueOf(2));
        userCart.addToCart("Advanced");
        userCart.setUsername("zuzu");
        cartRepository.saveAll(Arrays.asList(adminCart, userCart));
    }
}
