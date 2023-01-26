package com.djn.ems.service;

import java.util.Objects;

public enum Status {
    FREE(0, "空闲"),
    USED(1, "在用"),
    SCRAP(2, "报废");

    private final int statusCode;
    private final String info;
    private Status(int statusCode, String info) {
        this.statusCode = statusCode;
        this.info = info;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
