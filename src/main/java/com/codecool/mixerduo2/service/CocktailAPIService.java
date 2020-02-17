package com.codecool.mixerduo2.service;

import com.codecool.mixerduo2.dao.CocktailDAOMem;
import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import com.codecool.mixerduo2.repository.DrinkItemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CocktailAPIService {

    @Autowired
    private DrinkItemRepository drinkItemRepository;

    @Autowired
    private CocktailDAOMem cocktailDAOMem;

    @Value("${cocktails.url}")
    private String cocktailsUrl;

    private final List<String> abc = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

    public void initDataMemory () throws Exception {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        List<CompletableFuture<String>> asyncAPICallResult = sendGET(httpClient);
        fillCocktailDAOMem(asyncAPICallResult);
    }

    private void fillCocktailDAOMem(List<CompletableFuture<String>> asyncAPICallResult) throws InterruptedException, java.util.concurrent.ExecutionException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        for (CompletableFuture<String> item : asyncAPICallResult) {
            if (item != null && item.get() != null) {
                JsonNode tempJNode = mapper.readTree(item.get());
                DrinksResponse drinksResponse = mapper.treeToValue(tempJNode, DrinksResponse.class);
                if (drinksResponse.getDrinks() != null) {
                    for (DrinkItem drinkItem : drinksResponse.getDrinks()) {
                        drinkItemRepository.save(drinkItem);
                    }
                }
            }
        }
    }

    private List<CompletableFuture<String>> sendGET(HttpClient httpClient) {
        List<String> targets = abc.stream().map(letter -> cocktailsUrl + letter).collect(Collectors.toList());
        List<CompletableFuture<String>> result = targets.stream()
                .map(url -> httpClient.sendAsync(
                        HttpRequest.newBuilder(URI.create(url))
                                .GET()
                                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                                .build(),
                        HttpResponse.BodyHandlers.ofString())
                        .thenApply(response -> response.body()))
                .collect(Collectors.toList());
        return result;
    }

}
