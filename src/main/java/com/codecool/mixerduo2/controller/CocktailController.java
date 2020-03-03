package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.Client;
import com.codecool.mixerduo2.model.CocktailItem;
import com.codecool.mixerduo2.service.DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="${main.route}")
@RequestMapping
public class CocktailController {

    @Autowired
    private DataProviderService dataProviderService;

    @GetMapping("/cocktails")
    public List<CocktailItem> getData() {
        return dataProviderService.getAllData();
    }

    @PostMapping("/cocktails/{id}")
    public Optional<CocktailItem> getCocktailById(@PathVariable("id") int id){
        return dataProviderService.getCocktailById(id);
    }

    @GetMapping("/get-cart")
    public Map<String, Integer> getCart() {
        return dataProviderService.getCart();
    }

    @PostMapping("/add/{coursename}")
    public Map<String, Integer> addToCart (@PathVariable("coursename") String name){
        return dataProviderService.addToCart(name);
    }

    @DeleteMapping("/remove/{coursename}")
    public Map<String,Integer> removeFromCart (@PathVariable("coursename") String name){
        return dataProviderService.removeFromCart(name);
    }

    @PutMapping("/increase/{coursename}")
    public Map<String,Integer> increaseItemQuantity (@PathVariable("coursename") String name){
        return dataProviderService.increaseItemQuantity(name);
    }

    @PutMapping("/decrease/{coursename}")
    public Map<String,Integer> decreaseItemQuantity (@PathVariable("coursename") String name){
        return dataProviderService.decreaseItemQuantity(name);
    }

    @PostMapping("/users")
    public List<Client> usersCarts(){
        return dataProviderService.listClientsAndCarts();
    }
}
