package com.codecool.mixerduo2;

import com.codecool.mixerduo2.service.CocktailAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;import javax.annotation.PostConstruct;

@SpringBootApplication
public class MixerduoBackendApp {


    @Autowired
    private CocktailAPIService cocktailAPIService;


    public static void main(String[] args) {
        SpringApplication.run(MixerduoBackendApp.class, args);
    }

    @PostConstruct
    public void init() throws Exception {
        cocktailAPIService.initDataMemory();
    }
}
