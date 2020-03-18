package com.codecool.mixerduo2.service;

import com.codecool.mixerduo2.model.CocktailItem;
import com.codecool.mixerduo2.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocktailProviderService {

    @Autowired
    private CocktailRepository cocktailRepository;

    public List<CocktailItem> getAllData(){
        return cocktailRepository.findAll();
    }

    public Optional<CocktailItem> getCocktailById( int id){
        return cocktailRepository.findById(String.valueOf(id));
    }
}
