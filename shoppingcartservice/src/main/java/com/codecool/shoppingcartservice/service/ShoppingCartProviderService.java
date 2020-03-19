package com.codecool.shoppingcartservice.service;


import com.codecool.shoppingcartservice.model.Cart;
import com.codecool.shoppingcartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ShoppingCartProviderService {

    @Autowired
    private CartRepository cartRepository;

    public Cart createCart(String username) {
        Cart cart = new Cart();
        cart.setUsername(username);
        cartRepository.save(cart);
        return cart;
    }

    public Map<String, Integer> getCart(String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        return allCartData.getCartMap();
    }

    public Map<String, Integer> addToCart (String title, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.addToCart(title);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> removeFromCart (String title, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.removeFromCart(title);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> increaseItemQuantity (String title, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.increaseQuantity(title);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> decreaseItemQuantity ( String title, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.decreaseQuantity(title);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }


}
