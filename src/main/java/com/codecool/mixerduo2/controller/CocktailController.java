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

    @PostMapping("/get-cart")
    public Map<String, Integer> getCart(@RequestParam("username") String username) {
        return dataProviderService.getCart(username);
    }

    @PostMapping("/add")
    public Map<String, Integer> addToCart (@RequestParam("title") String title, @RequestParam("username") String username){
        return dataProviderService.addToCart(title, username);
    }

    @PostMapping("/remove")
    public Map<String,Integer> removeFromCart (@RequestParam("title") String title, @RequestParam("username") String username){
        return dataProviderService.removeFromCart(title, username);
    }

    @PutMapping("/increase")
    public Map<String,Integer> increaseItemQuantity (@RequestParam("title") String title, @RequestParam("username") String username){
        return dataProviderService.increaseItemQuantity(title, username);
    }

    @PutMapping("/decrease")
    public Map<String,Integer> decreaseItemQuantity (@RequestParam("title") String title, @RequestParam("username") String username){
        return dataProviderService.decreaseItemQuantity(title, username);
    }

    @PostMapping("/users")
    public List<Client> usersCarts(){
        return dataProviderService.listClientsAndCarts();
    }
}
