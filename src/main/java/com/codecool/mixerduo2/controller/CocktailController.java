package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.service.CocktailAPIService;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping
public class CocktailController {

    @Autowired
    private CocktailAPIService cocktailAPIService;

    @Autowired
    private CocktailDAOMem cocktailDAOMem;

    @Autowired
    private Cart cart;

    @Autowired
    private HttpSession session;

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/")
    public String getData() throws JSONException {
        session.setAttribute(cart.getId(), cart);
        Cart currentCart = (Cart) session.getAttribute(cart.getId());

        System.out.println(currentCart.toString());
        cocktailAPIService.initDataMemory();

        Gson cocktailsGson = new Gson();

        List<DrinkItem> allCocktails = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (cocktailDAOMem.getCocktailList() != null && cocktailDAOMem.getCocktailList().get(i).getDrinks() != null) {
                allCocktails.addAll(cocktailDAOMem.getCocktailList().get(i).getDrinks());
            }
        }
        String result = cocktailsGson.toJson(allCocktails);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cocktails/{id}")
    public String getCocktailById(@PathVariable("id") int id){
        DrinkItem drink = cocktailDAOMem.getCocktailById(id);
        Gson gsonDrink = new Gson();
        String result = gsonDrink.toJson(drink);
        return result;
    }


    @CrossOrigin(origins ="http://localhost:3000" )
    @GetMapping("/get-cart")
    public String getCart() {
        Cart currentCart = (Cart) session.getAttribute(cart.getId());
        Gson gsonDrink = new Gson();
        String result = gsonDrink.toJson(currentCart);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/add-to-cart/{coursename}")
    public String addToCart (@PathVariable("coursename") String name){
        Cart currentCart = (Cart) session.getAttribute(cart.getId());
        Cart updatedCart = currentCart.addToCart(name);
        Gson gsonDrink = new Gson();
        String result = gsonDrink.toJson(updatedCart);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/remove-from-cart/{name}")
    public String removeFromCart (@PathVariable("name") String name){
        return "";
    }
}
