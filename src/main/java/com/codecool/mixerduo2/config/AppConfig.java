package com.codecool.mixerduo2.config;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.service.CocktailAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig implements CommandLineRunner{

    @Autowired
    private CocktailAPIService cocktailAPIService;


    @Override
    public void run(String... args) throws Exception {
        cocktailAPIService.initCocktailDataMemory();
    }
}



