package com.codecool.apigateway.service;

import com.codecool.apigateway.model.CartResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingcartServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${shoppingcart.url}")
    private String baseUrl;

    public Long createNewCart(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
        CartResult result = restTemplate.postForObject(baseUrl + "/create", request, CartResult.class);
        return result.getId();
    }

    public  Map<String,Integer> getCart(String username){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
        Map<String,Integer> results = restTemplate.postForObject(baseUrl + "/get-cart", request,  Map.class);
        return results;
    }

    public  Map<String,Integer> addToCart(String title, String username){
        return makePostRequest(title, username, "/add");
    }

    public Map<String,Integer> removeFromCart(String title, String username) {
        return makePostRequest(title, username, "/remove");
    }

    public Map<String,Integer> increaseItemQuantity(String title, String username) {
        return makePutRequest(title, username, "/increase");
    }


    public Map<String,Integer> decreaseItemQuantity(String title, String username) {
        return makePutRequest(title, username, "/decrease");
    }


    private  Map<String,Integer> makePostRequest(String title, String username, String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("username", username);
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
        Map<String,Integer> results = restTemplate.postForObject(baseUrl + path, request, Map.class);
        return results;
    }

    private  Map<String,Integer> makePutRequest(String title, String username, String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("username", username);
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);
        ResponseEntity<Map> results = restTemplate.exchange(baseUrl + path, HttpMethod.PUT, request, Map.class);
        return results.getBody();
    }
}
