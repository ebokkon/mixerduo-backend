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

    @PostMapping("/add")
    public Map<String, Integer> addToCart (@RequestParam("title") String name){
        System.out.println(name);
        return dataProviderService.addToCart(name);
    }

    @DeleteMapping("/remove")
    public Map<String,Integer> removeFromCart (@RequestBody String name){
        return dataProviderService.removeFromCart(name);
    }

    @PutMapping("/increase")
    public Map<String,Integer> increaseItemQuantity (@RequestParam("title") String name){
        return dataProviderService.increaseItemQuantity(name);
    }

    @PutMapping("/decrease")
    public Map<String,Integer> decreaseItemQuantity (@RequestParam("title") String name){
        return dataProviderService.decreaseItemQuantity(name);
    }

    @PostMapping("/users")
    public List<Client> usersCarts(){
        return dataProviderService.listClientsAndCarts();
    }
}
