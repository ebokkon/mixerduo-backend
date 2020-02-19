package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface CartRespository extends JpaRepository<Cart, Long> {

    @Query("select cart_map_key, cart_map from cart c join cart_cart_map on c.id = cart_cart_map.cart_id where client_id = :client ")
    List<Map<String, Integer>> findCartByClientId(@Param("client") Long client);
//    List<Map<String, Integer>> findCartByClientId(@Param("client") Long client);

}