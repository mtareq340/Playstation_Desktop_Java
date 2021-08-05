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
public class billDrink {
    
    int billDrinkID;
    int billId;
    int drinkId;

    
    public billDrink(int billDrinkID, int billId, int drinkId) {
        this.billDrinkID = billDrinkID;
        this.billId = billId;
        this.drinkId = drinkId;
    }

    public billDrink(int billId, int drinkId) {
        this.billId = billId;
        this.drinkId = drinkId;
    }

    public billDrink(int billDrinkID) {
        this.billDrinkID = billDrinkID;
    }

    
    
    public int getBillDrinkID() {
        return billDrinkID;
    }

    public void setBillDrinkID(int billDrinkID) {
        this.billDrinkID = billDrinkID;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }
    
    
}
