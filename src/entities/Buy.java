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
public class Buy {
    
    int buyId;
    String buyName;
    String buyPrice;
    String buyDate;
    String buyTime;

    public Buy(int buyId, String buyName, String buyPrice, String buyDate, String buyTime) {
        this.buyId = buyId;
        this.buyName = buyName;
        this.buyPrice = buyPrice;
        this.buyDate = buyDate;
        this.buyTime = buyTime;
    }

    public Buy(String buyName, String buyPrice, String buyDate, String buyTime) {
        this.buyName = buyName;
        this.buyPrice = buyPrice;
        this.buyDate = buyDate;
        this.buyTime = buyTime;
    }

    public Buy(String buyName, String buyPrice) {
        this.buyName = buyName;
        this.buyPrice = buyPrice;
    }

    public Buy(int buyId, String buyName, String buyPrice) {
        this.buyId = buyId;
        this.buyName = buyName;
        this.buyPrice = buyPrice;
    }

    public Buy(int buyId) {
        this.buyId = buyId;
    }

    
    public int getBuyId() {
        return buyId;
    }

    public void setBuyId(int buyId) {
        this.buyId = buyId;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    
    
    
}
