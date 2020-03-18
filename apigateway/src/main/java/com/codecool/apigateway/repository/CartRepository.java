package com.codecool.apigateway.repository;

import com.codecool.apigateway.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c from Client cl join Cart c on cl.cart.id = c.id where cl.id = :client_id ")
    Cart findCartByClient(@Param("client_id") Long client_id);

    @Query("SELECT c from Client cl join Cart c on cl.cart.id = c.id where cl.username = :username ")
    Cart findCartByClientUsername(@Param("username") String username);
}