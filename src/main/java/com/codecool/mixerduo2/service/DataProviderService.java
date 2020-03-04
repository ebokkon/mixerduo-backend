package com.codecool.mixerduo2.service;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.Client;
import com.codecool.mixerduo2.model.CocktailItem;
import com.codecool.mixerduo2.repository.CartRespository;
import com.codecool.mixerduo2.repository.ClientRepository;
import com.codecool.mixerduo2.repository.CocktailRepository;
import com.codecool.mixerduo2.security.PasswordEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DataProviderService {

    private CocktailRepository cocktailRepository;

    private CartRespository cartRepository;

    private ClientRepository clientRepository;

    private PasswordEncoderService pwService;

    public DataProviderService(CocktailRepository cocktailRepository, CartRespository cartRepository, ClientRepository clientRepository, PasswordEncoderService passwordEncoderService) {
        this.cocktailRepository = cocktailRepository;
        this.cartRepository = cartRepository;
        this.clientRepository = clientRepository;
        this.pwService = passwordEncoderService;

    }

    private Cart cart;
    private Client client;

    private void buildClient() {
        client = Client.builder()
                .username("admin")
                .password(pwService.encodePassword("stars"))
                .cart(cart)
                .build();
        clientRepository.save(client);
    }

    public List<CocktailItem> getAllData(){
        cart = new Cart();
        cartRepository.save(cart);
        buildClient();
        return cocktailRepository.findAll();
    }

    public Optional<CocktailItem> getCocktailById( int id){
        return cocktailRepository.findById(String.valueOf(id));
    }

    public Map<String, Integer> getCart(){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        return allCartData.getCartMap();
    }

    public Map<String, Integer> addToCart (String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.addToCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> removeFromCart (String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.removeFromCart(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> increaseItemQuantity (String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.increaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }

    public Map<String,Integer> decreaseItemQuantity ( String name){
        Cart allCartData = cartRepository.findCartByClient(client.getId());
        allCartData.decreaseQuantity(name);
        cartRepository.save(allCartData);
        return allCartData.getCartMap();
    }
    
    //?? will it provide the carts as well?
    public List<Client> listClientsAndCarts() {
        return clientRepository.findAll();
    }
}
