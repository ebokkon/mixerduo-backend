package com.codecool.shoppingcartservice.repository;
import com.codecool.shoppingcartservice.model.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CartRespositoryTest {


    @Autowired
    private CartRepository cartRespository;


    @Test
    public void testSaveOneCart(){
        Cart cart = Cart.builder().username("Esszter").build();
        cartRespository.saveAndFlush(cart);
        List<Cart> carts = cartRespository.findAll();
        assertThat(carts).hasSize(1);
    }

    @Test
    public void findCartByClient() {
        Cart cart = Cart.builder().username("John").build();
        cartRespository.saveAndFlush(cart);

        Cart cartByClient = cartRespository.findCartByClientUsername("John");
        Assert.assertEquals(cart, cartByClient);
    }


    @Test
    public void testCartHasCorrectItems(){
        Cart cart = Cart.builder().username("Mr Test").cartMap(new HashMap<>()).build();
        Map<String, Integer> expectedMap = Map.of("Advanced", 1);
        cartRespository.save(cart);

        cart.addToCart("Advanced");
        Optional<Cart> cartFromRepo = cartRespository.findById(cart.getId());
        Map<String, Integer> cartMapFromRepo = cartFromRepo.get().getCartMap();
        Assert.assertEquals(expectedMap, cartMapFromRepo);
    }

}