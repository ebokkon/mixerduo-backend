package com.codecool.mixerduo2.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class DrinkItem {

	@JsonProperty("strDrinkFR")
	private Object strDrinkFR;

	@JsonProperty("strInstructionsDE")
	private String strInstructionsDE;

	@JsonProperty("strDrinkZH-HANS")
	private Object strDrinkZHHANS;

	@JsonProperty("strDrinkZH-HANT")
	private Object strDrinkZHHANT;

	@JsonProperty("strIngredient10")
	private String strIngredient10;

	@JsonProperty("strDrink")
	private String strDrink;

	@JsonProperty("strIngredient12")
	private String strIngredient12;

	@JsonProperty("strIngredient11")
	private String strIngredient11;

	@JsonProperty("strIngredient14")
	private String strIngredient14;

	@JsonProperty("strCategory")
	private String strCategory;

	@JsonProperty("strAlcoholic")
	private String strAlcoholic;

	@JsonProperty("strIngredient13")
	private String strIngredient13;

	@JsonProperty("strIngredient15")
	private String strIngredient15;

	@JsonProperty("strCreativeCommonsConfirmed")
	private String strCreativeCommonsConfirmed;

	@JsonProperty("strIBA")
	private String strIBA;

	@JsonProperty("strDrinkES")
	private Object strDrinkES;

	@JsonProperty("strVideo")
	private Object strVideo;

	@JsonProperty("strTags")
	private Object strTags;

	@JsonProperty("strInstructions")
	private String strInstructions;

	List<String> ingredients = new ArrayList();

	List<String> measurements = new ArrayList();

	@JsonProperty("strIngredient1")
	private String strIngredient1;

	@JsonProperty("strIngredient3")
	private String strIngredient3;

	@JsonProperty("strIngredient2")
	private String strIngredient2;

	@JsonProperty("strIngredient5")
	private String strIngredient5;

	@JsonProperty("strIngredient4")
	private String strIngredient4;

	@JsonProperty("strIngredient7")
	private String strIngredient7;

	@JsonProperty("strIngredient6")
	private String strIngredient6;

	@JsonProperty("strIngredient9")
	private String strIngredient9;

	@JsonProperty("strInstructionsFR")
	private Object strInstructionsFR;

	@JsonProperty("strIngredient8")
	private String strIngredient8;

	@JsonProperty("idDrink")
	private String idDrink;

	@JsonProperty("strInstructionsES")
	private Object strInstructionsES;

	@JsonProperty("strGlass")
	private String strGlass;

	@JsonProperty("strDrinkDE")
	private Object strDrinkDE;

	@JsonProperty("strMeasure12")
	private String strMeasure12;

	@JsonProperty("strMeasure13")
	private String strMeasure13;

	@JsonProperty("strMeasure10")
	private String strMeasure10;

	@JsonProperty("strMeasure11")
	private String strMeasure11;

	@JsonProperty("dateModified")
	private String dateModified;

	@JsonProperty("strDrinkAlternate")
	private Object strDrinkAlternate;

	@JsonProperty("strDrinkThumb")
	private String strDrinkThumb;

	@JsonProperty("strInstructionsZH-HANT")
	private Object strInstructionsZHHANT;

	@JsonProperty("strMeasure9")
	private String strMeasure9;

	@JsonProperty("strMeasure7")
	private String strMeasure7;

	@JsonProperty("strMeasure8")
	private String strMeasure8;

	@JsonProperty("strMeasure5")
	private String strMeasure5;

	@JsonProperty("strMeasure6")
	private String strMeasure6;

	@JsonProperty("strMeasure3")
	private String strMeasure3;

	@JsonProperty("strMeasure4")
	private String strMeasure4;

	@JsonProperty("strMeasure1")
	private String strMeasure1;

	@JsonProperty("strMeasure2")
	private String strMeasure2;

	@JsonProperty("strInstructionsZH-HANS")
	private Object strInstructionsZHHANS;

	@JsonProperty("strMeasure14")
	private String strMeasure14;

	@JsonProperty("strMeasure15")
	private String strMeasure15;

	public void setIngredients(){
		ingredients.addAll(Arrays.asList(strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15));
	}

	public void setMeasurements(){
		measurements.addAll(Arrays.asList(strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15));
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public List<String> getMeasurements() {
		return measurements;
	}

	public String getStrDrink(){
		return strDrink;
	}

	public String getStrCategory(){
		return strCategory;
	}

	public String getStrAlcoholic(){
		return strAlcoholic;
	}

	public Object getStrIBA(){
		return strIBA;
	}

//	public Object getStrVideo(){
//		return strVideo;
//	}
//
//	public Object getStrTags(){
//		return strTags;
//	}
//
	public String getStrInstructions(){
		return strInstructions;
	}

//	public void setStrIngredient1(String strIngredient1){
//		this.strIngredient1 = strIngredient1;
//	}
//

	public String getIdDrink(){
		return idDrink;
	}

	public String getStrGlass(){
		return strGlass;
	}


//
//	public String getDateModified(){
//		return dateModified;
//	}

	public String getStrDrinkThumb(){
		return strDrinkThumb;
	}

	@Override
 	public String toString(){
		return
			"strDrinkFR = '" + strDrinkFR + '\'' +
			",strInstructionsDE = '" + strInstructionsDE + '\'' +
			",strDrinkZH-HANS = '" + strDrinkZHHANS + '\'' +
			",strDrinkZH-HANT = '" + strDrinkZHHANT + '\'' +
			",strIngredient10 = '" + strIngredient10 + '\'' +
			",strDrink = '" + strDrink + '\'' +
			",strIngredient12 = '" + strIngredient12 + '\'' +
			",strIngredient11 = '" + strIngredient11 + '\'' +
			",strIngredient14 = '" + strIngredient14 + '\'' +
			",strCategory = '" + strCategory + '\'' +
			",strAlcoholic = '" + strAlcoholic + '\'' +
			",strIngredient13 = '" + strIngredient13 + '\'' +
			",strIngredient15 = '" + strIngredient15 + '\'' +
			",strCreativeCommonsConfirmed = '" + strCreativeCommonsConfirmed + '\'' +
			",strIBA = '" + strIBA + '\'' +
			",strDrinkES = '" + strDrinkES + '\'' +
			",strVideo = '" + strVideo + '\'' +
			",strTags = '" + strTags + '\'' +
			",strInstructions = '" + strInstructions + '\'' +
			",strIngredient1 = '" + strIngredient1 + '\'' +
			",strIngredient3 = '" + strIngredient3 + '\'' +
			",strIngredient2 = '" + strIngredient2 + '\'' +
			",strIngredient5 = '" + strIngredient5 + '\'' +
			",strIngredient4 = '" + strIngredient4 + '\'' +
			",strIngredient7 = '" + strIngredient7 + '\'' +
			",strIngredient6 = '" + strIngredient6 + '\'' +
			",strIngredient9 = '" + strIngredient9 + '\'' +
			",strInstructionsFR = '" + strInstructionsFR + '\'' +
			",strIngredient8 = '" + strIngredient8 + '\'' +
			",idDrink = '" + idDrink + '\'' +
			",strInstructionsES = '" + strInstructionsES + '\'' +
			",strGlass = '" + strGlass + '\'' +
			",strDrinkDE = '" + strDrinkDE + '\'' +
			",strMeasure12 = '" + strMeasure12 + '\'' +
			",strMeasure13 = '" + strMeasure13 + '\'' +
			",strMeasure10 = '" + strMeasure10 + '\'' +
			",strMeasure11 = '" + strMeasure11 + '\'' +
			",dateModified = '" + dateModified + '\'' +
			",strDrinkAlternate = '" + strDrinkAlternate + '\'' +
			",strDrinkThumb = '" + strDrinkThumb + '\'' +
			",strInstructionsZH-HANT = '" + strInstructionsZHHANT + '\'' +
			",strMeasure9 = '" + strMeasure9 + '\'' +
			",strMeasure7 = '" + strMeasure7 + '\'' +
			",strMeasure8 = '" + strMeasure8 + '\'' +
			",strMeasure5 = '" + strMeasure5 + '\'' +
			",strMeasure6 = '" + strMeasure6 + '\'' +
			",strMeasure3 = '" + strMeasure3 + '\'' +
			",strMeasure4 = '" + strMeasure4 + '\'' +
			",strMeasure1 = '" + strMeasure1 + '\'' +
			",strMeasure2 = '" + strMeasure2 + '\'' +
			",strInstructionsZH-HANS = '" + strInstructionsZHHANS + '\'' +
			",strMeasure14 = '" + strMeasure14 + '\'' +
			",strMeasure15 = '" + strMeasure15 + '\'' +
			"}";
		}

}