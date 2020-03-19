package com.codecool.apigateway.service;

import com.codecool.apigateway.model.CocktailResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@Service
public class CocktailServiceCaller {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${mixerduo.url}")
    private String baseUrl;

    public List<CocktailResult> getAllData() {
        CocktailResult[] results = restTemplate.getForObject(baseUrl + "/cocktails", CocktailResult[].class);
        return Arrays.asList(results);
    }

    public CocktailResult getCocktailById(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        CocktailResult cocktailResult = new CocktailResult();
        HttpEntity<CocktailResult> request = new HttpEntity<CocktailResult>(cocktailResult, headers);
        CocktailResult result = restTemplate.postForObject(baseUrl + "/cocktails/" + id, request,  CocktailResult.class);
        return result;
    }
}
