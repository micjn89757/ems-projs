package com.djn.ems.domain;

import com.djn.ems.service.Status;

public abstract class Equipment {
    private int id;
    private String factory;
    private double price;
    private Status status;

    public Equipment() {}

    public Equipment(int id, String factory, double price, Status status) {
        this.id = id;
        this.factory = factory;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", factory='" + factory + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
