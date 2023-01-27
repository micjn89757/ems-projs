package com.djn.ems.domain;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Objects;

public class Programmer extends Employee{
    @Serial
    private static final long serialVersionUID = -6516172310562801479L;
    private Equipment equipment;
    public Programmer() {}

    public Programmer(String name, Integer age, BigDecimal salary, Equipment equipment) {
        super(name, age, salary);
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "equipment=" + equipment +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return Objects.equals(equipment, that.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipment);
    }
}
