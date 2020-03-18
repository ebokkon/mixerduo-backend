package com.codecool.apigateway.service;

import com.codecool.apigateway.security.PasswordEncoderService;
import com.codecool.apigateway.model.Cart;
import com.codecool.apigateway.model.Client;
import com.codecool.apigateway.repository.CartRepository;
import com.codecool.apigateway.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DataProviderService {

    private CartRepository cartRepository;

    private ClientRepository clientRepository;

    private PasswordEncoderService pwService;


    public DataProviderService( CartRepository cartRepository, ClientRepository clientRepository, PasswordEncoderService passwordEncoderService) {
        this.cartRepository = cartRepository;
        this.clientRepository = clientRepository;
        this.pwService = passwordEncoderService;
    }

    public void buildClient() {
        Cart adminCart = new Cart();
        Client admin = Client.builder()
                .username("admin")
                .password(pwService.encodePassword("stars"))
                .roles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"))
                .cart(adminCart)
                .build();
        adminCart.setClient(admin);
        clientRepository.save(admin);

        Cart userCart = new Cart();
        userCart.addToCart("Advanced");
        Client user = Client.builder()
                .username("zuzu")
                .password(pwService.encodePassword("secret"))
                .firstname("John")
                .lastname("Smith")
                .email("john@smith.com")
                .roles(Arrays.asList("ROLE_USER"))
                .cart(userCart)
                .build();
        userCart.setClient(user);
        clientRepository.save(user);
    }



    public Map<String, Integer> getCart(String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        return allCartData.getCartMap();
    }

    public Map<String, Integer> addToCart (String name, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.addToCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> removeFromCart (String name, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.removeFromCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> increaseItemQuantity (String name, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.increaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> decreaseItemQuantity ( String name, String username){
        Cart allCartData = cartRepository.findCartByClientUsername(username);
        allCartData.decreaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public List<Client> listClientsAndCarts() {
        return clientRepository.findAll();
    }
}
