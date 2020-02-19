package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface CartRespository extends JpaRepository<Cart, Long> {

    @Query("SELECT c from Client cl join Cart c on cl.cart = c.id where cl.id = :client_id ")
    Cart findCartByClient(@Param("client_id") Long client_id);

}