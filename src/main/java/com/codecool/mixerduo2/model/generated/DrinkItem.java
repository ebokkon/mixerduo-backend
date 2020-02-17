package com.codecool.mixerduo2.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Generated("com.robohorse.robopojogenerator")
public class DrinkItem {

	@Id
	@GeneratedValue
	private Long id;

	@Transient
	@JsonProperty("strDrinkFR")
	private Object strDrinkFR;

	@Transient
	@JsonProperty("strInstructionsDE")
	private String strInstructionsDE;

	@Transient
	@JsonProperty("strDrinkZH-HANS")
	private Object strDrinkZHHANS;

	@Transient
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

	@Transient
	@JsonProperty("strCreativeCommonsConfirmed")
	private String strCreativeCommonsConfirmed;

	@JsonProperty("strIBA")
	private String strIBA;

	@Transient
	@JsonProperty("strDrinkES")
	private Object strDrinkES;

	@Transient
	@JsonProperty("strVideo")
	private Object strVideo;

	@Transient
	@JsonProperty("strTags")
	private Object strTags;

	@Lob
	@JsonProperty("strInstructions")
	private String strInstructions;

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

	@Transient
	@JsonProperty("strInstructionsFR")
	private Object strInstructionsFR;

	@JsonProperty("strIngredient8")
	private String strIngredient8;

	@JsonProperty("idDrink")
	private String idDrink;

	@Transient
	@JsonProperty("strInstructionsES")
	private Object strInstructionsES;

	@JsonProperty("strGlass")
	private String strGlass;

	@Transient
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

	@Transient
	@JsonProperty("dateModified")
	private String dateModified;

	@Transient
	@JsonProperty("strDrinkAlternate")
	private Object strDrinkAlternate;

	@Transient
	@JsonProperty("strDrinkThumb")
	private String strDrinkThumb;

	@Transient
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

	@Transient
	@JsonProperty("strInstructionsZH-HANS")
	private Object strInstructionsZHHANS;

	@JsonProperty("strMeasure14")
	private String strMeasure14;

