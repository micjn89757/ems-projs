package com.djn.ems.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Architect extends Designer {
    private int stock;

    public Architect() {}

    public Architect(String name, Integer age, BigDecimal salary, Double bonus, int stock) {
        super(name, age, salary, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Architect{" +
                "stock=" + stock +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Architect architect = (Architect) o;
        return stock == architect.stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
