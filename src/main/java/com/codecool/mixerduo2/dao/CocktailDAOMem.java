package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
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

    public void addAll(List<DrinksResponse> data) {
        cocktailList.addAll(data);
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

    @Override
    public String toString() {
        return "CocktailDAOMem{" +
                "cocktailList=" + cocktailList +
                '}';
    }

}
