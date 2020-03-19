package com.codecool.apigateway.controller;

import com.codecool.apigateway.model.CartsResults;
import com.codecool.apigateway.service.DataProviderService;
import com.codecool.apigateway.service.ShoppingcartServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping
public class CartController {

    @Autowired
    private ShoppingcartServiceCaller shoppingcartServiceCaller;

    @Autowired
    private DataProviderService dataProviderService;

    @PostMapping("/get-cart")
    public Map<String,Integer> getCart(@RequestParam("username") String username) {
        return shoppingcartServiceCaller.getCart(username);
    }

    @PostMapping("/add")
    public Map<String,Integer> addToCart (@RequestParam("title") String title, @RequestParam("username") String username){
        return shoppingcartServiceCaller.addToCart(title, username);
    }

    @PostMapping("/remove")
    public Map<String,Integer> removeFromCart (@RequestParam("title") String title, @RequestParam("username") String username){
        return shoppingcartServiceCaller.removeFromCart(title, username);
    }

    @PutMapping("/increase")
    public Map<String,Integer> increaseItemQuantity (@RequestParam("title") String title, @RequestParam("username") String username){
        return shoppingcartServiceCaller.increaseItemQuantity(title, username);
    }

    @PutMapping("/decrease")
    public Map<String,Integer> decreaseItemQuantity (@RequestParam("title") String title, @RequestParam("username") String username){
        return shoppingcartServiceCaller.decreaseItemQuantity(title, username);
    }

    @PostMapping("/users")
    public CartsResults[] usersCarts(){
        return shoppingcartServiceCaller.listClientsAndCarts();
    }
}
