package com.codecool.mixerduo2.controller;

import com.codecool.mixerduo2.model.CocktailItem;
import com.codecool.mixerduo2.service.CocktailProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="${main.route}")
@RequestMapping
public class CocktailController {

    @Autowired
    private CocktailProviderService cocktailProviderService;

    @GetMapping("/cocktails")
    public List<CocktailItem> getData() {
        return cocktailProviderService.getAllData();
    }

    @PostMapping("/cocktails/{id}")
    public Optional<CocktailItem> getCocktailById(@PathVariable("id") int id){
        return cocktailProviderService.getCocktailById(id);
    }


}
