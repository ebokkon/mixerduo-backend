package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
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

    public void add(DrinksResponse drinksResponse) {
        cocktailList.add(drinksResponse);
    }

    @Override
    public String toString() {
        return "CocktailDAOMem{" +
                "cocktailList=" + cocktailList +
                '}';
    }
}
