package com.djn.ems.domain;


import java.io.Serial;
import java.math.BigDecimal;
import java.util.Objects;

public class Designer extends Programmer {
    @Serial
    private static final long serialVersionUID = -6765369828079391647L;
    private Double bonus;

    public Designer() {}

    public Designer(String name, Integer age, BigDecimal salary, Equipment equipment, Double bonus) {
        super(name, age, salary, equipment);
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
