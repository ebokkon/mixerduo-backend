package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRespository extends JpaRepository<Cart, Long> {
}
