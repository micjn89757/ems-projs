package com.djn.ems.service;

public enum Status {
    FREE(0), USED(1), SCRAP(2);

    private final int statusCode;
    private Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
