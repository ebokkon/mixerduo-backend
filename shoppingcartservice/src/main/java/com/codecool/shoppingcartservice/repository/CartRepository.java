package com.codecool.shoppingcartservice.repository;


import com.codecool.shoppingcartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c from Cart c where c.username = :username ")
    Cart findCartByClientUsername(@Param("username") String username);
}