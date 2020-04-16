package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.CocktailItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<CocktailItem, String> {
}
