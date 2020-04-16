package com.codecool.mixerduo2.model;

import lombok.*;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CocktailItem {

    @Id
    private String idDrink;

    private String strDrink;

    private String strCategory;

    private String strAlcoholic;

    private String strIBA;

    private String strGlass;

    private String strDrinkThumb;

    @Lob
    private String strInstructions;

    @ElementCollection
    @Singular
    List<String> ingredients = new ArrayList();

    @ElementCollection
    @Singular
    List<String> measurements = new ArrayList();


}
