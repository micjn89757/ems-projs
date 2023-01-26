package com.djn.ems.domain;

import com.djn.ems.service.Status;

public class NoteBook extends Equipment{
    private String model;

    public NoteBook() {}

    public NoteBook(int id, String factory, double price, Status status, String model) {
        super(id, factory, price, status);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "model='" + model + '\'' +
                "} " + super.toString();
    }
}
