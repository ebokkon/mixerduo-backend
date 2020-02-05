package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CocktailDAOMem {

    private List<DrinksResponse> cocktailList = new ArrayList<>();

    public List<DrinksResponse> getCocktailList() {
        return cocktailList;
    }

    public void setCocktailList(List<DrinksResponse> cocktailList) {
        this.cocktailList = cocktailList;
    }

    public void add(DrinksResponse drinksResponse) {
        cocktailList.add(drinksResponse);
    }

    @Override
    public String toString() {
        return "CocktailDAOMem{" +
                "cocktailList=" + cocktailList +
                '}';
    }

    public DrinkItem getCocktailById(int id) {
        for (DrinksResponse drinks:cocktailList) {
            for (DrinkItem drink: drinks.getDrinks()){
                if (Integer.parseInt(drink.getIdDrink()) == id){
                    return drink;
                }
            }
        }
        return null;
    }
}
