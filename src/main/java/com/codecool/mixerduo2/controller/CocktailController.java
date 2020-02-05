package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import com.codecool.mixerduo2.service.CocktailAPIService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class CocktailController {

    @Autowired
    private CocktailAPIService cocktailAPIService;

    @Autowired
    private CocktailDAOMem cocktailDAOMem;

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/")
    public String getData() throws JSONException {
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
    public String getCart(){
        return "";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/add-to-cart/{name}")
    public String addToCart (@PathVariable("name") String name){
        return "";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/remove-from-cart/{name}")
    public String removeFromCart (@PathVariable("name") String name){
        return "";
    }
}
