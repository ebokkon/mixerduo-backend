package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.service.CocktailAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="${main.route}") // TODO move this to config
@RequestMapping
public class CocktailController {

    @Autowired
    private CocktailAPIService cocktailAPIService;

    @Autowired
    private CocktailDAOMem cocktailDAOMem;

    @Autowired
    private Cart cart;

    @GetMapping("/") // TODO name every route
    public List<DrinkItem> getData() throws Exception {

        cocktailAPIService.initDataMemory(); // TODO init data once
        List<DrinkItem> allCocktails = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cocktailDAOMem.getCocktailList() != null && cocktailDAOMem.getCocktailList().get(i).getDrinks() != null) {
                allCocktails.addAll(cocktailDAOMem.getCocktailList().get(i).getDrinks());
            }
        }
        return allCocktails;
    }

    @GetMapping("/cocktails/{id}")
    public DrinkItem getCocktailById(@PathVariable("id") int id){
        DrinkItem drink = cocktailDAOMem.getCocktailById(id);
        return drink;
    }

    @GetMapping("/get-cart")
    public Map<String,Integer> getCart() { // TODO use Jackson, its supplied by Spring
        return cart.getCartMap();
    }

    @GetMapping("/add-to-cart/{coursename}")
    public Map<String,Integer> addToCart (@PathVariable("coursename") String name){
        cart.addToCart(name);
        return cart.getCartMap();
    }

    @GetMapping("/remove-from-cart/{coursename}")
    public Map<String,Integer> removeFromCart (@PathVariable("coursename") String name){
        cart.removeFromCart(name);
        return cart.getCartMap();
    }

    @GetMapping("/increase-in-cart/{coursename}")
    public Map<String,Integer> increaseItemQuantity (@PathVariable("coursename") String name){
        cart.increaseQuantity(name);
        return cart.getCartMap();
    }

    @GetMapping("/decrease-in-cart/{coursename}")
    public Map<String,Integer> decreaseItemQuantity (@PathVariable("coursename") String name){
        cart.decreaseQuantity(name);
        return cart.getCartMap();
    }

}
