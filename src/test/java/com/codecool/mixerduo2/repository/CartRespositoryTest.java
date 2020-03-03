package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.Client;
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
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CartRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CartRespository cartRespository;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveOneCart(){
        Cart cart = Cart.builder().build();
        Client client = Client.builder().cart(cart).username("Eszter").password("password").build();

        cartRespository.saveAndFlush(cart);
        List<Cart> carts = cartRespository.findAll();
        assertThat(carts).hasSize(1);
    }

    @Test
    public void findCartByClient() {
        Cart cart = Cart.builder().build();
        Client client = Client.builder().cart(cart).username("John").password("doe").build();
        clientRepository.save(client);
        cartRespository.saveAndFlush(cart);

        Cart cartByClient = cartRespository.findCartByClient(client.getId());
        assertEquals(cart, cartByClient);
    }

    @Test
    public void testCartIsDeletedWithClient(){
        Client client = Client.builder().username("Balazs").password("Farago").build();
        Cart cart = Cart.builder().client(client).build();
        clientRepository.save(client);
        cartRespository.save(cart);
        entityManager.clear();

        clientRepository.deleteAll();
        assertThat(cartRespository.findAll()).hasSize(0);
    }

    @Test
    public void testCartHasCorrectItems(){
        Cart cart = Cart.builder().cartMap(new HashMap<>()).build();
        Client client = Client.builder().cart(cart).username("Mr Test").password("test1234").build();
        Map<String, Integer> expectedMap = Map.of("Advanced", 1);
        clientRepository.save(client);
        cartRespository.save(cart);

        cart.addToCart("Advanced");
        Optional<Cart> cartFromRepo = cartRespository.findById(cart.getId());
        Map<String, Integer> cartMapFromRepo = cartFromRepo.get().getCartMap();
        assertEquals(expectedMap, cartMapFromRepo);
    }

}