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
public class Bill {
    
    private int billId;
    private String billFrom; 
    private String billTo;
    private String billDuration;
    private String billPrice; 
    private String billDate;
    private String total;

    public Bill(int billId, String billFrom, String billTo, String billDuration, String billPrice, String billDate, String total) {
        this.billId = billId;
        this.billFrom = billFrom;
        this.billTo = billTo;
        this.billDuration = billDuration;
        this.billPrice = billPrice;
        this.billDate = billDate;
        this.total = total;
    }

    public Bill(String billFrom, String billTo, String billDuration, String billPrice, String billDate, String total) {
        this.billFrom = billFrom;
        this.billTo = billTo;
        this.billDuration = billDuration;
        this.billPrice = billPrice;
        this.billDate = billDate;
        this.total = total;
    }

    public Bill(int billId) {
        this.billId = billId;
    }

    public Bill(String billPrice) {
        this.billPrice = billPrice;
    }

    
   
    
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillFrom() {
        return billFrom;
    }

    public void setBillFrom(String billFrom) {
        this.billFrom = billFrom;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getBillDuration() {
        return billDuration;
    }

    public void setBillDuration(String billDuration) {
        this.billDuration = billDuration;
    }

    public String getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(String billPrice) {
        this.billPrice = billPrice;
    }

    public String getBillDate() {
        return billDate;
    }
    

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    
   
    
    
}
