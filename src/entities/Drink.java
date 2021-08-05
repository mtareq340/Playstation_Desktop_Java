/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mostafa
 */
public class Drink {
    int drinkId;
    String drinkName;
    String drinkPrice;

    public Drink(int drinkId, String drinkName, String drinkPrice) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public Drink(String drinkName, String drinkPrice) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public Drink(int drinkId) {
        this.drinkId = drinkId;
    }

    
    
    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(String drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
    
    
}
