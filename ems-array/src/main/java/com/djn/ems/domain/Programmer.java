package com.djn.ems.domain;

import java.math.BigDecimal;

public class Programmer extends Employee{
    public Programmer() {
    }

    public Programmer(String name, Integer age, BigDecimal salary) {
        super(name, age, salary);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
