package com.codecool.apigateway.controller;


import com.codecool.apigateway.model.CocktailResult;
import com.codecool.apigateway.service.CocktailServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="${frontend.url}")
@RequestMapping
public class CocktailController {

    @Autowired
    private CocktailServiceCaller cocktailServiceCaller;

    @GetMapping("/cocktails")
    public List<CocktailResult> getData() {
        return cocktailServiceCaller.getAllData();
    }

    @PostMapping("/cocktails/{id}")
    public CocktailResult getCocktailById(@PathVariable("id") String id){
        return cocktailServiceCaller.getCocktailById(id);
    }
}
