package com.codecool.mixerduo2.config;

import com.codecool.mixerduo2.service.CocktailAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig implements CommandLineRunner{

    @Autowired
    private CocktailAPIService cocktailAPIService;

    @Override
    public void run(String... args) throws Exception {
        cocktailAPIService.initCocktailDataMemory();
    }
}



