package model;

import java.sql.Date;

public class Transaction {
    private int transactionId;
    private int buyerId;
    private int itemId;
    private double price;
    private Date transactionDate;
    private int quantity;

    public Transaction(int transactionId, int buyerId, int itemId, double price, Date transactionDate, int quantity) {
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.itemId = itemId;
        this.price = price;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
    }

     public Transaction() {
    	 
     }
    
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

