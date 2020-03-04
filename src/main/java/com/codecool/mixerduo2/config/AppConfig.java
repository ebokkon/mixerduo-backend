package com.codecool.mixerduo2.config;

import com.codecool.mixerduo2.service.CocktailAPIService;
import com.codecool.mixerduo2.service.DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig implements CommandLineRunner{

    @Autowired
    private CocktailAPIService cocktailAPIService;

    @Autowired
    private DataProviderService dataProviderService;

    @Override
    public void run(String... args) throws Exception {
        cocktailAPIService.initCocktailDataMemory();
        dataProviderService.buildClient();
    }
}



