package com.codecool.mixerduo2.model.generated;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DrinksResponse {

	@JsonProperty("drinks")
	private List<DrinkItem> drinks;

	public void setDrinks(List<DrinkItem> drinks){
		this.drinks = drinks;
	}

	public List<DrinkItem> getDrinks(){
		return drinks;
	}

	@Override
 	public String toString(){
		return 
			"DrinksResponse{" +
			"drinks = '" + drinks + '\'' + 
			"}";
		}
}