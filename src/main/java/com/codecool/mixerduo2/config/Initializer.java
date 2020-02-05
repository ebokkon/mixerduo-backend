package com.codecool.mixerduo2.config;

import com.codecool.mixerduo2.service.CocktailAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    @Autowired
    private CocktailAPIService cocktailAPIService;

    public void initData(){
        cocktailAPIService.initDataMemory();

    }
}
