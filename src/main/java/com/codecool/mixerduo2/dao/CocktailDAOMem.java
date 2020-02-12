package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CocktailDAOMem {

    private List<DrinksResponse> cocktailList = new ArrayList<>();

    private List<DrinkItem> cocktailItems = new ArrayList<>();

    public List<DrinksResponse> getCocktailList() {
        return cocktailList;
    }

    public void add(DrinksResponse drinksResponse) {
            cocktailList.add(drinksResponse);
    }

    public List<DrinkItem> getCocktailItems() {
        return cocktailItems;
    }

    public void fillcocktailItemsFiltered() {
        for (int i = 0; i < 26; i++) {
            if (cocktailList != null && cocktailList.get(i).getDrinks() != null) {
                cocktailItems.addAll(cocktailList.get(i).getDrinks());
            }
        }
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
