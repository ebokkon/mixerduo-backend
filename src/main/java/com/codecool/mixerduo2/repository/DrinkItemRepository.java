package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkItemRepository extends JpaRepository<DrinkItem, String> {
}