	@JsonProperty("strMeasure15")
	private String strMeasure15;

//	public void setStrDrinkFR(Object strDrinkFR){
//		this.strDrinkFR = strDrinkFR;
//	}
//
//	public Object getStrDrinkFR(){
//		return strDrinkFR;
//	}
//
//	public void setStrInstructionsDE(String strInstructionsDE){
//		this.strInstructionsDE = strInstructionsDE;
//	}
//
//	public String getStrInstructionsDE(){
//		return strInstructionsDE;
//	}
//
//	public void setStrDrinkZHHANS(Object strDrinkZHHANS){
//		this.strDrinkZHHANS = strDrinkZHHANS;
//	}
//
//	public Object getStrDrinkZHHANS(){
//		return strDrinkZHHANS;
//	}
//
//	public void setStrDrinkZHHANT(Object strDrinkZHHANT){
//		this.strDrinkZHHANT = strDrinkZHHANT;
//	}
//
//	public Object getStrDrinkZHHANT(){
//		return strDrinkZHHANT;
//	}
//
//	public void setStrIngredient10(Object strIngredient10){
//		this.strIngredient10 = strIngredient10;
//	}
//
//	public Object getStrIngredient10(){
//		return strIngredient10;
//	}
//
//	public void setStrDrink(String strDrink){
//		this.strDrink = strDrink;
//	}
//
//	public String getStrDrink(){
//		return strDrink;
//	}
//
//	public void setStrIngredient12(Object strIngredient12){
//		this.strIngredient12 = strIngredient12;
//	}
//
//	public Object getStrIngredient12(){
//		return strIngredient12;
//	}
//
//	public void setStrIngredient11(Object strIngredient11){
//		this.strIngredient11 = strIngredient11;
//	}
//
//	public Object getStrIngredient11(){
//		return strIngredient11;
//	}
//
//	public void setStrIngredient14(Object strIngredient14){
//		this.strIngredient14 = strIngredient14;
//	}
//
//	public Object getStrIngredient14(){
//		return strIngredient14;
//	}
//
//	public void setStrCategory(String strCategory){
//		this.strCategory = strCategory;
//	}
//
//	public String getStrCategory(){
//		return strCategory;
//	}
//
//	public void setStrAlcoholic(String strAlcoholic){
//		this.strAlcoholic = strAlcoholic;
//	}
//
//	public String getStrAlcoholic(){
//		return strAlcoholic;
//	}
//
//	public void setStrIngredient13(Object strIngredient13){
//		this.strIngredient13 = strIngredient13;
//	}
//
//	public Object getStrIngredient13(){
//		return strIngredient13;
//	}
//
//	public void setStrIngredient15(Object strIngredient15){
//		this.strIngredient15 = strIngredient15;
//	}
//
//	public Object getStrIngredient15(){
//		return strIngredient15;
//	}
//
//	public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed){
//		this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
//	}
//
//	public String getStrCreativeCommonsConfirmed(){
//		return strCreativeCommonsConfirmed;
//	}
//
//	public void setStrIBA(Object strIBA){
//		this.strIBA = strIBA;
//	}
//
//	public Object getStrIBA(){
//		return strIBA;
//	}
//
//	public void setStrDrinkES(Object strDrinkES){
//		this.strDrinkES = strDrinkES;
//	}
//
//	public Object getStrDrinkES(){
//		return strDrinkES;
//	}
//
//	public void setStrVideo(Object strVideo){
//		this.strVideo = strVideo;
//	}
//
//	public Object getStrVideo(){
//		return strVideo;
//	}
//
//	public void setStrTags(Object strTags){
//		this.strTags = strTags;
//	}
//
//	public Object getStrTags(){
//		return strTags;
//	}
//
//	public void setStrInstructions(String strInstructions){
//		this.strInstructions = strInstructions;
//	}
//
//	public String getStrInstructions(){
//		return strInstructions;
//	}
//
//	public void setStrIngredient1(String strIngredient1){
//		this.strIngredient1 = strIngredient1;
//	}
//
//	public String getStrIngredient1(){
//		return strIngredient1;
//	}
//
//	public void setStrIngredient3(String strIngredient3){
//		this.strIngredient3 = strIngredient3;
//	}
//
//	public String getStrIngredient3(){
//		return strIngredient3;
//	}
//
//	public void setStrIngredient2(String strIngredient2){
//		this.strIngredient2 = strIngredient2;
//	}
//
//	public String getStrIngredient2(){
//		return strIngredient2;
//	}
//
//	public void setStrIngredient5(Object strIngredient5){
//		this.strIngredient5 = strIngredient5;
//	}
//
//	public Object getStrIngredient5(){
//		return strIngredient5;
//	}
//
//	public void setStrIngredient4(String strIngredient4){
//		this.strIngredient4 = strIngredient4;
//	}
//
//	public String getStrIngredient4(){
//		return strIngredient4;
//	}
//
//	public void setStrIngredient7(Object strIngredient7){
//		this.strIngredient7 = strIngredient7;
//	}
//
//	public Object getStrIngredient7(){
//		return strIngredient7;
//	}
//
//	public void setStrIngredient6(Object strIngredient6){
//		this.strIngredient6 = strIngredient6;
//	}
//
//	public Object getStrIngredient6(){
//		return strIngredient6;
//	}
//
//	public void setStrIngredient9(Object strIngredient9){
//		this.strIngredient9 = strIngredient9;
//	}
//
//	public Object getStrIngredient9(){
//		return strIngredient9;
//	}
//
//	public void setStrInstructionsFR(Object strInstructionsFR){
//		this.strInstructionsFR = strInstructionsFR;
//	}
//
//	public Object getStrInstructionsFR(){
//		return strInstructionsFR;
//	}
//
//	public void setStrIngredient8(Object strIngredient8){
//		this.strIngredient8 = strIngredient8;
//	}
//
//	public Object getStrIngredient8(){
//		return strIngredient8;
//	}
//
//	public void setIdDrink(String idDrink){
//		this.idDrink = idDrink;
//	}
//
//	public String getIdDrink(){
//		return idDrink;
//	}
//
//	public void setStrInstructionsES(Object strInstructionsES){
//		this.strInstructionsES = strInstructionsES;
//	}
//
//	public Object getStrInstructionsES(){
//		return strInstructionsES;
//	}
//
//	public void setStrGlass(String strGlass){
//		this.strGlass = strGlass;
//	}
//
//	public String getStrGlass(){
//		return strGlass;
//	}
//
//	public void setStrDrinkDE(Object strDrinkDE){
//		this.strDrinkDE = strDrinkDE;
//	}
//
//	public Object getStrDrinkDE(){
//		return strDrinkDE;
//	}
//
//	public void setStrMeasure12(Object strMeasure12){
//		this.strMeasure12 = strMeasure12;
//	}
//
//	public Object getStrMeasure12(){
//		return strMeasure12;
//	}
//
//	public void setStrMeasure13(Object strMeasure13){
//		this.strMeasure13 = strMeasure13;
//	}
//
//	public Object getStrMeasure13(){
//		return strMeasure13;
//	}
//
//	public void setStrMeasure10(Object strMeasure10){
//		this.strMeasure10 = strMeasure10;
//	}
//
//	public Object getStrMeasure10(){
//		return strMeasure10;
//	}
//
//	public void setStrMeasure11(Object strMeasure11){
//		this.strMeasure11 = strMeasure11;
//	}
//
//	public Object getStrMeasure11(){
//		return strMeasure11;
//	}
//
//	public void setDateModified(String dateModified){
//		this.dateModified = dateModified;
//	}
//
//	public String getDateModified(){
//		return dateModified;
//	}
//
//	public void setStrDrinkAlternate(Object strDrinkAlternate){
//		this.strDrinkAlternate = strDrinkAlternate;
//	}
//
//	public Object getStrDrinkAlternate(){
//		return strDrinkAlternate;
//	}
//
//	public void setStrDrinkThumb(String strDrinkThumb){
//		this.strDrinkThumb = strDrinkThumb;
//	}
//
//	public String getStrDrinkThumb(){
//		return strDrinkThumb;
//	}
//
//	public void setStrInstructionsZHHANT(Object strInstructionsZHHANT){
//		this.strInstructionsZHHANT = strInstructionsZHHANT;
//	}
//
//	public Object getStrInstructionsZHHANT(){
//		return strInstructionsZHHANT;
//	}
//
//	public void setStrMeasure9(Object strMeasure9){
//		this.strMeasure9 = strMeasure9;
//	}
//
//	public Object getStrMeasure9(){
//		return strMeasure9;
//	}
//
//	public void setStrMeasure7(Object strMeasure7){
//		this.strMeasure7 = strMeasure7;
//	}
//
//	public Object getStrMeasure7(){
//		return strMeasure7;
//	}
//
//	public void setStrMeasure8(Object strMeasure8){
//		this.strMeasure8 = strMeasure8;
//	}
//
//	public Object getStrMeasure8(){
//		return strMeasure8;
//	}
//
//	public void setStrMeasure5(Object strMeasure5){
//		this.strMeasure5 = strMeasure5;
//	}
//
//	public Object getStrMeasure5(){
//		return strMeasure5;
//	}
//
//	public void setStrMeasure6(Object strMeasure6){
//		this.strMeasure6 = strMeasure6;
//	}
//
//	public Object getStrMeasure6(){
//		return strMeasure6;
//	}
//
//	public void setStrMeasure3(String strMeasure3){
//		this.strMeasure3 = strMeasure3;
//	}
//
//	public String getStrMeasure3(){
//		return strMeasure3;
//	}
//
//	public void setStrMeasure4(String strMeasure4){
//		this.strMeasure4 = strMeasure4;
//	}
//
//	public String getStrMeasure4(){
//		return strMeasure4;
//	}
//
//	public void setStrMeasure1(String strMeasure1){
//		this.strMeasure1 = strMeasure1;
//	}
//
//	public String getStrMeasure1(){
//		return strMeasure1;
//	}
//
//	public void setStrMeasure2(String strMeasure2){
//		this.strMeasure2 = strMeasure2;
//	}
//
//	public String getStrMeasure2(){
//		return strMeasure2;
//	}
//
//	public void setStrInstructionsZHHANS(Object strInstructionsZHHANS){
//		this.strInstructionsZHHANS = strInstructionsZHHANS;
//	}
//
//	public Object getStrInstructionsZHHANS(){
//		return strInstructionsZHHANS;
//	}
//
//	public void setStrMeasure14(Object strMeasure14){
//		this.strMeasure14 = strMeasure14;
//	}
//
//	public Object getStrMeasure14(){
//		return strMeasure14;
//	}
//
//	public void setStrMeasure15(Object strMeasure15){
//		this.strMeasure15 = strMeasure15;
//	}
//
//	public Object getStrMeasure15(){
//		return strMeasure15;
//	}

	@Override
 	public String toString(){
		return
			"DrinkItemRepository{" +
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