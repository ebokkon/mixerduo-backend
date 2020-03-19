package com.codecool.apigateway.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocktailResult {

    private String idDrink;

    private String strDrink;

    private String strCategory;

    private String strAlcoholic;

    private String strIBA;

    private String strGlass;

    private String strDrinkThumb;

    private String strInstructions;

    private List<String> ingredients;

    private List<String> measurements;

}
