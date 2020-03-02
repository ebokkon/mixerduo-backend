package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.generated.DrinkItem;
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

    @GetMapping("/all-data")
    public List<DrinkItem> getData() {
        return dataProviderService.getAllData();
    }

    @GetMapping("/cocktails/{id}")
    public Optional<DrinkItem> getCocktailById(@PathVariable("id") int id){
        return dataProviderService.getCocktailById(id);
    }

    @GetMapping("/get-cart")
    public Map<String, Integer> getCart() {
        return dataProviderService.getCart();
    }

    @GetMapping("/add-to-cart/{coursename}")
    public Map<String, Integer> addToCart (@PathVariable("coursename") String name){
        return dataProviderService.addToCart(name);
    }

    @GetMapping("/remove-from-cart/{coursename}")
    public Map<String,Integer> removeFromCart (@PathVariable("coursename") String name){
        return dataProviderService.removeFromCart(name);
    }

    @GetMapping("/increase-in-cart/{coursename}")
    public Map<String,Integer> increaseItemQuantity (@PathVariable("coursename") String name){
        return dataProviderService.increaseItemQuantity(name);
    }

    @GetMapping("/decrease-in-cart/{coursename}")
    public Map<String,Integer> decreaseItemQuantity (@PathVariable("coursename") String name){
        return dataProviderService.decreaseItemQuantity(name);
    }

}
