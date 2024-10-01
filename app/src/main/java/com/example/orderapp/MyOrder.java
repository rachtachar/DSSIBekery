package com.example.orderapp;

public class MyOrder {
    private String selectedOrder;
    private String orderName;
    private String bakery;
    private String ice;
    private String drink;

    // Constructor with String argument
    public MyOrder(String bakery, String ice,String drink) {
        this.bakery = bakery;
        this.ice = ice;
        this.drink = drink;
    }

    // Getter method for selectedOrder
    public String getSelectedOrder() {
        return selectedOrder;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getDrink() {
        return drink;
    }

    public String getIce() {
        return ice;
    }

    public String getBakery() {
        return bakery;
    }

    public void setSelectedOrder(String selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public void setBakery(String bakery) {
        this.bakery = bakery;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}

