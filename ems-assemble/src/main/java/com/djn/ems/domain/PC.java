package com.djn.ems.domain;

import com.djn.ems.service.Status;

public class PC extends Equipment{
    private String display;

    public PC() {}

    public PC(int id, String factory, double price, Status status, String display) {
        super(id, factory, price, status);
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "PC{" +
                "display='" + display + '\'' +
                "} " + super.toString();
    }
}
