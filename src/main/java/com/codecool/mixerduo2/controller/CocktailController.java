package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.Client;
import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.repository.CartRespository;
import com.codecool.mixerduo2.repository.ClientRepository;
import com.codecool.mixerduo2.repository.DrinkItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="${main.route}")
@RequestMapping
public class CocktailController {

    @Autowired
    private DrinkItemRepository drinkItemRepository;

    @Autowired
    private CartRespository cartRepository;

    @Autowired
    private ClientRepository clientRepository;

    private Cart cart;
    private Client client;

    @GetMapping("/all-data")
    public List<DrinkItem> getData() {
        cart = new Cart();
        cartRepository.save(cart);
        buildClient();
        return drinkItemRepository.findAll();
    }

    private void buildClient() {
        client = Client.builder()
                .name("Eduardo Palmeras")
                .password("mypassword")
                .cart(cart)
                .build();
        clientRepository.save(client);
    }

    @GetMapping("/cocktails/{id}")
    public Optional<DrinkItem> getCocktailById(@PathVariable("id") int id){
        Optional<DrinkItem> drink = drinkItemRepository.findById(String.valueOf(id));
        return drink;
    }

    @GetMapping("/get-cart")
    public Map<String, Integer> getCart() {
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        return allCartData.getCartMap();
    }

    @GetMapping("/add-to-cart/{coursename}")
    public Map<String, Integer> addToCart (@PathVariable("coursename") String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.addToCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();

    }

    @GetMapping("/remove-from-cart/{coursename}")
    public Map<String,Integer> removeFromCart (@PathVariable("coursename") String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.removeFromCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    @GetMapping("/increase-in-cart/{coursename}")
    public Map<String,Integer> increaseItemQuantity (@PathVariable("coursename") String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.increaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    @GetMapping("/decrease-in-cart/{coursename}")
    public Map<String,Integer> decreaseItemQuantity (@PathVariable("coursename") String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.decreaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

}
