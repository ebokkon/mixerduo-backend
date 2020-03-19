package com.codecool.shoppingcartservice.controller;

import com.codecool.shoppingcartservice.model.Cart;
import com.codecool.shoppingcartservice.model.CartRequest;
import com.codecool.shoppingcartservice.model.UserCart;
import com.codecool.shoppingcartservice.service.ShoppingCartProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class ShoppingCartController {

    @Autowired
    private ShoppingCartProviderService shoppingCartProviderService;

    @PostMapping("/create")
    public Cart createCart(@RequestBody UserCart user){
        return shoppingCartProviderService.createCart(user.getUsername());
    }

    @PostMapping("/get-cart")
    public Map<String, Integer> getCart(@RequestBody CartRequest cartRequest) {
        return shoppingCartProviderService.getCart(cartRequest.getUsername());
    }

    @PostMapping("/add")
    public Map<String, Integer> addToCart (@RequestBody CartRequest cartRequest){
        return shoppingCartProviderService.addToCart(cartRequest.getTitle(), cartRequest.getUsername());
    }

    @PostMapping("/remove")
    public Map<String,Integer> removeFromCart (@RequestBody CartRequest cartRequest){
        return shoppingCartProviderService.removeFromCart(cartRequest.getTitle(), cartRequest.getUsername());
    }

    @PutMapping("/increase")
    public Map<String,Integer> increaseItemQuantity (@RequestBody CartRequest cartRequest){
        return shoppingCartProviderService.increaseItemQuantity(cartRequest.getTitle(), cartRequest.getUsername());
    }

    @PutMapping("/decrease")
    public Map<String,Integer> decreaseItemQuantity (@RequestBody CartRequest cartRequest){
        return shoppingCartProviderService.decreaseItemQuantity(cartRequest.getTitle(), cartRequest.getUsername());
    }


}
