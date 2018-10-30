package com.example.mahfuz.retrofitexample;

import java.io.Serializable;

/**
 * Created by mahfuz on 8/6/18.
 */

class Product implements Serializable{

    private int id;
    private String name;
    private double price;

    Product() {}

    public Product(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
