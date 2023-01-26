package com.djn.ems.domain;

import com.djn.ems.service.Status;

public class NotePad extends Equipment{
    public NotePad() {}

    public NotePad(int id, String factory, double price, Status status) {
        super(id, factory, price, status);
    }
}
