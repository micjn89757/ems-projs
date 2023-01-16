package com.djn.ems.domain;


import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Designer extends Programmer {
    private Double bonus;

    public Designer() {}

    public Designer(String name, Integer age, BigDecimal salary, Double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "bonus=" + bonus +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Designer designer = (Designer) o;
        return Objects.equals(bonus, designer.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}
