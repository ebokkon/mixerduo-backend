package com.codecool.mixerduo2.service;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CocktailAPIService {

    @Autowired
    private CocktailDAOMem cocktailDAOMem;

    @Value("${cocktails.url}")
    private String cocktailsUrl;

    private final List<String> abc = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

    private void fetchData(String letter){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DrinksResponse> responseEntity = restTemplate.exchange(cocktailsUrl+letter, HttpMethod.GET, null, DrinksResponse.class);
//        System.out.println(responseEntity);
        cocktailDAOMem.add(responseEntity.getBody());
    }

    public void initDataMemory (){
        for (String letter : abc) {
            fetchData(letter);
        }
    }

//    public List<CompletableFuture<DrinksResponse>> sendGET(HttpClient httpClient) throws Exception {
//
//        List<String> targets = abc.stream().map(letter -> "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=" + letter).collect(Collectors.toList());
//
//        List<CompletableFuture<String>> result = targets.stream()
//                .map(url -> httpClient.sendAsync(
//                        HttpRequest.newBuilder(URI.create(url))
//                                .GET()
//                                .setHeader("User-Agent", "Java 11 HttpClient Bot")
//                                .build(),
//                        HttpResponse.BodyHandlers.ofString())
//                        .thenApply(response -> response.body()))
//                .collect(Collectors.toList());
//
//        for (CompletableFuture<String> future : result) {
//            System.out.println(future.get());
//        }
//
//    }

}
