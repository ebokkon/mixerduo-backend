package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
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

    @Autowired
    private Cart cart;

    @Autowired
    private Client client;

    @GetMapping("/all-data")
    public List<DrinkItem> getData() {
        buildClient();
        cartRepository.saveAndFlush(cart);
        return drinkItemRepository.findAll();
    }

    private void buildClient() {
        client = Client.builder()
                .name("Eduardo Palmeras")
                .password("#&fsk$gßs&s#")
                .cart(cart)
                .build();
        cart.setClient(client);
        clientRepository.save(client);
    }

    @GetMapping("/cocktails/{id}")
    public Optional<DrinkItem> getCocktailById(@PathVariable("id") int id){
        Optional<DrinkItem> drink = drinkItemRepository.findById(String.valueOf(id));
        return drink;
    }

    @GetMapping("/get-cart")
    public List<Map<String, Integer>> getCart() {
        List<Map<String, Integer>> cartByClientId = cartRepository.findCartByClientId(client.getId());
        System.out.println(cartByClientId.toString());
        return cartByClientId;
    }

    @GetMapping("/add-to-cart/{coursename}")
    public List<Map<String, Integer>> addToCart (@PathVariable("coursename") String name){
        cart.addToCart(name);
        cartRepository.saveAndFlush(cart);
        return cartRepository.findCartByClientId(client.getId());

    }

    @GetMapping("/remove-from-cart/{coursename}")
    public Map<String,Integer> removeFromCart (@PathVariable("coursename") String name){
//        cart.removeFromCart(name);
//        cartRepository.saveAndFlush(cart);
//        return cartRepository.getCartMap();
        return null;
    }

    @GetMapping("/increase-in-cart/{coursename}")
    public Map<String,Integer> increaseItemQuantity (@PathVariable("coursename") String name){
//        cart.increaseQuantity(name);
//        cartRepository.saveAndFlush(cart);
//        return cartRepository.getCartMap();
        return null;
    }

    @GetMapping("/decrease-in-cart/{coursename}")
    public Map<String,Integer> decreaseItemQuantity (@PathVariable("coursename") String name){
        cart.decreaseQuantity(name);
        cartRepository.saveAndFlush(cart);
        return cart.getCartMap();
    }

}
