package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.generated.DrinkItem;
import com.codecool.mixerduo2.model.generated.DrinksResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CocktailDAOMemTest {
    CocktailDAOMem testCocktailDAOMem = new CocktailDAOMem();
    DrinksResponse testDrinkResponse = new DrinksResponse();
    DrinksResponse testDrinkResponse2 = new DrinksResponse();
//
//    @BeforeEach
//    void setUp(){
//        List<DrinkItem> testDrinks = new ArrayList<>();
//        DrinkItem testDrinkItem1 = new DrinkItem();
//        testDrinkItem1.setStrDrink("test Cocktail 1");
//        testDrinkItem1.setIdDrink("1");
//        DrinkItem testDrinkItem2 = new DrinkItem();
//        testDrinkItem2.setStrDrink("test Cocktail 2");
//        testDrinkItem2.setIdDrink("2");
//        testDrinks.add(testDrinkItem1);
//        testDrinks.add(testDrinkItem2);
//        testDrinkResponse.setDrinks(testDrinks);
//
//        List<DrinkItem> testDrinks2 = new ArrayList<>();
//        DrinkItem testDrinkItem3 = new DrinkItem();
//        testDrinkItem3.setIdDrink("3");
//        testDrinkItem3.setStrDrink("test Cocktail 3");
//        testDrinks2.add(testDrinkItem3);
//        testDrinkResponse2.setDrinks(testDrinks2);
//    }
//
//
//    @Test
//    void testAddReturnsCorrectCocktailListLength(){
//        testCocktailDAOMem.add(testDrinkResponse);
//        assertEquals(1, testCocktailDAOMem.getCocktailList().size());
//    }
//
//    @Test
//    void testGetCocktailByIdReturnsCorrectDrinkItem(){
//        testCocktailDAOMem.add(testDrinkResponse);
//        testCocktailDAOMem.add(testDrinkResponse2);
//        DrinkItem result = testCocktailDAOMem.getCocktailById(3);
//        assertEquals("test Cocktail 3", result.getStrDrink());
//    }
//
//    @Test
//    void testCocktailByIdReturnsNullWhenNoItemFound(){
//        testCocktailDAOMem.add(testDrinkResponse);
//        DrinkItem result = testCocktailDAOMem.getCocktailById(3);
//        assertNull(result);
//    }

}